package com.example.relations.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.relations.bean.AddressBean;
import com.example.relations.bean.EmployeeBean;
import com.example.relations.entity.Address;
import com.example.relations.entity.Employee;
import com.example.relations.repository.EmployeeRepository;
import com.example.relations.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository repository;

	@Override
	public ResponseEntity<Object> saveAll(EmployeeBean employee) {
		try {
			if (employee != null) {
				Employee e = new Employee();
				e.setEmpId(employee.getEmpId());
				e.setName(employee.getName());
				e.setAge(employee.getAge());

				List<AddressBean> addList = employee.getAddress();

				List<Address> newAddList = new ArrayList<>();
				
				for (int i = 0; i < addList.size(); i++) {
					Address a = new Address();
					AddressBean add = addList.get(i);
					a.setAddressId(add.getAddressId());
					a.setCity(add.getCity());
					newAddList.add(a);
					
					a.getEmployee().add(e);

					e.getAddress().add(a);
				}
				e.setAddress(newAddList);
				Employee emp = repository.save(e);
				return new ResponseEntity<Object>(emp.getEmpId(), HttpStatus.OK);
				
			} else {
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

//	@Override
//	public ResponseEntity<Object> saveAll(EmployeeBean employee) {
//		try {
//			if(employee!=null) {
//				Employee e=new Employee();
//				e.setEmpId(employee.getEmpId());
//				e.setName(employee.getName());
//				e.setAge(employee.getAge());
//				
//				List<AddressBean> addList=employee.getAddress();
//			
//				List<Address> newAddList=new ArrayList<>();
//				for(int i=0;i<addList.size();i++){
//					Address a=new Address();
//					AddressBean add=addList.get(i);
//					a.setAddressId(add.getAddressId());
//					a.setCity(add.getCity());
//				    a.setEmployee(e);
//					newAddList.add(a);
//				}
//					e.setAddress(newAddList);
//					Employee emp=repository.save(e);
//					return new ResponseEntity<Object>(emp.getEmpId(), HttpStatus.OK);
//				}else {
//					return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
//				}
//		}catch(Exception e) {
//			e.printStackTrace();
//			}
//		return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
//	}

//	@Override
//	public ResponseEntity<Object> save(EmployeeBean employee) {
//		try {
//			if(employee!=null) {
//				Employee e=new Employee();
//				e.setEmpId(employee.getEmpId());
//				e.setName(employee.getName());
//				e.setAge(employee.getAge());
//				AddressBean add=employee.getAddress();
//				Address a=new Address();
//				a.setAddressId(add.getAddressId());
//				a.setCity(add.getCity());
//				e.setAddress(a);
//				Employee emp=repository.save(e);
//				return new ResponseEntity<Object>(emp.getEmpId(),HttpStatus.OK); 
//			}else {
//				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
//			}
//		}catch(Exception e) {
//				e.printStackTrace();
//			}
//		return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}		
}
