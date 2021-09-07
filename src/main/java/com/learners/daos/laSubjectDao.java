package com.learners.daos;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.learners.entities.LaStudent;
import com.learners.entities.LaSubject;
import com.learners.utils.dbAccess;

public class laSubjectDao {
	
public static List<LaSubject> listSubject(){
		
		List<LaSubject> allSubjects = null;
		
		SessionFactory sf = dbAccess.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			allSubjects = session.createQuery("from LaSubject").list();
			if(allSubjects == null) {
				allSubjects = Collections.emptyList();
			}
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
		
		return allSubjects;
	}
	
	public static void addSubject(LaSubject sub) {
		
		SessionFactory sf = dbAccess.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.save(sub);
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
	
	public static void deleteSubject(long subjectId) {
			
			SessionFactory sf = dbAccess.getSessionFactory();
			Session session = sf.openSession();
			Transaction tx = null;
			LaSubject subject = null;
			
			try {
				tx = session.beginTransaction();
				subject = session.get(LaSubject.class, subjectId);
				session.delete(subject);
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
	
	public static LaSubject editSubject(long subjectId) {
		
		SessionFactory sf = dbAccess.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = null;
		LaSubject subject = null;
		
		try {
			tx = session.beginTransaction();
			subject = session.get(LaSubject.class, subjectId);			
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
		return subject;
		
	}

	public static void udpateSubject(LaSubject tempsub) {
		
		SessionFactory sf = dbAccess.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = null;
				
		try {
			tx = session.beginTransaction();
			session.update(tempsub);
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
