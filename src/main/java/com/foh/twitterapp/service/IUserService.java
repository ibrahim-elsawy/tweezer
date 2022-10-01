package com.foh.twitterapp.service;

import java.util.List;

import com.foh.twitterapp.entity.User;

public interface IUserService {
	
	public List<User> getUsers();
	public void saveUser(User user);
	public User getUser(int id);
	public void deleteUser(int id);
}
