package wscrud2.model;

import java.io.Serializable;
import java.util.List;

public class Cart implements Serializable{

	private int id;
	private List<Item> items;
	
	public Cart()
	{
		super();
	}
	
	public Cart(int id, List<Item> items) {
		super();
		this.id = id;
		this.items = items;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
	
}
