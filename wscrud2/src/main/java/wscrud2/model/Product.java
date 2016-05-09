package wscrud2.model;

import java.io.Serializable;

public class Product implements Serializable{

	private int id;
	private String brand;
	private String name;
	private String desc;
	private double price;
	private String category;
	
	
	public Product()
	{
		super();
	}
	
	public Product(int id, String brand, String name, String desc, double price, String category) {
		super();
		this.id = id;
		this.brand = brand;
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.category = category;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
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
}
