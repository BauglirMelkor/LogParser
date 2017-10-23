package com.ef.persistence.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ForbiddenIpTable {
	
	@Id
    @GeneratedValue
    @Column(name="id")
    private Long id;
	
	@Column(name="ip_address")
    private String ipAddress;
	
	@Column(name="ban_date")
    private Date banDate;
    
    @Column(name="ban_reason")
    private String banReason;
    
    @Column(name="totalRequestCount")
    private Long totalRequestCount;
    
    public ForbiddenIpTable(String ipAddress,Long totalRequestCount) {
	   this.ipAddress=ipAddress;
	   this.totalRequestCount=totalRequestCount;
    }
    
    public ForbiddenIpTable() {
 	  
     }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Date getBanDate() {
		return banDate;
	}

	public void setBanDate(Date banDate) {
		this.banDate = banDate;
	}

	public String getBanReason() {
		return banReason;
	}

	public void setBanReason(String banReason) {
		this.banReason = banReason;
	}

	public Long getTotalRequestCount() {
		return totalRequestCount;
	}

	public void setTotalRequestCount(Long totalRequestCount) {
		this.totalRequestCount = totalRequestCount;
	}
    


}
