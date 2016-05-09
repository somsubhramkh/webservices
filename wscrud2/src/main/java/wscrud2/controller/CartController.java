package wscrud2.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import wscrud2.model.Cart;
import wscrud2.model.Item;
import wscrud2.service.CartService;
import wscrud2.service.ItemService;

@RestController
public class CartController {

CartService cartService = new CartService();  
    
    @RequestMapping(value = "/carts", method = RequestMethod.GET, headers = "Accept=application/json")  
    public List<Cart> getCarts() {  
        List<Cart> listOfCarts = cartService.getAllCarts();  
        return listOfCarts;  
    }  
  
    @RequestMapping(value = "/cart/{id}", method = RequestMethod.GET, headers = "Accept=application/json")  
    public Cart getCartsById(@PathVariable int id) {  
        return cartService.getCart(id);  
    }  
  
    @RequestMapping(value = "/addcart", method = RequestMethod.POST, headers = "Accept=application/json")  
    public Cart addCart(@RequestBody Cart cart) {  
        return cartService.addCart(cart);  
    }  
  
    @RequestMapping(value = "/updatecart", method = RequestMethod.PUT, headers = "Accept=application/json")  
    public Cart updateCart(@RequestBody Cart cart) {  
        return cartService.updateCart(cart);  
  
    }  
  
    @RequestMapping(value = "/removecart/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")  
    public void deleteCart(@PathVariable("id") int id) {  
        cartService.deleteCart(id);  
  
    }
}
