package com.neu.edu.yiziyin.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.neu.edu.yiziyin.model.user;

public class UserDAO extends DAO{
	public List<user> getUser() {
	      //  Session session = sessionFactory.getCurrentSession();
	        String hql = "from user";
	        Query<user> query = getSession().createQuery(hql);
	        List<user> uList = query.list();
	        return uList;
	    }
		
	
	public void addUser(user u) {
		Configuration cf = new Configuration();
    	SessionFactory sf = cf.configure("hibernate.cfg.xml").buildSessionFactory();
    	Session session = sf.openSession();
    	Transaction tx = session.beginTransaction();
    	session.save(u);
    	tx.commit();
    	session.close();
	}
	
	public user checklogin(String email, String pw) {
		String hql = "FROM user WHERE email= :email AND pw= :pw ";
		Query q = getSession().createQuery(hql);
		q.setParameter("email", email);
		q.setParameter("pw", pw);
		return  (user) q.uniqueResult();
	}
	
	@Transactional
	@Modifying
	public void updateApprove(int id) {
	      //  Session session = sessionFactory.getCurrentSession();
			begin();
	        String hql = "UPDATE user set approved= :approved Where id= :id";
	        Query q = getSession().createQuery(hql);
	        q.setParameter("id", id);
	        q.setParameter("approved", "T");
	        q.executeUpdate();
	        commit();
	    }
	
	@Transactional
	@Modifying
	public void delUser(int id) {
	      //  Session session = sessionFactory.getCurrentSession();
			begin();
	        String hql = "Delete FROM user Where id= :id";
	        Query q = getSession().createQuery(hql);
	        q.setParameter("id", id);
	        q.executeUpdate();
	        commit();
	    }

}
