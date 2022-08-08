package com.example.relations.entity;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.transaction.Transactional;
@Entity
@Transactional
@NoArgsConstructor
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eid")
    private Long empId;
    @Column(name="name")
    private String name;
    @Column(name="age")
    private Integer age;
    
//	@OneToOne(cascade = CascadeType.ALL)
//    private Address address;
//    
//    @OneToMany(cascade=CascadeType.ALL, mappedBy="employee")
//    private List<Address> address;
//    
    @ManyToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Address> address= new ArrayList<Address>();
   

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}
	

//	public Address getAddress() {
//		return address;
//	}
//
//	public void setAddress(Address address) {
//		this.address = address;
//	}
}
