package com.neu.edu.yiziyin.dao;

import java.util.ArrayList;
import java.util.List;

import com.neu.edu.yiziyin.model.product;

public class cartDAO {
	private static List<product> list = new ArrayList<>();
	
	private static cartDAO instance = new cartDAO();  
	private double total;
    private cartDAO (){}  
    
    
    
    public List<product> getList() {
		return list;
	}



	public void setList(List<product> list) {
		this.list = list;
	}
	
	public void add(product p) {
		list.add(p);
	}

	public void delete(String name) {
		for(int i = 0; i<list.size(); i++) {
			product p = list.get(i);
			if(p.getName().equals(name)) {
				list.remove(i);
				break;
			}
			
		}
	}

	public static synchronized cartDAO getInstance() {  
		if (instance == null) {  
	        instance = new cartDAO();  
	    }  
	    return instance;   
    }  
	
	public double getTotal() {
		total = 0;
		for(product p: list) {
			total += p.getPrice() *p.getNum();
		}
		return total;
	}

}
