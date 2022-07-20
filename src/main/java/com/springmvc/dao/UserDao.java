package com.springmvc.dao;

import com.springmvc.model.User;

public interface UserDao {
	
	public void saveUser(User u);
	
	public User login(String mobile,String password);
	
	public String findRole(int id);
	
	public User accessLoggedInUser(int id);	
}
