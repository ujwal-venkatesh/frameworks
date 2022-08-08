package com.example.relations.entity;


import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.transaction.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Transactional
@NoArgsConstructor
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aid")
    private Long addressId;
    @Column(name = "city")
    private String city;
    
//    @OneToOne(mappedBy = "address")
//    private Employee employee;
    
//  @ManyToOne
//  @JoinColumn(name="eid")
//  private Employee employee;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_address",
            joinColumns = @JoinColumn(name = "aid"),
            inverseJoinColumns = @JoinColumn(name = "eid"))
//    @JsonIgnore
    private List<Employee> employee = new ArrayList<>();


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
	

//	public Employee getEmployee() {
//		return employee;
//	}
//
//	public void setEmployee(Employee employee) {
//		this.employee = employee;
//	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}





}


