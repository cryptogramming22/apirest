package com.cryptogramming.apirest.repository;


import domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ProductRepository extends MongoRepository<Product, Integer> {

}
