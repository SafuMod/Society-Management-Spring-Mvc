package com.springmvc.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.model.User;


@Repository
public class SuperAdminDaoImpl implements SuperAdminDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public void assign_role(int user_id) {
		User u=this.hibernateTemplate.get(User.class, user_id);
		u.setRole_id(3);
		this.hibernateTemplate.update(u);
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
