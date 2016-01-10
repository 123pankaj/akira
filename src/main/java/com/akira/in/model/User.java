package com.akira.in.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "userLogin", catalog = "akira")
public class User implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6550818115600361418L;

	private Integer uid;
	private String uname;
	private String email;
	private Boolean isAdmin;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "uid", unique = true, nullable = false, length = 20)
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	@Column(name = "uname", nullable = false, length = 20)
	public String getUname() {
		return uname;
	}
	
	public void setUname(String uname) {
		this.uname = uname;
	}
	@Column(name = "email", nullable = false, length = 50)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "isAdmin", nullable = false, length = 1)
	public Boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", email=" + email
				+ ", isAdmin=" + isAdmin + "]";
	}
}
