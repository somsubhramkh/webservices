package wscrud2.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import wscrud2.model.Item;
import wscrud2.model.Product;
import wscrud2.service.ItemService;
import wscrud2.service.ProductService;

@RestController
public class ItemController {

ItemService itemService = new ItemService();  
    
    @RequestMapping(value = "/cart/items", method = RequestMethod.GET, headers = "Accept=application/json")  
    public List<Item> getItems() {  
        List<Item> listOfItems = itemService.getAllItems();  
        return listOfItems;  
    }  
  
    @RequestMapping(value = "/cart/item/{id}", method = RequestMethod.GET, headers = "Accept=application/json")  
    public Item getItemsById(@PathVariable int id) {  
        return itemService.getItem(id);  
    }  
  
    @RequestMapping(value = "/cart/additem", method = RequestMethod.POST, headers = "Accept=application/json")  
    public Item addItem(@RequestBody Item item) {  
        return itemService.addItem(item);  
    }  
  
    @RequestMapping(value = "/cart/updateitem", method = RequestMethod.PUT, headers = "Accept=application/json")  
    public Item updateItem(@RequestBody Item item) {  
        return itemService.updateItem(item);  
  
    }  
  
    @RequestMapping(value = "/cart/deleteitem/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")  
    public void deleteItem(@PathVariable("id") int id) {  
        itemService.deleteItem(id);  
  
    }
	
}
