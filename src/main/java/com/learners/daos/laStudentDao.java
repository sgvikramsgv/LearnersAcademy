package com.learners.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.learners.entities.LaStudent;
import com.learners.utils.dbAccess;

public class laStudentDao {
	
	public static List<LaStudent> listStudents(){
		
		List<LaStudent> allStudents = null;
		
		SessionFactory sf = dbAccess.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			allStudents = session.createQuery("from LaStudent").list();
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) {
				session.close();
				sf.close();
			}
		}
		
		return allStudents;
	}
	
	public static void addStudent(LaStudent stu) {
		
		SessionFactory sf = dbAccess.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.save(stu);
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) {
				session.close();
				sf.close();
			}
		}
		
	}
	
	public static void deleteStudent(long studentId) {
			
			SessionFactory sf = dbAccess.getSessionFactory();
			Session session = sf.openSession();
			Transaction tx = null;
			LaStudent student = null;
			
			try {
				tx = session.beginTransaction();
				student = session.get(LaStudent.class, studentId);
				session.delete(student);
				tx.commit();
				session.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(session!=null) {
					session.close();
					sf.close();
				}
			}
			
		}
	
	public static LaStudent editStudent(long studentId) {
		
		SessionFactory sf = dbAccess.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = null;
		LaStudent student = null;
		
		try {
			tx = session.beginTransaction();
			student = session.get(LaStudent.class, studentId);			
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) {
				session.close();
				sf.close();
			}
		}
		return student;
		
	}

	public static void udpateStudent(LaStudent tempstu) {
		
		SessionFactory sf = dbAccess.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = null;
				
		try {
			tx = session.beginTransaction();
			session.update(tempstu);
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) {
				session.close();
				sf.close();
			}
		}
	}

}
