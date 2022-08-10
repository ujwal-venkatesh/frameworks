package com.techtree.userinterface.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.UpdateTimestamp;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="User_Prifile")
public class UserProfile {
	
	@Id
	@GenericGenerator(name = "ProfileIdGenerator", strategy = "foreign",parameters = @Parameter(name = "property",value = "user"))
	@GeneratedValue(generator = "ProfileIdGenerator")
	@Column(name="User_ID")
	private long uid;
	@Column(name="First_Name")
	private String firstname;
	@Column(name="Last_Name")
	private String lastname;
	@Column(name="Email_Id")
	private String email;
	@UpdateTimestamp
	@Column(name="Updation_Date_Time")
	private Date updationtime;
	
	@OneToOne(mappedBy="userProfile")
	@PrimaryKeyJoinColumn
	public User user;

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
