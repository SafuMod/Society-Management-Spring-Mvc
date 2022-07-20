package com.springmvc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Staff {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int staff_id;
	private String name;
	private String designation;
	private String date_of_joining;
	

	public Staff() {
		super();
	}


	public Staff(String name, String designation, String date_of_joining) {
		this.name = name;
		this.designation = designation;
		this.date_of_joining = date_of_joining;
	}

	public int getStaff_id() {
		return staff_id;
	}


	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDate_of_joining() {
		return date_of_joining;
	}

	public void setDate_of_joining(String date_of_joining) {
		this.date_of_joining = date_of_joining;
	}

	@Override
	public String toString() {
		return "Staff [staff_id=" + staff_id + ", name=" + name + ", designation=" + designation + ", date_of_joining="
				+ date_of_joining + "]";
	}
	

}
