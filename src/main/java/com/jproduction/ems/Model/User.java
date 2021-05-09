package com.jproduction.ems.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user", schema = "ems_auth")
public class User {
	
	@Id
	private String username;
	private String password;
	private Date updatetime;
	
	
	/**
	 * 
	 */
	public User() {
		super();
	}
	
	/**
	 * @param username
	 * @param password
	 * @param updatetime
	 */
	public User(String username, String password, Date updatetime) {
		super();
		this.username = username;
		this.password = password;
		this.updatetime = updatetime;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
}
