package com.learners.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="class")
public class LaClass {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="class_name")
	private String name;
	
	@Column(name="class_capacity")
	private int capacity;

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
