package com.jproduction.ems.Model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(MemberId.class)
public class Member{

	@Id
	private int mid;
	private String firstName;
	private String lastName;
	
	@Id
	private String email;
	private Date createtime;
	private Date updatetime;
	
	/**
	 * 
	 */
	public Member() {
		super();
	}

	/**
	 * @param mid
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param password
	 * @param createtime
	 * @param updatetime
	 */
	public Member(int mid, String firstName, String lastName, String email, String password, Date createtime,
			Date updatetime) {
		super();
		this.mid = mid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.createtime = createtime;
		this.updatetime = updatetime;
	}
	
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	
}
