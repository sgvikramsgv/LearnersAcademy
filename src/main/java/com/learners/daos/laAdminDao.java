package com.learners.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.learners.entities.LaStudent;
import com.learners.entities.LaUser;
import com.learners.utils.dbAccess;

public class laAdminDao {
	
	public static List<LaUser> getAdminList() {
		
		SessionFactory sf = dbAccess.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = null;
		List<LaUser> userList = null;
		
		try {
			tx = session.beginTransaction();
			userList = session.createQuery("From LaUser").list();			
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
		return userList;
		
	}
	
	public static boolean addAdmin(LaUser tempadmin) {
		
		SessionFactory sf = dbAccess.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = null;
		boolean addedResult = false;
		
		try {
			tx = session.beginTransaction();
			session.save(tempadmin);
			tx.commit();
			addedResult = true;
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) {
				session.close();
				sf.close();
			}
		}
		return addedResult;
		
	}
}
