package com.springmvc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Attendance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int attendance_id;
	private boolean attendance;
	private String attendance_date;
	
	@OneToOne
	private Staff staff;

	public Attendance() {
	}

	public Attendance(boolean attendance, String attendance_date, Staff staff) {
		this.attendance = attendance;
		this.attendance_date = attendance_date;
		this.staff = staff;
	}

	public int getAttendance_id() {
		return attendance_id;
	}

	public void setAttendance_id(int attendance_id) {
		this.attendance_id = attendance_id;
	}

	public boolean isAttendance() {
		return attendance;
	}

	public void setAttendance(boolean attendance) {
		this.attendance = attendance;
	}

	public String getAttendance_date() {
		return attendance_date;
	}

	public void setAttendance_date(String attendance_date) {
		this.attendance_date = attendance_date;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	@Override
	public String toString() {
		return "Attendance [attendance_id=" + attendance_id + ", attendance=" + attendance + ", attendance_date="
				+ attendance_date + ", staff=" + staff + "]";
	}

	

}
