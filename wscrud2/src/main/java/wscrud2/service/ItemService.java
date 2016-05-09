package wscrud2.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import wscrud2.model.Item;
import wscrud2.model.Product;

public class ItemService {

	static HashMap<Integer, Item> itemIdMap = getItemIdMap();

	ProductService productService=new ProductService();
	
	public ItemService() {
		super();

		if (itemIdMap == null) {
			itemIdMap = new HashMap<Integer, Item>();
			
			Item item1 = new Item(1,productService.getProduct(1), 2);
			Item item2 = new Item(2,productService.getProduct(2), 1);
			itemIdMap.put(1, item1);
			itemIdMap.put(2, item2);
			
			
		}
	}

	public List<Item> getAllItems() {
		List<Item> items = new ArrayList<Item>(itemIdMap.values());
		return items;
	}

	public Item getItem(int id) {
		Item item = itemIdMap.get(id);
		return item;
	}

	public Item addItem(Item item) {
		item.setId(getMaxId() + 1);
		itemIdMap.put(item.getId(), item);
		return item;
	}

	public Item updateItem(Item item) {
		if (item.getId() <= 0)
			return null;
		itemIdMap.put(item.getId(), item);
		return item;

	}

	public void deleteItem(int id) {
		itemIdMap.remove(id);
	}

	public static HashMap<Integer, Item> getItemIdMap() {
		return itemIdMap;
	}

	// Utility method to get max id
	public static int getMaxId() {
		int max = 0;
		for (int id : itemIdMap.keySet()) {
			if (max <= id)
				max = id;

		}
		return max;
	}
	
}
