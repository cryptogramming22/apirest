package com.cryptogramming.apirest.service;

import com.cryptogramming.apirest.dto.ProductDTO;
import com.cryptogramming.apirest.repository.ProductRepository;
import com.cryptogramming.apirest.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public  class ProductService  {

    @Autowired
    ProductRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }


    public void createProduct(ProductDTO productDTO) {
        Product product = new Product(
                productDTO.getId(),
                productDTO.getImagePath(),
                productDTO.getTitle(),
                productDTO.getDescription()
        );

        repository.save(product);
    }

    public void updateProduct(int productId,ProductDTO productDTO) {
        Product product = repository.findById(productId).orElse(null);

        if (product!=null){
            product.setTitle(productDTO.getTitle());
            product.setDescription(productDTO.getDescription());
            repository.save(product);
        }
    }

    public void deleteProduct(int productId) {
        Product product = repository.findById(productId).orElse(null);

        if (product!=null){
            repository.delete(product);
        }
    }







}
