package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springmvc.dao.UserDao;
import com.springmvc.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userdao;
	
	public void addUser(User user) {
		this.userdao.saveUser(user);
	}
	
	public User login_service(String mobile,String password) {
		User user = this.userdao.login(mobile,password);
		return user;
	}
	
	public String findRole_service(int id) {
		String role=this.userdao.findRole(id);
		return role;
	}
	
	public User getLoggedInUserService(int id) {
		User u=this.userdao.accessLoggedInUser(id);
		return u;
	}
}
