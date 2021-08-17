package com.well.service.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.well.hibernate.util.HibernateUtil;
import com.well.model.User;
import com.well.service.IAlterUserService;

public class AlterUserService implements IAlterUserService {

	@Override
	public void alterUser(User user) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.update(user);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public static final AlterUserService getInstanceAlter() {
		return new AlterUserService();
	}
}
