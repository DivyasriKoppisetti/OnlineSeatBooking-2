package com.OSB.Repository;




import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OSB.Model.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

	User findByEmailIdAndPassword(String emailId, String password);
	
	Optional<User> findByEmailId(String emailId);
	
	
	
}
