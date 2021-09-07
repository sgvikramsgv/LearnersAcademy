package com.learners.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="Teacher",
uniqueConstraints= {
		@UniqueConstraint(columnNames="teacher_id"),
		@UniqueConstraint(columnNames="email")
}
)
public class LaTeacher {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="teacher_id")
	private long id;
	
	@Column(name="first_name")
	private String fname;
	
	@Column(name="last_name")
	private String lname;
	
	@Column(name="email")
	private String email;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="phone")
	private long phone;

	public LaTeacher(long id, String fname, String lname, String email, String gender, long phone) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.gender = gender;
		this.phone = phone;
	}

	public LaTeacher(String fname, String lname, String email, String gender, long phone) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.gender = gender;
		this.phone = phone;
	}

	public LaTeacher() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "LaTeacher [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", gender="
				+ gender + ", phone=" + phone + "]";
	}

	
	
	
}
