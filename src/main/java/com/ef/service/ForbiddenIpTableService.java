package com.ef.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ef.persistence.entity.ForbiddenIpTable;
import com.ef.persistence.repository.ForbiddenIpTableRepository;


@Service
public class ForbiddenIpTableService {
	
	private final ForbiddenIpTableRepository forbiddenIpTableRepository;

	@Autowired
	public ForbiddenIpTableService(ForbiddenIpTableRepository forbiddenIpTableRepository) {
		this.forbiddenIpTableRepository = forbiddenIpTableRepository;	
	}
	
	public void save(ForbiddenIpTable forbiddenIpTable) {
		try {
			forbiddenIpTableRepository.save(forbiddenIpTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
