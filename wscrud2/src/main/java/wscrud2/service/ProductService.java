package wscrud2.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import wscrud2.model.Product;



public class ProductService {

	static HashMap<Integer, Product> productIdMap = getProductIdMap();

	public ProductService() {
		super();

		if (productIdMap == null) {
			productIdMap = new HashMap<Integer, Product>();
			Product prod1 = new Product(1, "Fender", "Strat", "Electric Guitar", 80000, "Guitar");
			Product prod2 = new Product(2, "Fender", "Tele", "Electric Guitar", 75000, "Guitar");
			productIdMap.put(1, prod1);
			productIdMap.put(2, prod2);
			
			
		}
	}

	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<Product>(productIdMap.values());
		return products;
	}

	public Product getProduct(int id) {
		Product product = productIdMap.get(id);
		return product;
	}

	public Product addProduct(Product product) {
		product.setId(getMaxId() + 1);
		productIdMap.put(product.getId(), product);
		return product;
	}

	public Product updateProduct(Product product) {
		if (product.getId() <= 0)
			return null;
		productIdMap.put(product.getId(), product);
		return product;

	}

	public void deleteProduct(int id) {
		productIdMap.remove(id);
	}

	public static HashMap<Integer, Product> getProductIdMap() {
		return productIdMap;
	}

	// Utility method to get max id
	public static int getMaxId() {
		int max = 0;
		for (int id : productIdMap.keySet()) {
			if (max <= id)
				max = id;

		}
		return max;
	}
}
