package wscrud2.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import wscrud2.model.Product;
import wscrud2.service.ProductService;


@RestController
public class ProductController {

    ProductService productService = new ProductService();  
    
    @RequestMapping(value = "/products", method = RequestMethod.GET, headers = "Accept=application/json")  
    public List<Product> getProducts() {  
        List<Product> listOfProducts = productService.getAllProducts();  
        return listOfProducts;  
    }  
  
    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET, headers = "Accept=application/json")  
    public Product getProductById(@PathVariable int id) {  
        return productService.getProduct(id);  
    }  
  
    @RequestMapping(value = "/products", method = RequestMethod.POST, headers = "Accept=application/json")  
    public Product addProduct(@RequestBody Product product) {  
        return productService.addProduct(product);  
    }  
  
    @RequestMapping(value = "/products", method = RequestMethod.PUT, headers = "Accept=application/json")  
    public Product updateProduct(@RequestBody Product product) {  
        return productService.updateProduct(product);  
  
    }  
  
    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")  
    public void deleteProduct(@PathVariable("id") int id) {  
        productService.deleteProduct(id);  
  
    }
}
