package wscrud2.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import wscrud2.model.Cart;
import wscrud2.model.Item;
import wscrud2.model.Product;

public class CartService {

	static HashMap<Integer, Cart> cartIdMap = getCartIdMap();

	ItemService itemService=new ItemService();
	
	public CartService() {
		super();

		if (cartIdMap == null) {
			cartIdMap = new HashMap<Integer, Cart>();
			
			//Product prod1 = new Product(1, "Fender", "Strat", "Electric Guitar", 80000, "Guitar");
			
			Cart cart1=new Cart(1, itemService.getAllItems());
			cartIdMap.put(1, cart1);
			
			
		}
	}

	public List<Cart> getAllCarts() {
		List<Cart> carts = new ArrayList<Cart>(cartIdMap.values());
		return carts;
	}

	public Cart getCart(int id) {
		Cart cart = cartIdMap.get(id);
		return cart;
	}

	public Cart addCart(Cart cart) {
		cart.setId(getMaxId() + 1);
		cartIdMap.put(cart.getId(), cart);
		return cart;
	}

	public Cart updateCart(Cart cart) {
		if (cart.getId() <= 0)
			return null;
		cartIdMap.put(cart.getId(), cart);
		return cart;

	}

	public void deleteCart(int id) {
		cartIdMap.remove(id);
	}

	public static HashMap<Integer, Cart> getCartIdMap() {
		return cartIdMap;
	}

	// Utility method to get max id
	public static int getMaxId() {
		int max = 0;
		for (int id : cartIdMap.keySet()) {
			if (max <= id)
				max = id;

		}
		return max;
	}
}
