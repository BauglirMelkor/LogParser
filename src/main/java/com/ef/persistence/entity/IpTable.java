package com.ef.persistence.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class IpTable {
	
	@Id
    @GeneratedValue
    @Column(name="id")
    private Long id;
	 @Column(name="date")
	private Date date; 
	 @Column(name="ipAddress")
	private String ipAddress;
	 @Column(name="requestType")
	private String requestType;
	 @Column(name="responseType")
	private Integer responseType;
	 @Column(name="browserType")
	private String browserType;
	 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	public Integer getResponseType() {
		return responseType;
	}
	public void setResponseType(Integer responseType) {
		this.responseType = responseType;
	}
	public String getBrowserType() {
		return browserType;
	}
	public void setBrowserType(String browserType) {
		this.browserType = browserType;
	}

}
