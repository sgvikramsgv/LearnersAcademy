package com.learners.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="Subject",
uniqueConstraints= {
		@UniqueConstraint(columnNames="subject_name")
}
)
public class LaSubject  implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="subject_id")
	private long id;
	
	@Column(name="subject_name")
	private String name;
	
	@ManyToMany(mappedBy="subjects")
    private List<LaClass> laclass = new ArrayList<LaClass>();

	public List<LaClass> getLaclass() {
		return laclass;
	}


	public void setLaclass(List<LaClass> laclass) {
		this.laclass = laclass;
	}


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
