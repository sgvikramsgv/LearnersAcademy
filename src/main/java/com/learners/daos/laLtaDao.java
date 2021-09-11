package com.learners.daos;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.learners.entities.LaLta;
import com.learners.utils.dbAccess;

public class laLtaDao {
	
	public static List<LaLta> listLta(){
		
		List<LaLta> templta = null;
		
		SessionFactory sf = dbAccess.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			templta = session.createQuery("from LaLta").list();
			if(templta == null) {
				templta = Collections.emptyList();
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
		
		return templta;
	}
	
	public static void addLta(LaLta c) {
		
		SessionFactory sf = dbAccess.getSessionFactory();
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
	
	public static void deleteLta(long classId) {
			
			SessionFactory sf = dbAccess.getSessionFactory();
			Session session = sf.openSession();
			Transaction tx = null;
			LaLta c = null;
			
			try {
				tx = session.beginTransaction();
				c = session.get(LaLta.class, classId);
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
	
	public static LaLta editLta(long classId) {
		
		SessionFactory sf = dbAccess.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = null;
		LaLta c = null;
		
		try {
			tx = session.beginTransaction();
			c = session.get(LaLta.class, classId);			
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

	public static void udpateLta(LaLta tempc) {
		
		SessionFactory sf = dbAccess.getSessionFactory();
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
