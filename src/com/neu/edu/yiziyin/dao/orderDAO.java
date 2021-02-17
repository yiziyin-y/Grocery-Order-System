package com.neu.edu.yiziyin.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neu.edu.yiziyin.model.order;
import com.neu.edu.yiziyin.model.orderDetail;
import com.neu.edu.yiziyin.model.product;


@Service
public class orderDAO extends DAO{
	public void addOrder(order o) {
		Configuration cf = new Configuration();
    	SessionFactory sf = cf.configure("hibernate.cfg.xml").buildSessionFactory();
    	Session session = sf.openSession();
    	Transaction tx = session.beginTransaction();
    	session.save(o);
    	tx.commit();
    	session.close();
	}
	
	public void addOrderDetail(orderDetail od) {
		Configuration cf = new Configuration();
    	SessionFactory sf = cf.configure("hibernate.cfg.xml").buildSessionFactory();
    	Session session = sf.openSession();
    	Transaction tx = session.beginTransaction();
    	session.save(od);
    	tx.commit();
    	session.close();
	}
	
	
	public List<order> getOrderbyUser(int customerId){
		String hql = "from order Where customerId= :customerId";
        Query<order> query = getSession().createQuery(hql);
        query.setParameter("customerId", customerId);
        List<order> oList = query.list();
        return oList;
	}
	
	public List<order> getAllOrder(){
		String hql = "from order";
        Query<order> query = getSession().createQuery(hql);
        List<order> oList = query.list();
        return oList;
	}
	
	public List<product> getOrderDetailbyOrderid(int orderId){
		String hql = "from orderDetail where orderId= :orderId";
        Query<orderDetail> query = getSession().createQuery(hql);
        query.setParameter("orderId", orderId);
        
        List<product> products = new ArrayList<product>();
        List<orderDetail> odList = query.list();
       
        for(orderDetail oDetail: odList) {
        	int pid = oDetail.getProductId();
        	if(pid == 1) {
        		product product = new product();
        		product.setName("Product Has Been Removed By Seller");
        		products.add(product);
        	}else {
        		productDao pDao = new productDao();
        		int num = oDetail.getNum();
        		product product =new product();
        		product = pDao.getProductbyID(pid);
        		product.setNum(num);
        		products.add(product);
        	}
        	
        }
        return products;
	}
	
	@Transactional
	@Modifying
	public void updateStatus(int id, String status) {
	      //  Session session = sessionFactory.getCurrentSession();
			begin();
	        String hql = "UPDATE order set status= :status Where id= :id";
	        Query q = getSession().createQuery(hql);
	        q.setParameter("id", id);
	        q.setParameter("status", status);
	        q.executeUpdate();
	        commit();
	    }

	@Transactional
	@Modifying
	public void delOrder(int id) {
	      //  Session session = sessionFactory.getCurrentSession();
			begin();
	        String hql = "Delete FROM order Where id= :id";
	        Query q = getSession().createQuery(hql);
	        q.setParameter("id", id);
	        q.executeUpdate();
	        commit();
	        delOrderDetail(id);
	    }
	
	@Transactional
	@Modifying
	public void delOrderDetail(int orderId) {

			begin();
	        String hql = "Delete FROM orderDetail Where orderId= :orderId";
	        Query q = getSession().createQuery(hql);
	        q.setParameter("orderId", orderId);
	        q.executeUpdate();
	        commit();
	    }
	
	@Transactional
	@Modifying
	public void delOrderDetailbyPID(int productId) {

			begin();
	        String hql = "UPDATE orderDetail set productId= 1 Where productId= :productId";
	        Query q = getSession().createQuery(hql);
	        q.setParameter("productId", productId);
	        q.executeUpdate();
	        commit();
	    }

}
