package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    public ProductRepository repository;

    public Product saveProduct(Product product){
        return repository.save(product);
    }

    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products);
    }

    public List<Product> getProduct(){
        return repository.findAll();
    }

    public Product getProductById(int id){
        return repository.findById(id).orElse(null);
    }

    public Product getProductByName(String name){
        return repository.findByName(name);
    }

    public String deleteProduct(int id){
        repository.deleteById(id);
        return "Product removed !" + id;
    }

    public Product updateProduct(Product product){
        Product exsistingProduct = repository.findById(product.getId()).orElse(null);
        exsistingProduct.setName(product.getName());
        exsistingProduct.setQuantity(product.getQuantity());
        exsistingProduct.setAmount(product.getAmount());
        return repository.save(exsistingProduct);
    }
}
