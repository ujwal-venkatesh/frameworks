package com.example.relations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.relations.entity.Address;
import com.example.relations.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Address save(Address address);
}