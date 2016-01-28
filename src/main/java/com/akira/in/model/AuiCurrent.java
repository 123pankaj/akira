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
@Table(name = "AUI_CURRENT", catalog = "akira")
public class AuiCurrent {
	
	
	private Integer id;
	private Date time;
	private String endpoint;
	private String remoteHostName;
	private String requestMethod;
	private String urlRequested;
	private String queryString;
	
	private String statusCode;
	private Integer byteSent;
	private Integer timeInMicro;
	private String processId;
	private String ReferHead;
	private String userAgent;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id",  nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time", nullable = false, length = 0)
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Column(name = "Endpoint",  nullable = false, length = 100)
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	@Column(name = "RemoteHostName",  nullable = false, length = 100)
	public String getRemoteHostName() {
		return remoteHostName;
	}
	public void setRemoteHostName(String remoteHostName) {
		this.remoteHostName = remoteHostName;
	}
	@Column(name = "RequestMethod",  nullable = false, length = 100)
	public String getRequestMethod() {
		return requestMethod;
	}
	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}
	@Column(name = "URLRequested", nullable = false, length = 255)
	public String getUrlRequested() {
		return urlRequested;
	}
	public void setUrlRequested(String urlRequested) {
		this.urlRequested = urlRequested;
	}
	@Column(name = "QueryStr",  nullable = false, length = 255)
	public String getQueryString() {
		return queryString;
	}
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
	@Column(name = "statusCode", nullable = false, length = 100)
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	@Column(name = "byteSent",  nullable = false, length = 100)
	public Integer getByteSent() {
		return byteSent;
	}
	public void setByteSent(Integer byteSent) {
		this.byteSent = byteSent;
	}
	@Column(name = "TimeInMicro",  nullable = false)
	public Integer getTimeInMicro() {
		return timeInMicro;
	}
	public void setTimeInMicro(Integer timeInMicro) {
		this.timeInMicro = timeInMicro;
	}
	@Column(name = "ProcessId",  nullable = false)
	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	@Column(name = "ReferHead",  nullable = false)
	public String getReferHead() {
		return ReferHead;
	}
	public void setReferHead(String referHead) {
		ReferHead = referHead;
	}
	@Column(name = "userAgent",  nullable = false)
	public String getUserAgent() {
		return userAgent;
	}
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	@Override
	public String toString() {
		return "AuiCurrent [time=" + time + ", endpoint=" + endpoint
				+ ", remoteHostName=" + remoteHostName + ", requestMethod="
				+ requestMethod + ", urlRequested=" + urlRequested
				+ ", statusCode=" + statusCode + ", byteSent=" + byteSent
				+ ", timeInMicro=" + timeInMicro + ", processId=" + processId
				+ ", ReferHead=" + ReferHead + ", userAgent=" + userAgent + "]";
	}
	
}
