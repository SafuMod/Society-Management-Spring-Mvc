package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.Attendance;
import com.springmvc.model.Complaint;
import com.springmvc.model.Notice;
import com.springmvc.model.Staff;

public interface SecretoryDao {
	public List<Attendance> Select_Attendance_records();
	public void insert_into_staff(Staff s);
	List<Complaint> Select_Complaints();
	public void publishingNotice(Notice n);
}
