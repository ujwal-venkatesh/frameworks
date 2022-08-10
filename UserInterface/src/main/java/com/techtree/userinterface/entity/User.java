package com.techtree.userinterface.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name="User")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="User_ID")
	private long uid;
	@Column(name="Mobile_Number",unique=true)
	private String mobilenumber;
	@Column(name="Password")
	private String password;
	@CreationTimestamp	
	@Column(name="Registration_Date_Time")
	private Date registeredtime;
	
	public Date getRegisteredtime() {
		return registeredtime;
	}

	public void setRegisteredtime(Date registeredtime) {
		this.registeredtime = registeredtime;
	}

	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private UserProfile userProfile;

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public boolean setUid(UserBean user) {
		return false;
	}
	
	
}
