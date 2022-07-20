package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.service.SuperAdminService;

@Controller
public class SuperAdminController {

	@Autowired
	private SuperAdminService superadminservice;
	
	@RequestMapping("/assignrole")
	public String getform(Model m) {
		m.addAttribute("page","assignrole");
		return "SuperAdmin";
	}
	
	@RequestMapping("/assignroleform")
	public String assignRole(@RequestParam("id") int id,Model m){
		superadminservice.assign_role_service(id);
		m.addAttribute("page","successmessage");
		return "SuperAdmin";
	}
	
}
