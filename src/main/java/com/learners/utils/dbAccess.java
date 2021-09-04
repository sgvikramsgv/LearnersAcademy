package com.learners.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learners.entities.LaClass;
import com.learners.entities.LaStudent;
import com.learners.entities.LaSubject;
import com.learners.entities.LaTeacher;
import com.learners.entities.LaUser;

public class dbAccess {
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(LaClass.class)
				.addAnnotatedClass(LaStudent.class)
				.addAnnotatedClass(LaSubject.class)
				.addAnnotatedClass(LaTeacher.class)
				.addAnnotatedClass(LaUser.class)
				.buildSessionFactory();
		
		return sessionFactory;
	}
}
