package com.OSB.Service;



import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.OSB.Model.User;
import com.OSB.Repository.UserRepo;

@Component

public class UserService {
	@Autowired
	UserRepo repo;
	public User addUser(User u)
	{
		User user = repo.save(u);
		return user;
		
		  } 
	public User userlogin(String emailId,String password) {
		User user =repo.findByEmailIdAndPassword(emailId, password);
		return user;
		 
	}

	
	
	public void updateUserByEmailId(User u) 
	{
		repo.save(u);
	}
	public Optional<User> findByEmailId(String emailId) {
		return repo.findByEmailId(emailId);
	}

}

