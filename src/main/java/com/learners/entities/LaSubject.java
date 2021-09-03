package com.learners.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Subject")
public class LaSubject {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="subject_id")
	private long id;
	
	@Column(name="subject_name")
	private String name;
	
	
	public LaSubject(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	

	public LaSubject() {
		super();
	}


	public LaSubject(String name) {
		super();
		this.name = name;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "LaSubject [id=" + id + ", name=" + name + "]";
	}
	
	
	

}
