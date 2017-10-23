package com.ef.processor;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ef.persistence.repository.IpTableRepository;
import com.ef.service.IpTableService;

@Service
public class ParserProcessor {
	
	private DateFormat dateFormat;
	
	private final IpTableService ipTableService;
	
	@Autowired
	public ParserProcessor(IpTableService ipTableService) {
		dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		this.ipTableService = ipTableService;
	}
	
	
	public void parseLine(String line) throws ParseException {
	String [] logArray =	line.split("\\|");
	Date date = dateFormat.parse(logArray[0]);
	String ipAddress = logArray[1];
	String requestType = logArray[2];
	Integer responseType = Integer.parseInt(logArray[3]);
	String browserType = logArray[4];
	ipTableService.save(date, ipAddress, requestType, responseType, browserType);
 	
	}

}
