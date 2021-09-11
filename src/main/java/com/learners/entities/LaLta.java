package com.learners.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Teacher_assignment")
public class LaLta implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="lta_id")
	private long id;
	
	@Column(name="class_id")
	private long lta_class_id;
	
	@Column(name="subject_id")
	private long lta_subject_id;
	
	@Column(name="teacher_id")
	private long lta_teacher_id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getLta_class_id() {
		return lta_class_id;
	}

	public void setLta_class_id(long lta_class_id) {
		this.lta_class_id = lta_class_id;
	}

	public long getLta_subject_id() {
		return lta_subject_id;
	}

	public void setLta_subject_id(long lta_subject_id) {
		this.lta_subject_id = lta_subject_id;
	}

	public long getLta_teacher_id() {
		return lta_teacher_id;
	}

	public void setLta_teacher_id(long lta_teacher_id) {
		this.lta_teacher_id = lta_teacher_id;
	}

	public LaLta(long id, long lta_class_id, long lta_subject_id, long lta_teacher_id) {
		super();
		this.id = id;
		this.lta_class_id = lta_class_id;
		this.lta_subject_id = lta_subject_id;
		this.lta_teacher_id = lta_teacher_id;
	}

	public LaLta(long lta_class_id, long lta_subject_id, long lta_teacher_id) {
		super();
		this.lta_class_id = lta_class_id;
		this.lta_subject_id = lta_subject_id;
		this.lta_teacher_id = lta_teacher_id;
	}

	public LaLta() {
		super();
	}
	
	
	
}
