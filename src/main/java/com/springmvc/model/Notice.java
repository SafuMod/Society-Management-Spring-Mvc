package com.springmvc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Notice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int notice_id;

	private String notice_date;

	private String notice;

	@OneToOne
	private User user;

	public Notice() {
		super();
	}

	public Notice(String notice_date, String notice, User user) {
		super();
		this.notice_date = notice_date;
		this.notice = notice;
		this.user = user;
	}

	public int getNotice_id() {
		return notice_id;
	}

	public void setNotice_id(int notice_id) {
		this.notice_id = notice_id;
	}

	public String getNotice_date() {
		return notice_date;
	}

	public void setNotice_date(String notice_date) {
		this.notice_date = notice_date;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Notice [notice_id=" + notice_id + ", notice_date=" + notice_date + ", notice=" + notice + ", user="
				+ user + "]";
	}

}
