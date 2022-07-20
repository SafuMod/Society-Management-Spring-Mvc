package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.springmvc.model.User;
import com.springmvc.service.UserService;

@Controller
public class ParentController {
	@Autowired
	private UserService userservice;
	
	public User getLoggedInUser(int id) {
		User u=this.userservice.getLoggedInUserService(id);
		return u;	
	}
}
