package com.example.relations.bean;

import java.util.List;

public class EmployeeBean {
	private Long empId;
	private String name;
	private int age;
	
//	private AddressBean address;
	
	private List<AddressBean> address;
	
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
//	public AddressBean getAddress() {
//		return address;
//	}
//	public void setAddress(AddressBean address) {
//		this.address = address;
//	}
	
	public List<AddressBean> getAddress() {
		return address;
	}
	public void setAddress(List<AddressBean> address) {
		this.address = address;
	}
	
	
	
	
	

}
