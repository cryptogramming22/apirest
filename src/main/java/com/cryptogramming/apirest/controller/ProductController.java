package com.cryptogramming.apirest.controller;


import com.cryptogramming.apirest.service.ProductService;
import domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    protected ProductService productService;
    @GetMapping(value="/products",produces = "application/json")
    public List<Product> getProducts() {
        return  productService.getAllItems();
    }

    @PostMapping(value = "/products")
    public ResponseEntity  saveProduct(@RequestBody Product product){


        productService.create(product);
        return new ResponseEntity(HttpStatus.OK);

    }
}
