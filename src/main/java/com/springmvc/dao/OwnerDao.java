package com.springmvc.dao;
import com.springmvc.model.Notice;
import com.springmvc.model.Complaint;
import java.util.List;
public interface OwnerDao {

	public void fileComplaint(Complaint complaint);
	public List<Notice> selectNotice();

}
