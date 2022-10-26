package com.foh.twitterapp.dto;

public class UserRegisterDTO {
	
	private String username;
	private String email;
	private String password;
	private String matchedPassword;
	
	
	public UserRegisterDTO() {
		// TODO Auto-generated constructor stub
	}


	public UserRegisterDTO(String username, String email, String password, String matchedPassword) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.matchedPassword = matchedPassword;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getMatchedPassword() {
		return matchedPassword;
	}


	public void setMatchedPassword(String matchedPassword) {
		this.matchedPassword = matchedPassword;
	}


	@Override
	public String toString() {
		return "UserRegisterDTO [username=" + username + ", email=" + email + ", password=" + password
				+ ", matchedPassword=" + matchedPassword + "]";
	}
	
	
}
