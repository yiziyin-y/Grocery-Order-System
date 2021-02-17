package com.neu.edu.yiziyin.model;

import java.util.List;

import javax.persistence.Basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name ="6220fin_product")
public class product {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Basic
	@Column(name = "name")
	private String name;
	@Basic
	@Column(name = "detail")
	private String detail;
	@Basic
	@Column(name = "price")
	private double price;
	@Basic
	@Column(name = "category")
	private String category;
	@Basic
	@Column(name = "stock")
	private int stock;
	@Basic
	@Column(name = "filepath")
	private String filepath;
	
	@Transient
	private int num;
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public product(int id, String name, String detail, double price, String category, int stock, String filepath) {
		super();
		this.id = id;
		this.name = name;
		this.detail = detail;
		this.price = price;
		this.category = category;
		this.stock = stock;
		this.filepath = filepath;
	}
	public product() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "product [id=" + id + ", name=" + name + ", detail=" + detail + ", price=" + price + ", category="
				+ category + ", stock=" + stock + ", filepath=" + filepath + "]";
	}
	
	
	

}
