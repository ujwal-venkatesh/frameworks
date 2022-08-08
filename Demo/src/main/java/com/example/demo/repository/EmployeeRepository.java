package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee>  findByFnameContainingIgnoreCaseOrLnameContainingIgnoreCaseOrEmailContainingIgnoreCase(
			String fname, String lname, String email);

//	List<Employee> findByFnameOrLnameOrEmail(int offset, int pagesize, String fname, String lname, String email);



	List<Page<Employee>> findByFnameOrLnameOrEmail(String fname, String lname, String email,PageRequest of, Direction desc);

//	@Query("select p from emp p where p.first_name like %:input%")
//	List<Employee> findByFname(String input);

}
