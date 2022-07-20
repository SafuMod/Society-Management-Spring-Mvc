package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.SecretoryDao;
import com.springmvc.model.Attendance;
import com.springmvc.model.Complaint;
import com.springmvc.model.Notice;
import com.springmvc.model.Staff;

@Service
public class SecretoryService {
	@Autowired
	private SecretoryDao secretorydao;
	
	public List<Attendance> AccessingRecords() {
		List<Attendance> attendanceRecord =this.secretorydao.Select_Attendance_records();
		return attendanceRecord;
	}
	
	
	public void AddingStaff(Staff s) {
		this.secretorydao.insert_into_staff(s);
	}
	
	
	public List<Complaint> AccessingComplaints() {
		List<Complaint> complaintRecord =this.secretorydao.Select_Complaints();
		return complaintRecord;
	}
	
	public void publishingNotice(Notice n) {
		this.secretorydao.publishingNotice(n);
	}
}
