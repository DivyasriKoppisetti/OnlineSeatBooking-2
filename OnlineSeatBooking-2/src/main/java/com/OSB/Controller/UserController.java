package com.OSB.Controller;



import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OSB.Exception.ResourceNotFoundException;
import com.OSB.Model.User;
import com.OSB.Service.UserService;
 
 @RestController
 
@RequestMapping("/user_registration")
 
 public class UserController {

 
 @Autowired UserService service;
 
 
 
 
 
 @PostMapping("/addUser")
public ResponseEntity<String> addUser(@Validated @RequestBody User u)  {
	 User user = service.addUser(u);
	 
	 return new ResponseEntity<String>("Registration done successfully", HttpStatus.OK);
 
 }
 
	
	
	  @GetMapping("/UserLogin")
	  public ResponseEntity<String>checkUser(@RequestBody User u) {
		  String status=null; 
		  User user = service.userlogin(u.getEmailId(),u.getPassword());
		  if(Objects.nonNull(user)) {
			  
			  status="welcome to the portal";
	  
	  } 
		  else { 
			  
			  throw new ResourceNotFoundException("Invalid Credentials");
	  
	  } 
		  return new ResponseEntity<String>(status,HttpStatus.OK);
 
	  }
 
 @PutMapping("/forgotPassword")
 public ResponseEntity<String> updateUserByEmailId(@RequestBody User u)
 {
	 String status=null;
	 Optional<User> Obj=service.findByEmailId(u.getEmailId());
	// Obj.get().setPassword(u.getPassword());
	 
	 if(Obj.isPresent())
	 {
		 Obj.get().setPassword(u.getPassword());
		 
		 service.updateUserByEmailId(Obj.get());
		 status="Password Changed Successfully";
	 }
	else {
		//status="Provide Valid emailId";
		throw new ResourceNotFoundException("Provide Valid emailId");
	}
		 
 
	 
	return new ResponseEntity<String>(status,HttpStatus.OK);
 }
 }
 
 
  