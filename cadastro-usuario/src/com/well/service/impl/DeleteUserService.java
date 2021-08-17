package com.well.service.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.well.hibernate.util.HibernateUtil;
import com.well.model.User;
import com.well.service.IDeleteUserService;

public class DeleteUserService implements IDeleteUserService {

	@Override
	public void deleteUser(User user) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.delete(user);
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

	public static final DeleteUserService getIntance() {
		return new DeleteUserService();
	}
}
