package com.ef;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.ef.persistence.entity.ForbiddenIpTable;
import com.ef.service.ForbiddenIpTableService;
import com.ef.service.IpTableService;
import com.ef.util.EfFileReader;

@SpringBootApplication
@EnableJpaRepositories
public class Parser implements CommandLineRunner{
	
	
	private final EfFileReader efFileReader;
	private final IpTableService ipTableService;
	private final ForbiddenIpTableService forbiddenIpTableService;
	private final Environment env;
	
	@Autowired
	public Parser(EfFileReader efFileReader,IpTableService ipTableService,ForbiddenIpTableService forbiddenIpTableService,Environment env) {
		this.efFileReader = efFileReader;
		this.ipTableService = ipTableService;
		this.forbiddenIpTableService = forbiddenIpTableService;
		this.env=env;
	}

	public static void main(String[] args) {
		SpringApplication.run(Parser.class, args);
	}
	
	@Override
    public void run(String[] args) throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd.HH:mm:ss");
		
		String startDateStr = env.getProperty("startDate");
		String duration = env.getProperty("duration");
		String thresholdStr = env.getProperty("threshold");
		
		Date startDate = dateFormat.parse(startDateStr);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		
		if(duration.equals("hourly")) {
			cal.add(Calendar.HOUR, 1);
		} else if(duration.equals("daily")) {
			cal.add(Calendar.DATE, 1);
		} else {
			System.out.println("duration can be either hourly or daily");
			return;
		}
		
		Long threshold=0l;
		try {
			threshold = Long.parseLong(thresholdStr);
		} catch(Exception e) {
			e.printStackTrace();
			return;
		}
		
		Date today = new Date();
		String banReason = "Threshhole exceeded: "+ threshold;
		efFileReader.getFile("access.log");
		List<ForbiddenIpTable> forbiddenIpList = ipTableService.findIpAddresses(threshold,startDate,cal.getTime());
		for(ForbiddenIpTable fit:forbiddenIpList) {
			fit.setBanDate(today);
			fit.setBanReason(banReason);
			forbiddenIpTableService.save(fit);
			System.out.println("IP ADDRESS: "+ fit.getIpAddress()+ " TOTAL REQUEST COUNT: " + fit.getTotalRequestCount());
		}
       

    }
	
}
