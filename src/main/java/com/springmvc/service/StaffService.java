package com.springmvc.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.StaffDao;
import com.springmvc.model.Attendance;
import com.springmvc.model.Notice;
import com.springmvc.model.Staff;

@Service
public class StaffService {

	@Autowired
	private StaffDao staffdao;

	public boolean mark_attandance_service(Attendance ao) {
		this.staffdao.insert_into_attendance (ao);
		return true;
	}

	public List<Attendance> check_attandance(int staff_id) {
		List<Attendance> attendanceRecord = this.staffdao.select_attendance(staff_id);
		ArrayList<Attendance> att = new ArrayList<Attendance>();
		for (Attendance attendance : attendanceRecord) {
			if (attendance.getStaff().getStaff_id() == staff_id) {
				att.add(attendance);
			}
		}

		return (List<Attendance>) att;

	}

	public List<Notice> check_notice() {
		List<Notice> noticeRecord = this.staffdao.selectNotice();
		return noticeRecord;
	}
	
	public Staff getLoggedInStaffService(int id) {
		Staff s=this.staffdao.accessLoggedInStaff(id);
		return s;
	}

}
