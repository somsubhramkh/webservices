package wscrud2.model;

import java.io.Serializable;

public class Item implements Serializable{

	private int id;
	private Product product;
	private int quantity;
	private double totalPrice;
	
	
	
	public Item() {
		super();
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Item(int id,Product product, int quantity) {
		super();
		this.id=id;
		this.product = product;
		this.quantity = quantity;
		this.totalPrice=product.getPrice()*quantity;
		
	}


	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getTotalPrice() {
		return product.getPrice()*quantity;
	}


	
	
}
