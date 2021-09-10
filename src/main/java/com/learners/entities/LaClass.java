package com.learners.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@Table(name="class",
uniqueConstraints= {
		@UniqueConstraint(columnNames="class_name"),
	}
)
public class LaClass implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="class_id")
	private long id;
	
	@Column(name="class_name")
	private String name;
	
	@Column(name="class_capacity")
	private int capacity;
	
	@OneToMany(mappedBy="class_id")
	private Collection<LaStudent> students;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinTable(name = "CLASS_SUBJECT", 
		joinColumns = { @JoinColumn(name = "class_id") }, 
		inverseJoinColumns = { @JoinColumn(name = "subject_id") })
	private List<LaSubject> subjects = new ArrayList<LaSubject>();
	
	public Collection<LaStudent> getStudents() {
		return students;
	}
	public void setStudents(Collection<LaStudent> students) {
		this.students = students;
	}
	public List<LaSubject> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<LaSubject> subjects) {
		this.subjects = subjects;
	}
	public LaClass() {
		super();
	}
	public LaClass(String name, int capacity) {
		super();
		this.name = name;
		this.capacity = capacity;
	}
	public LaClass(long id, String name, int capacity) {
		super();
		this.id = id;
		this.name = name;
		this.capacity = capacity;
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
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	@Override
	public String toString() {
		return "LaClass [id=" + id + ", name=" + name + ", capacity=" + capacity + "]";
	}
	
	
	

}
