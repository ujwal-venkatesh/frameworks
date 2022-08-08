package com.example.demo.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.response.Response;
import com.example.demo.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository repository;

	public ResponseEntity<Object> saveEmployee(Employee employee) {
		Employee e=repository.save(employee);
		return new ResponseEntity<Object>(e, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> getEmployee() {
		JSONObject obj = new JSONObject();
		try {
		List<Employee> emplist=repository.findAll();
		if (emplist!=null && !emplist.isEmpty()) {
			obj.put("response", repository.findAll());
			return new ResponseEntity<Object>(obj, HttpStatus.OK);
		} else {
			obj.put("empty", new ArrayList<Employee>());
			return new ResponseEntity<Object>(obj, HttpStatus.NOT_FOUND);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	 return new ResponseEntity<Object>("empty list", HttpStatus.NOT_FOUND);
	}


	
	public ResponseEntity<Object> searchByAll(String fname, String lname, String email) throws Exception {
	JSONObject e1 = new JSONObject();
		try {	
			
			List<Employee> e = repository
					.findByFnameContainingIgnoreCaseOrLnameContainingIgnoreCaseOrEmailContainingIgnoreCase(fname, lname,
							email);
			if (null!=e && !e.isEmpty()) {
				e1.put("value", e);
				System.out.println(e1);
				return new ResponseEntity<Object>(e1, HttpStatus.OK);
			} else {
				e1.put("value", new ArrayList<Employee>());
				return new ResponseEntity<Object>(e1, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return new ResponseEntity<Object>("not found", HttpStatus.BAD_REQUEST);
		
	
	}
	@Override
	public ResponseEntity<Response<Page<Employee>>> srhByAll( String fname, String lname, String email, int offset, int pagesize) {
		List<JSONObject> list = new ArrayList<>();
		try {
			
			List<Page<Employee>> e = repository.findByFnameOrLnameOrEmail(fname, lname, email, PageRequest.of(offset, pagesize),Sort.Direction.DESC);
			System.out.println(e);
		for (int i = 0; i < e.size(); i++) {
				JSONObject e1 = new JSONObject();
				e1.put("name", e.get(i).getTotalElements());
				e1.put("test", "new key");
				list.add(e1);
				
				/*
				 * Gson gson = new Gson(); ObjectMapper mapper = new ObjectMapper();
				 * System.out.println(mapper.writeValueAsString(e.get(i))); org.json.JSONObject
				 * json1 = new org.json.JSONObject(mapper.writeValueAsString(e.get(i).get));
				 * System.out.println(mapper.writeValueAsString(e.get(i))); //
				 * org.json.JSONObject j=(json1.get("fname"); String s=json1.getString("fname");
				 * System.out.println(s); Object obj=json1.get("fname");
				 * System.out.println(obj); json1.put("test", "new key"); list.add(json1);
				 * 
				 */
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
//		
//		res.setResponse(repository.findAll(PageRequest.of(offset, pagesize, Sort.Direction.DESC, "id")));
//		
//		public ResponseEntity<Object> srhByAll(String fname, String lname, String email) {
//			JSONObject e1 = new JSONObject();
//			List<org.json.JSONObject> list = new ArrayList<>();
//			try {
//				List<Employee> e = repository.findByFnameOrLnameOrEmail(fname, lname, email);
//				for(int i=0;i<e.size();i++) {
//					Gson gson = new Gson();
//					String json=gson.toJson(e);
//					JSONObject j=new JSONObject(json);
//					j.put("key", "new kay");
//					System.out.println(j);
//					list.add(j);
//					Object j
//				
//					
//				}
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//			return new ResponseEntity<Object>(list, HttpStatus.OK);
/*
		
		String json=JSONArray.toJSONString(e);
		System.out.println(json);
		for(int i=0;i<=json.length();i++) {
			
			return new ResponseEntity<Object>("key"+json, HttpStatus.OK);
		}
		
		if (e != null &&!e.isEmpty()) {
			e1.put("value", e);
			return new ResponseEntity<Object>(e1, HttpStatus.OK);
		} else {
			e1.put("response", new ArrayList<Employee>());
			return new ResponseEntity<Object>(e1, HttpStatus.NOT_FOUND);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		 return new ResponseEntity<Object>("not found", HttpStatus.NOT_FOUND); 
*/


//	@Override
//	public ResponseEntity<Object> ExactsearchByAll(String fname, String lname, String email) {
//		TreeMap<String, List<Employee>> ro = new TreeMap<String, List<Employee>>();
//		if (repository.findByFnameOrLnameOrEmail(fname, lname, email) != null) {
//			ro.put("response", repository.findByFnameOrLnameOrEmail(fname, lname, email));
//			return new ResponseEntity<Object>(ro, HttpStatus.OK);
//		} else {
//			ro.put("response", new ArrayList<Employee>());
//			return new ResponseEntity<Object>(ro, HttpStatus.NOT_FOUND);
//		}
//	}

	@Override
	public ResponseEntity<Response<List<Employee>>> findEmployeeWithSorting(String field) {
		Response<List<Employee>> res = new Response<List<Employee>>();
		res.setMessage("sort by desc");
		res.setResponse(repository.findAll(Sort.by(Sort.Direction.DESC, field)));
		return new ResponseEntity<Response<List<Employee>>>(res, HttpStatus.OK);
	}
	
//	@Override
//	public ResponseEntity<Response<List<Employee>>> findEmployeeWithSortingAsc(String field) {
//		Response<List<Employee>> res = new Response<List<Employee>>();
//		res.setMessage("sort by desc");
//		res.setResponse(repository.findAll(Sort.by(Sort.Direction.ASC, field)));
//		return new ResponseEntity<Response<List<Employee>>>(res, HttpStatus.OK);
//	}

    @Override
    public Page<Employee> findProductWithPagination(int offset, int pageSize){
     Page<Employee> emp=repository.findAll(PageRequest.of(offset, pageSize));
     return emp;
    }

//    @Override
//   public ResponseEntity<Object> findByFname(String input) {
//   TreeMap<String, List<Employee>> ro = new TreeMap<String, List<Employee>>();
//   if (repository.findByFname(input) != null) {
//   ro.put("response", repository.findByFname(input));
//   return new ResponseEntity<Object>(ro, HttpStatus.OK);
//   } else {
//   ro.put("response", new ArrayList<Employee>());
//   return new ResponseEntity<Object>(ro, HttpStatus.NOT_FOUND);
//   }
//   }
//  

//  
	@Override
	public ResponseEntity<Response<Page<Employee>>> findEmpByPagination(int offset, int pagesize) {
		Response<Page<Employee>> res = new Response<Page<Employee>>();
		res.setMessage("offset " + offset + "page " + pagesize);
		res.setResponse(repository.findAll(PageRequest.of(offset, pagesize, Sort.Direction.DESC, "id")));
		return new ResponseEntity<Response<Page<Employee>>>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> srhByAll(String fname, String lname, String email) {
		// TODO Auto-generated method stub
		return null;
	}

	


}