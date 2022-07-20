package com.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.model.Attendance;
import com.springmvc.model.Complaint;
import com.springmvc.model.Notice;
import com.springmvc.model.Staff;
import com.springmvc.model.User;
import com.springmvc.service.SecretoryService;

@Controller
public class SecretoryController extends ParentController{

	@Autowired
	private SecretoryService secretoryservice;

	@RequestMapping("/addGuard")
	public String addGuard(Model m) {
		m.addAttribute("page", "addGuard");
		return "SecretoryDashboard";
	}

	@RequestMapping("/saveGuard")
	public String saveGuard(@ModelAttribute Staff staff, Model m) {
		this.secretoryservice.AddingStaff(staff);
		m.addAttribute("page", "SuccessAddedGuard");
		return "SecretoryDashboard";
	}

	@RequestMapping("/checkAttendance")
	public String checkAttendance(Model m) {
		m.addAttribute("page", "checkAttendance");
		List<Attendance> list = this.secretoryservice.AccessingRecords();
		m.addAttribute("list", list);
		return "SecretoryDashboard";
	}

	@RequestMapping("/checkComplaints")
	public String checkComplaints(Model m) {
		m.addAttribute("page", "checkComplaints");
		List<Complaint> list = this.secretoryservice.AccessingComplaints();
		m.addAttribute("complaintList", list);
		return "SecretoryDashboard";
	}

	@RequestMapping("/addNotice")
	public String addNotice(Model m) {
		m.addAttribute("page", "addNotice");
		return "SecretoryDashboard";
	}

	@RequestMapping("/saveNotice")
	public String saveNotice(@ModelAttribute Notice notice, @RequestParam("user_id") int id,Model m) {
		User u = getLoggedInUser(id);
		notice.setUser(u);
		System.out.println(notice);
		this.secretoryservice.publishingNotice(notice);
		m.addAttribute("page", "SuccessAddedNotice");
		return "SecretoryDashboard";
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		return "logout";
	}

}
