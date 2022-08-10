package com.techtree.userinterface.entity;

public class UserBean {
	
	private long uid;
	private String mobilenumber;
	private String password;
	private String confirmpassword;
	
	
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
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}	
}
