package com.OSB.Model;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {

	@Id
	@Column(name = "USERID")
	private String userId;

	@NotNull(message = "userName must not be empty")
	@Column(name = "USERNAME")
	private String userName;

	@NotNull(message = "email field must not be empty")
	@Email(message = "email should be in valid format")
	@Column(name = "emailId")
	private String emailId;

	@NotNull(message = "password must not be empty")

	@Column(name = "PASSWORD")
	private String password;
	

	

	public User(@NotNull(message = "userName must not be empty") String userName,
			@NotNull(message = "email field must not be empty") @Email(message = "email should be in valid format") String emailId,
			@NotNull(message = "password must not be empty") String password) {
		super();
		this.userName = userName;
		this.emailId = emailId;
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", emailId=" + emailId + ", password=" + password
				+ "]";
	}

	
	
}