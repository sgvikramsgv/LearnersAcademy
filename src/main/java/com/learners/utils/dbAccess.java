package com.learners.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learners.entities.LaStudent;

public class dbAccess {
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory(Class annotatedClass) {
		sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(annotatedClass)
				.buildSessionFactory();
		
		return sessionFactory;
	}
}
