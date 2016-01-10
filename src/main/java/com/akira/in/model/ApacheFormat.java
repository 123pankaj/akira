package com.akira.in.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "apacheFormat", catalog = "akira")
public class ApacheFormat implements java.io.Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8710790264622657503L;
	
	private Integer afid;
	private String formatString;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "afid", unique = true, nullable = false)
	public Integer getAfid() {
		return afid;
	}
	public void setAfid(Integer afid) {
		this.afid = afid;
	}
	@Column(name = "logFormat", unique = true, nullable = false, length = 100)
	public String getFormatString() {
		return formatString;
	}
	public void setFormatString(String formatString) {
		this.formatString = formatString;
	}

}
