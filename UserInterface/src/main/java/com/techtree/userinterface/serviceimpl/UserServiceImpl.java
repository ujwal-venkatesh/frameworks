package com.techtree.userinterface.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.techtree.userinterface.entity.User;
import com.techtree.userinterface.entity.UserProfile;
import com.techtree.userinterface.repository.UserRepository;
import com.techtree.userinterface.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	
	@Override
	 public	ResponseEntity<Object> register(UserProfile user){
		 JSONObject object=new JSONObject();
		try {
			UserProfile userProfileList=userRepository.save(user);
			if(userProfileList!=null) {
				object.put("response",userRepository.save(user));
				return new ResponseEntity<Object>(object, HttpStatus.OK);
			}else {
				object.put("empty", new ArrayList<>());
				return new ResponseEntity<Object>(object, HttpStatus.BAD_GATEWAY);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>("bad request", HttpStatus.INTERNAL_SERVER_ERROR);	 
	}
	@Override
	public ResponseEntity<Object> setpin(User id){
		JSONObject object=new JSONObject();
		try {
			User user=userRepository.getById(id.getId());
			if(id!=null) {
				object.put("response", userRepository.getById(id.getId()));
			}
		}
	}
}



