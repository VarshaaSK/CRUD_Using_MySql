package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

//Product is entity/model name , and integer is datatype of primary key
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findByName(String name);
}
