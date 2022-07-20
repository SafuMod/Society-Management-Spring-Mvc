package com.springmvc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.springmvc.model.Notice;
import com.springmvc.model.Complaint;


@Repository	
public class OwnerDaoImpl implements OwnerDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public void fileComplaint(Complaint complaint)
	{
		this.hibernateTemplate.setCheckWriteOperations(false);
		this.hibernateTemplate.save(complaint);
	}
	
	public List<Notice> selectNotice() {

		List<Notice> Noticelist = this.hibernateTemplate.loadAll(Notice.class);
		return Noticelist;
		
	}
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}


	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	
}
