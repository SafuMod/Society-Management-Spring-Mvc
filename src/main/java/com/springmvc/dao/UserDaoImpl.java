package com.springmvc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.model.Role;
import com.springmvc.model.User;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void saveUser(User u) {
		//hibertemp = (HibernateTemplate)AddController.getContext().getBean("hibertemp");
		this.hibernateTemplate.setCheckWriteOperations(false);
		this.hibernateTemplate.save(u);
	}
	
	
	public User login(String mobile,String password) {
		List<User> user = this.hibernateTemplate.loadAll(User.class);

		for(User e : user) {
			if(e.getMobile_no().equals(mobile) && e.getPassword().equals(password)) {
			return e;
			}
		}
		return null;
	}
	
	public String findRole(int id) {
		User u = this.hibernateTemplate.get(User.class,id);
		Role roles = this.hibernateTemplate.get(Role.class,u.getRole_id());
		if(roles.equals(null))
		return null;
		
		return roles.getRole();
		}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public User accessLoggedInUser(int id) {
		User u=this.hibernateTemplate.get(User.class, id);
		return u;
	}
	
}
