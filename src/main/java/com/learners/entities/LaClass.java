package com.learners.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="class",
uniqueConstraints= {
		@UniqueConstraint(columnNames="class_name"),
	}
)
public class LaClass {
	
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
