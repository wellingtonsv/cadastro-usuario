package com.well.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.well.hibernate.util.HibernateUtil;
import com.well.model.User;
import com.well.service.ILoginService;

/**
 * Classe respons�vel pelo login e valida��o do usuario
 * 
 * @author WVieira
 *
 */
public class LoginService implements ILoginService{

	private LoginService() {
		
	}
	
	@Override
	public boolean authenticateUser(String userId, String password) {
        User user = getUserByUserId(userId);          
        if(user!=null && user.getUserId().equals(userId) && user.getPassword().equals(password)){
            return true;
        }else{ 
            return false;
        }
    }
	
	@Override
    public User getUserByUserId(String userId) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        User user = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from User where userId='"+userId+"'");
            user = (User)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }
    
	@Override
    public List<User> getListOfUsers(){
        List<User> list = new ArrayList<User>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery("from User").list();                        
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }
	
	/**
	 * Retorna uma instancia de {@link LoginService}
	 * 
	 * @return {@link LoginService}
	 */
	public static final LoginService getInstanceLogin(){
		return new LoginService();
	}
}