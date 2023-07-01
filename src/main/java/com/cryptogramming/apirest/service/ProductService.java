package com.cryptogramming.apirest.service;

import com.cryptogramming.apirest.repository.ProductRepository;
import domain.Product;
import domain.model.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public  class ProductService   implements CrudService<Product> {

    @Autowired
    ProductRepository repository;

    @Override
    public void create(Product product) {
        repository.save(product);
    }

    @Override
    public void update(String id, Product product) {
    }

    @Override
    public void delete(String id) {
    }

    @Override
    public Collection<Product> getItem() {
        return null;
    }

    @Override
    public List<Product> getAllItems() {
        return repository.findAll();
    }
}
