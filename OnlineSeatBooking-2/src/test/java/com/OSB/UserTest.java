package com.OSB;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.OSB.Model.User;
import com.OSB.Repository.UserRepo;
import com.OSB.Service.UserService;
  
  //@RunWith(SpringRunner.class)
  
  @SpringBootTest
  
  public class UserTest {
  
  
  @MockBean private UserRepo repository;
  
  @Autowired private UserService service;
  
  @Test 
 public void saveUser()
 {
	User user = new User ("divya","div@gmail.com","ppp") ;
	when(repository.save(user)).thenReturn(user);
	assertEquals(user,service.addUser(user));
			
  }
  

  @Test public void getEmailIdAndPassword() {
	  String emailId="div@gmail.com";
      String password="div"; 
  User user = new User("radha","radha@gmail.com","rad");
  when(repository.findByEmailIdAndPassword(emailId,password)).thenReturn(user);
  assertEquals(user,service.userlogin(emailId,password)); }
  
  }
 
  
  
  


