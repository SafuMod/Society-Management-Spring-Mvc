package com.springmvc.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.model.Notice;
import com.springmvc.model.Staff;
import com.springmvc.model.Attendance;
import com.springmvc.service.StaffService;

@Controller
public class StaffController {

	@Autowired
	private StaffService staffservice;

	@RequestMapping("/setattendance")
	public String setAttendance(Model model) {
		model.addAttribute("page", "setattendance");
		return "StaffDashboard";
	}
	
	
	public Staff getLoggedInStaff(int id) {
		Staff s=this.staffservice.getLoggedInStaffService(id);
		return s;
	}
	
	@RequestMapping("/markattendance")
	public String setAttendance(@ModelAttribute Attendance attendance, @RequestParam("staff_id") int id,Model m) {
		Staff staff=getLoggedInStaff(id);
		attendance.setStaff(staff);
		staffservice.mark_attandance_service(attendance);
		m.addAttribute("page", "nochange");
		return "StaffDashboard";
	}
	
	@RequestMapping("/getattendance")
	public String getattendance(Model model) {
		model.addAttribute("page", "getattendance");
		return "StaffDashboard";
	}

	@RequestMapping("/checkattendance")
	public String checkAttendance(@RequestParam("staff_id") int staff_id, Model model) {
		List<Attendance> attendanceList = this.staffservice.check_attandance(staff_id);
		model.addAttribute("list", attendanceList);
		model.addAttribute("page", "checksattendance");
		return "StaffDashboard";
	}

	@RequestMapping("/getnotice")
	public String checkNotice(Model model) {
		List<Notice> Noticelist = this.staffservice.check_notice();
		model.addAttribute("list", Noticelist);
		model.addAttribute("page", "checksnotice");

		return "StaffDashboard";
	}

}
