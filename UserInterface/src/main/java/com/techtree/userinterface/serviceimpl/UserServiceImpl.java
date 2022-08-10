package com.techtree.userinterface.serviceimpl;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.Optional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.techtree.userinterface.entity.User;
import com.techtree.userinterface.entity.UserCustomDetails;
import com.techtree.userinterface.entity.UserProfile;
import com.techtree.userinterface.entity.UserProfileBean;
import com.techtree.userinterface.repository.UserProfileRepository;
import com.techtree.userinterface.repository.UserRepository;
import com.techtree.userinterface.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserProfileRepository userProfileRepository;

	@SuppressWarnings("unchecked")
	@Override
	public ResponseEntity<Object> register(String mobilenumber) {
		JSONObject object=new JSONObject();
		try {
			User user = new User();
			user.setMobilenumber(mobilenumber);
			object.put("response:Id=",userRepository.save(user).getUid());
			return new ResponseEntity<Object>(object, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Override
	public ResponseEntity<Object> setpin(long uid, String password, String confirmPassword) {
		try {
			if (userRepository.findById(uid).isPresent()) {
				User user = userRepository.getById(uid);
				System.out.println(user.getPassword());
				if (user.getPassword() == null && password.equals(password)) {
					Encoder encoder = Base64.getEncoder();
					String encodedString = encoder.encodeToString(password.getBytes("UTF-8"));
					user.setPassword(encodedString);
					User saveUser = userRepository.save(user);
					return new ResponseEntity<Object>(" succesfully set pin ", HttpStatus.OK);
				} else {
					return new ResponseEntity<Object>("already regitrated", HttpStatus.FOUND);
				}
			} else {
				return new ResponseEntity<Object>("Not regitrated yet ", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@Override
	public ResponseEntity<Object> verfiyLogIn(long uid, String password) {
		try {
			if (userRepository.findById(uid).isPresent()) {
				@SuppressWarnings("deprecation")
				User user = userRepository.getById(uid);
				String encoded = user.getPassword();
				System.out.println(encoded);
				Decoder decoder = Base64.getDecoder();
				byte[] decodedbytespass = decoder.decode(encoded);
				System.out.println("---------------");
				System.out.println(decodedbytespass);
				String Dbpass = new String(decodedbytespass, "UTF-8");
				System.out.println(Dbpass);
				if (Dbpass.equals(password)) {
					return new ResponseEntity<Object>("login succefull", HttpStatus.OK);
				} else {
					return new ResponseEntity<Object>(" inwalid password try with valid password", HttpStatus.BAD_REQUEST);
				}
			} else {
				return new ResponseEntity<Object>("user not found or user not registered", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@Override
	public ResponseEntity<Object> update(UserProfileBean userprofilebean) {
		JSONObject object=new JSONObject();
		try {
			Optional<User> user=userRepository.findById(userprofilebean.getUid());
			if(user.isPresent()) {
				UserProfile userprofile=userProfileRepository.getById(userprofilebean.getUid());
				System.out.println(userprofile);
				if(userprofilebean.getFirstname()!=null) {
					userprofile.setFirstname(userprofilebean.getFirstname());
				}
				if(userprofilebean.getLastname()!=null) {
					userprofile.setLastname(userprofilebean.getLastname());
				}
				if(userprofilebean.getEmail()!=null) {
					userprofile.setEmail(userprofilebean.getEmail());
				}
				User updateUser=new User();
				updateUser.setUserProfile(userprofile);
				userRepository.save(updateUser);
				return new ResponseEntity<Object>("profile updation successfull", HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>("User Profiel Updation Failed", HttpStatus.BAD_REQUEST);
			}
		}catch(Exception e) {
				e.printStackTrace();
				}
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@SuppressWarnings({ "unused" })
	@Override
	public ResponseEntity<Object> view(long uid) {
		JSONObject object=new JSONObject();
		try {
		UserProfile user=userRepository.findById(uid).get().getUserProfile();
		UserCustomDetails userDetails =new UserCustomDetails();
		userDetails.setFirstmane(user.getFirstname());
		userDetails.setLastname(user.getLastname());
		userDetails.setEmail(user.getEmail());
			if (user != null) {
				return new ResponseEntity<Object>(userDetails, HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("not found", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
