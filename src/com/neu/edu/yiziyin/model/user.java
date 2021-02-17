package com.neu.edu.yiziyin.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="6220fin_user")
public class user {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Basic
	@Column(name = "fname")
	private String Fname;
	@Basic
	@Column(name = "lname")
	private String Lname;
	@Basic
	@Column(name = "email")
	private String email;
	@Basic
	@Column(name = "pw")
	private String pw;
	@Basic
	@Column(name = "bors")
	private String bors;
	@Basic
	@Column(name = "approved")
	private String approved;
	

	public String getApproved() {
		return approved;
	}

	public void setApproved(String approved) {
		this.approved = approved;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return Fname;
	}

	public void setFname(String fname) {
		Fname = fname;
	}

	public String getLname() {
		return Lname;
	}

	public void setLname(String lname) {
		Lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getBors() {
		return bors;
	}

	public void setBors(String bors) {
		this.bors = bors;
	}

	@Override
	public String toString() {
		return "user [id=" + id + ", Fname=" + Fname + ", Lname=" + Lname + ", email=" + email + ", pw=" + pw
				+ ", bors=" + bors + "]";
	}
	
	
	

}
