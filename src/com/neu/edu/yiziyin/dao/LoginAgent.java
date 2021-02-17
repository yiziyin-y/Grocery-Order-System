package com.neu.edu.yiziyin.dao;

public class LoginAgent {
	private int id;
	private String fn;
	private String ln;
	private String bos;
	
	private static LoginAgent instance;  
    private LoginAgent (){}  
    
    
    
    public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFn() {
		return fn;
	}



	public void setFn(String fn) {
		this.fn = fn;
	}



	public String getLn() {
		return ln;
	}



	public void setLn(String ln) {
		this.ln = ln;
	}



	public String getBos() {
		return bos;
	}



	public void setBos(String bos) {
		this.bos = bos;
	}



	public static synchronized LoginAgent  getInstance() {  
		if (instance == null) {  
	        instance = new LoginAgent();  
	    }  
	    return instance;   
    }  
}
