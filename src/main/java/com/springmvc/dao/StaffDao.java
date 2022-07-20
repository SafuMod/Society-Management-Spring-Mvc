package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.Attendance;
import com.springmvc.model.Notice;
import com.springmvc.model.Staff;

public interface StaffDao {

	public void insert_into_attendance(Attendance ao);

	public List<Attendance> select_attendance(int staffID);

	public List<Notice> selectNotice();
	
	public Staff accessLoggedInStaff(int id) ;

}
