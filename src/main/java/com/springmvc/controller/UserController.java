package com.springmvc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.springmvc.model.User;
import com.springmvc.service.UserService;

	
@Controller
public class UserController {
	
	@Autowired
	private UserService userservice;
		
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	
	@RequestMapping("/userregister")
	public String saveData(@ModelAttribute User user) {
		this.userservice.addUser(user);
		return "save";
	}
	
	@RequestMapping("/userlogin")
	public String logindata(@RequestParam("mobile_no") String mobile,@RequestParam("password") String password,Model m) {
		User user = this.userservice.login_service(mobile, password);
		m.addAttribute(user);
		String role = this.userservice.findRole_service(user.getUser_id());
		m.addAttribute("role",role);
		return menu(role,m);
	}
	
	public String menu(String role,Model m) {	
		if(role.equalsIgnoreCase("owner")) {
			
			return "OwnerDashboard";

			
		}else if(role.equalsIgnoreCase("secretory")) {
				
			return "SecretoryDashboard";

		}else if(role.equalsIgnoreCase("superadmin")) {
			
			return "SuperAdmin";
			
		}else if(role.equalsIgnoreCase("staff")) {
			
			return "StaffDashboard";
		}
		
		return "null";
	}
		
}
