package com.akira.in.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name = "AUI_SUMMARY", catalog = "akira")
public class AuiSummary {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "sid",  nullable = false)
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	
	
	@Column(name = "LogDate", nullable = false, length = 12)
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Column(name = "URLRequested", nullable = false, length = 255)
	public String getUrlRequested() {
		return urlRequested;
	}
	public void setUrlRequested(String urlRequested) {
		this.urlRequested = urlRequested;
	}
	
	@Column(name = "FailureStatusCode",  nullable = false, length = 100)
	public Integer getFailureStatusCode() {
		return failureStatusCode;
	}
	public void setFailureStatusCode(Integer failureStatusCode) {
		this.failureStatusCode = failureStatusCode;
	}
	
	@Column(name = "SuccessStatusCode",  nullable = false, length = 100)
	public Integer getSuccessStatusCode() {
		return successStatusCode;
	}
	public void setSuccessStatusCode(Integer successStatusCode) {
		this.successStatusCode = successStatusCode;
	}
	
	@Column(name = "AverageTimeInMicro",  nullable = false, length = 100)
	public Integer getAverageTimeInMicro() {
		return averageTimeInMicro;
	}
	public void setAverageTimeInMicro(Integer averageTimeInMicro) {
		this.averageTimeInMicro = averageTimeInMicro;
	}
	private Integer sid;
	private String date;
	private String urlRequested;
	private Integer failureStatusCode;
	private Integer successStatusCode;
	private Integer redirectStatusCode;
	@Column(name = "RedirectStatusCode",  nullable = false, length = 100)
	public Integer getRedirectStatusCode() {
		return redirectStatusCode;
	}
	public void setRedirectStatusCode(Integer redirectStatusCode) {
		this.redirectStatusCode = redirectStatusCode;
	}
	private Integer averageTimeInMicro;
	
}
