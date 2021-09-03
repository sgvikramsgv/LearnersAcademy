package com.learners.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.learners.entities.LaClass;
import com.learners.entities.LaStudent;
import com.learners.utils.dbAccess;

public class laClassesDao {
	
	public static List<LaClass> listClass(){
		
		List<LaClass> allclass = null;
		
		SessionFactory sf = dbAccess.getSessionFactory(LaClass.class);
		Session session = sf.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			allclass = session.createQuery("from LaClass").list();
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
		
		return allclass;
	}
	
	public static void addClass(LaClass c) {
		
		SessionFactory sf = dbAccess.getSessionFactory(LaClass.class);
		Session session = sf.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.save(c);
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
	
	public static void deleteClass(long classId) {
			
			SessionFactory sf = dbAccess.getSessionFactory(LaClass.class);
			Session session = sf.openSession();
			Transaction tx = null;
			LaClass c = null;
			
			try {
				tx = session.beginTransaction();
				c = session.get(LaClass.class, classId);
				session.delete(c);
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
	
	public static LaClass editClass(long classId) {
		
		SessionFactory sf = dbAccess.getSessionFactory(LaClass.class);
		Session session = sf.openSession();
		Transaction tx = null;
		LaClass c = null;
		
		try {
			tx = session.beginTransaction();
			c = session.get(LaClass.class, classId);			
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
		return c;
		
	}

	public static void udpateClass(LaClass tempc) {
		
		SessionFactory sf = dbAccess.getSessionFactory(LaClass.class);
		Session session = sf.openSession();
		Transaction tx = null;
				
		try {
			tx = session.beginTransaction();
			session.update(tempc);
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
