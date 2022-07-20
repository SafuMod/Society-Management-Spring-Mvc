package com.springmvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.model.Attendance;
import com.springmvc.model.Complaint;
import com.springmvc.model.Notice;
import com.springmvc.model.Staff;

@Repository
public class SecretoryDaoImpl implements SecretoryDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public List<Attendance> Select_Attendance_records() {
		List<Attendance> list=this.hibernateTemplate.loadAll(Attendance.class);
		return list;
		
	}
	
	@Transactional
	public void insert_into_staff(Staff s) {
		this.hibernateTemplate.setCheckWriteOperations(false);
		this.hibernateTemplate.save(s);
	}
	
	public List<Complaint> Select_Complaints() {
		List<Complaint> list=this.hibernateTemplate.loadAll(Complaint.class);
		return list;
	}
	
	@Transactional
	public void publishingNotice(Notice n) {
		this.hibernateTemplate.setCheckWriteOperations(false);
		this.hibernateTemplate.save(n);
	}
	
}
