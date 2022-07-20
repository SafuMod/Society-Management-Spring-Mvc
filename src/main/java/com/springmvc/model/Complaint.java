package com.springmvc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Complaint {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int complaint_id;
	private String statement;
	private String complaint_date;
	private String complaint_status;
	
	@OneToOne
	private User user;
	
	public Complaint() {
	}

	public Complaint(String statement, String complaint_date, String complaint_status, User user) {
		this.statement = statement;
		this.complaint_date = complaint_date;
		this.complaint_status = complaint_status;
		this.user = user;
	}

	public int getComplaint_id() {
		return complaint_id;
	}

	public void setComplaint_id(int complaint_id) {
		this.complaint_id = complaint_id;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public String getComplaint_date() {
		return complaint_date;
	}

	public void setComplaint_date(String complaint_date) {
		this.complaint_date = complaint_date;
	}

	public String getComplaint_status() {
		return complaint_status;
	}

	public void setComplaint_status(String complaint_status) {
		this.complaint_status = complaint_status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Complaint [complaint_id=" + complaint_id + ", statement=" + statement + ", complaint_date="
				+ complaint_date + ", complaint_status=" + complaint_status + ", user=" + user + "]";
	}
	
	
	
}
