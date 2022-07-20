package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.SuperAdminDao;

@Service
public class SuperAdminService {

	@Autowired
	private SuperAdminDao superadmindao;
	
	public void assign_role_service(int id) {
		superadmindao.assign_role(id);
	}
}
