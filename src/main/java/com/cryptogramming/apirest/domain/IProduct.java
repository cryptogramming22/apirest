package com.cryptogramming.apirest.domain;

import com.cryptogramming.apirest.dto.ProductDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IProduct {

     void createProduct(ProductDTO productDTO);
     ProductDTO updateProduct(int productId,ProductDTO productDTO);
     void deleteProduct(int productId);
     List<ProductDTO> getAllProducts();

    ProductDTO addImageToProduct(int productId, MultipartFile file) throws IOException;
}
