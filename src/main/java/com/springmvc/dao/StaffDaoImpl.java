package com.springmvc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.model.Attendance;
import com.springmvc.model.Notice;
import com.springmvc.model.Staff;

@Repository
public class StaffDaoImpl implements StaffDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Transactional
	public void insert_into_attendance(Attendance ao) {
		this.hibernateTemplate.save(ao);
	}

	public List<Attendance> select_attendance(int staffID) {	

		List<Attendance> attendances = this.hibernateTemplate.loadAll(Attendance.class);
		return attendances;
	
	}

	public List<Notice> selectNotice() {

		List<Notice> Noticelist = this.hibernateTemplate.loadAll(Notice.class);
		return Noticelist;
		
	}
	
	public Staff accessLoggedInStaff(int id) {
		Staff s=this.hibernateTemplate.get(Staff.class, id);
		return s;
	}

}
