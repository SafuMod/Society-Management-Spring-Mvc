package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springmvc.dao.OwnerDao;
import com.springmvc.model.Complaint;
import com.springmvc.model.Notice;

@Service
public class OwnerService {

	@Autowired
	private OwnerDao ownerDao;	
	
	public void addComplaint(Complaint complaint)
	{
		this.ownerDao.fileComplaint(complaint);		
	}
	
	public List<Notice> check_notice() {
		List<Notice> noticeRecord = this.ownerDao.selectNotice();
		return noticeRecord;
	}
}
