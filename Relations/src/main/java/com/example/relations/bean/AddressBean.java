package com.example.relations.bean;

import java.util.List;

public class AddressBean {
	private Long addressId;
	private String city;
	private String addresstype;
	
//	private EmployeeBean employee;
	
	private List<EmployeeBean> employee;
	
	public List<EmployeeBean> getEmployee() {
		return employee;
	}
	public void setEmployee(List<EmployeeBean> employee) {
		this.employee = employee;
	}
	public String getAddresstype() {
		return addresstype;
	}
	public void setAddresstype(String addresstype) {
		this.addresstype = addresstype;
	}
//	public EmployeeBean getEmployee() {
//		return employee;
//	}
//	public void setEmployee(EmployeeBean employee) {
//		this.employee = employee;
//	}
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	

}
