package com.neu.edu.yiziyin.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neu.edu.yiziyin.model.product;


@Service
public class productDao extends DAO{
	public void addProduct(product p) {
		Configuration cf = new Configuration();
    	SessionFactory sf = cf.configure("hibernate.cfg.xml").buildSessionFactory();
    	Session session = sf.openSession();
    	Transaction tx = session.beginTransaction();
    	session.save(p);
    	tx.commit();
    	session.close();
	}
	
	
	public List<product> getProduct() {
      //  Session session = sessionFactory.getCurrentSession();
        String hql = "from product";
        Query<product> query = getSession().createQuery(hql);
        List<product> pList = query.list();
        return pList;
    }
	
	public product getProductbyID(int id) {
	      //  Session session = sessionFactory.getCurrentSession();
	        String hql = "from product Where id= :id";
	        Query<product> query = getSession().createQuery(hql);
	        query.setParameter("id", id);
	        System.out.println("getPbyID:" + id);
	        List<product> pList = query.list();
	        product p = pList.get(0);
	        
	        return p;
	    }
	
	@Transactional
	@Modifying
	public void delProduct(int id) {
	      //  Session session = sessionFactory.getCurrentSession();
			begin();
	        String hql = "Delete FROM product Where id= :id";
	        Query q = getSession().createQuery(hql);
	        q.setParameter("id", id);
	        q.executeUpdate();
	        commit();
	    }
	

	@Transactional
	@Modifying
	public void updateProduct(int id, product p) {
	      //  Session session = sessionFactory.getCurrentSession();
			begin();
	        String hql = "UPDATE product set stock= :stock, name= :name, detail= :detail, "
	        		+ "price= :price, filepath= :filepath, category= :category Where id= :id";
	        Query q = getSession().createQuery(hql);
	        System.out.println(p);
	        q.setParameter("id", id);
	        int stock = p.getStock();
	        q.setParameter("stock", stock);
	        String name = p.getName();
	        q.setParameter("name", name);
	        String detail = p.getDetail();
	        q.setParameter("detail", detail);
	        double price = p.getPrice();
	        q.setParameter("price", price);
	        String filepath = p.getFilepath();
	        q.setParameter("filepath", filepath);
	        String category = p.getCategory();
	        q.setParameter("category", category);
	        q.executeUpdate();
	        commit();
	    }
	
	@Transactional
	@Modifying
	public void updateStock(int id, int stock) {
	      //  Session session = sessionFactory.getCurrentSession();
			begin();
	        String hql = "UPDATE product set stock= :stock Where id= :id";
	        Query q = getSession().createQuery(hql);
	        q.setParameter("id", id);
	        q.setParameter("stock", stock);
	        q.executeUpdate();
	        commit();
	    }


}
