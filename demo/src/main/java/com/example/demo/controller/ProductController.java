package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crudOperations")
public class ProductController {

    @Autowired
    private ProductService service;

//    @RequestMapping(value = "addItem", method = RequestMethod.POST);
    @PostMapping("/addItem")
    public Product addProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }

    @PostMapping("/addMultipleItems")
    public List<Product> addMultipleProducts(@RequestBody List<Product> products){
        return service.saveProducts(products);
    }

    @GetMapping("/getItem")
    public List<Product> retrieveProduct(){
        return service.getProduct();
    }

    @GetMapping("/getItemById/{id}")
    public Product retrieveProductById(@PathVariable int id){
        return service.getProductById(id);
    }

    @GetMapping("/getItemByName/{name}")
    public Product retrieveProductByName(@PathVariable String name){
        return service.getProductByName(name);
    }

    @PutMapping("/updateItem")
    public Product updateProductDetails(@RequestBody Product product){
        return service.updateProduct(product);
    }

    @DeleteMapping("/deleteItem")
    public String deleteProductDetails(@RequestParam int id){
        return service.deleteProduct(id);
    }
}
