package com.learners.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.learners.entities.LaStudent;
import com.learners.entities.LaTeacher;
import com.learners.utils.dbAccess;

public class laTeacherDao {
	
public static List<LaTeacher> listTeachers(){
		
		List<LaTeacher> allTeachers = null;
		
		SessionFactory sf = dbAccess.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			allTeachers = session.createQuery("from LaTeacher").list();
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
		
		return allTeachers;
	}
	
	public static void addTeacher(LaTeacher teach) {
		
		SessionFactory sf = dbAccess.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.save(teach);
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
	
	public static void deleteTeacher(long teacherId) {
			
			SessionFactory sf = dbAccess.getSessionFactory();
			Session session = sf.openSession();
			Transaction tx = null;
			LaTeacher teacher = null;
			
			try {
				tx = session.beginTransaction();
				teacher = session.get(LaTeacher.class, teacherId);
				session.delete(teacher);
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
	
	public static LaTeacher editTeacher(long teacherId) {
		
		SessionFactory sf = dbAccess.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = null;
		LaTeacher teacher = null;
		
		try {
			tx = session.beginTransaction();
			teacher = session.get(LaTeacher.class, teacherId);			
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
		return teacher;
		
	}

	public static void udpateTeacher(LaTeacher tempteach) {
		
		SessionFactory sf = dbAccess.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = null;
				
		try {
			tx = session.beginTransaction();
			session.update(tempteach);
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
