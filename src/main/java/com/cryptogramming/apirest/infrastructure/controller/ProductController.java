package com.cryptogramming.apirest.infrastructure.controller;


import com.cryptogramming.apirest.domain.IProduct;
import com.cryptogramming.apirest.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private IProduct productService;
    @GetMapping(value="/products",produces = "application/json")
    public ResponseEntity getProducts() {

        List<ProductDTO> response = productService.getAllProducts();

        return new ResponseEntity(response,HttpStatus.CREATED);

    }

    @PostMapping(value = "/products")
    public ResponseEntity  saveProduct(@RequestBody ProductDTO productDTO){

        productService.createProduct(productDTO);
        return new ResponseEntity(HttpStatus.CREATED);

    }

    @PutMapping(value = "/{productId}")
    public ResponseEntity  updateProduct(@PathVariable int productId,@RequestBody ProductDTO productDTO){

        ProductDTO response =  productService.updateProduct(productId,productDTO);
        return new ResponseEntity(response,HttpStatus.OK);

    }


    @DeleteMapping(value = "/{productId}")
    public ResponseEntity  deleteProduct(@PathVariable int productId){

        productService.deleteProduct(productId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }

    @PostMapping(value = "/upload/{productId}")
    public ResponseEntity saveImageProduct(@PathVariable int productId, @RequestParam("imageFile") MultipartFile imageFile) throws IOException {

        ProductDTO productDTO =  productService.addImageToProduct(productId,imageFile);

        if (productDTO == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(productDTO,HttpStatus.OK);


    }

}
