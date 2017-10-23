package com.ef.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ef.persistence.entity.ForbiddenIpTable;
import com.ef.persistence.entity.IpTable;
import com.ef.persistence.repository.IpTableRepository;

@Service
public class IpTableService {
	
	private final IpTableRepository ipTableRepository;
	
	@Autowired
	public IpTableService(IpTableRepository ipTableRepository) {
		this.ipTableRepository=ipTableRepository;
	}
	
	
	public void save(Date date,String ipAddress,String requestType,Integer responseType,String browserType) {
		IpTable ipTable = new IpTable();
		ipTable.setBrowserType(browserType);
		ipTable.setDate(date);
		ipTable.setIpAddress(ipAddress);
		ipTable.setRequestType(requestType);
		ipTable.setResponseType(responseType);
		ipTableRepository.save(ipTable);		
	}
	
	public List<ForbiddenIpTable> findIpAddresses(Long threshHold, Date beginDate,Date endDate){
		
		return ipTableRepository.findIpAddressesByDate(threshHold,beginDate, endDate);
		
	}

}
