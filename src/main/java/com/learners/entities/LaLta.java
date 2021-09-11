package com.learners.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Teacher_assignment")
public class LaLta implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="lta_id")
	private long id;
	
	@OneToOne
	@JoinColumn(name="class_id")
	private LaClass laclass;
	
	@OneToOne
	@JoinColumn(name="subject_id")
	private LaSubject lasubject;
	
	@OneToOne
	@JoinColumn(name="teacher_id")
	private LaTeacher lateacher;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LaClass getLaclass() {
		return laclass;
	}

	public void setLaclass(LaClass laclass) {
		this.laclass = laclass;
	}

	public LaSubject getLasubject() {
		return lasubject;
	}

	public void setLasubject(LaSubject lasubject) {
		this.lasubject = lasubject;
	}

	public LaTeacher getLateacher() {
		return lateacher;
	}

	public void setLateacher(LaTeacher lateacher) {
		this.lateacher = lateacher;
	}

	public LaLta(long id, LaClass laclass, LaSubject lasubject, LaTeacher lateacher) {
		super();
		this.id = id;
		this.laclass = laclass;
		this.lasubject = lasubject;
		this.lateacher = lateacher;
	}

	public LaLta(LaClass laclass, LaSubject lasubject, LaTeacher lateacher) {
		super();
		this.laclass = laclass;
		this.lasubject = lasubject;
		this.lateacher = lateacher;
	}

	public LaLta() {
		super();
	}
	
	
	
}
