package com.ef;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ef.persistence.entity.ForbiddenIpTable;
import com.ef.persistence.repository.ForbiddenIpTableRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParserTestHourly {
	
	@Autowired
	private ForbiddenIpTableRepository forbiddenIpTableRepository;
	
	
	 static {
	        System.setProperty("startDate","2017-01-01.15:00:00");
	        System.setProperty("duration","hourly");
	        System.setProperty("threshold","200");
	     
	     //   --startDate=2017-01-01.13:00:00 --duration=hourly --threshold=100
	    }

	@Test
	public void test() {
		List<ForbiddenIpTable> list = forbiddenIpTableRepository.findAll();
		for(ForbiddenIpTable forbiddenIpTable:list) {
			System.out.println(forbiddenIpTable.getIpAddress() +" " + forbiddenIpTable.getTotalRequestCount()  + " " + forbiddenIpTable.getBanReason() );
		}
	}

}
