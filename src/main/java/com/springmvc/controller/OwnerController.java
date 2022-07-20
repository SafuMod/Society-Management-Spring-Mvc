package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.model.Complaint;
import com.springmvc.model.User;
import com.springmvc.model.Notice;
import com.springmvc.service.OwnerService;
import java.util.List;
@Controller
public class OwnerController extends ParentController{

	@Autowired
	private OwnerService ownerService;
	
	@RequestMapping("/filecomplaint")
	public String filecomplaint(Model model) {
		model.addAttribute("page", "filecomplaint");
		return "OwnerDashboard";
	}
	@RequestMapping("/addcomplaint")
	public String fileComplaint(@ModelAttribute Complaint complaint,@RequestParam("user_id") int id,Model m) {
		User u = getLoggedInUser(id);
		complaint.setUser(u);
		this.ownerService.addComplaint(complaint);
		return "OwnerDashboard";
	}
	
	
	@RequestMapping("/checksnotice")
	public String checkNotice(Model model) {
		List<Notice> Noticelist = this.ownerService.check_notice();
		model.addAttribute("list", Noticelist);
		model.addAttribute("page", "checksnotice");
		return "OwnerDashboard";
	}
}
