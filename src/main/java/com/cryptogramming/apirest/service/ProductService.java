package com.cryptogramming.apirest.service;

import com.cryptogramming.apirest.domain.BucketObject;
import com.cryptogramming.apirest.domain.IBucket;
import com.cryptogramming.apirest.domain.IProduct;
import com.cryptogramming.apirest.dto.ProductDTO;
import com.cryptogramming.apirest.dto.ProductMapper;
import com.cryptogramming.apirest.repository.ProductRepository;
import com.cryptogramming.apirest.domain.document.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public  class ProductService  implements IProduct{

    @Autowired
    ProductRepository repository;

    @Autowired
    IBucket bucketDataSource;

    public List<ProductDTO> getAllProducts() {

        List<Product>  products = repository.findAll();

        List<ProductDTO> productDTOS = products.stream().map(
                product -> ProductMapper.mapper.productToProductDto(product)).collect(Collectors.toList());

        return productDTOS;
    }



    public void createProduct(ProductDTO productDTO) {

        Product product = ProductMapper.mapper.productDtoToProduct(productDTO);
        product.setDistributor("ACME");
        Date dateNow = new Date();
        product.setReleaseDate(dateNow);
        repository.save(product);


    }

    public ProductDTO updateProduct(int productId,ProductDTO productDTO) {
        Product product = repository.findById(productId).orElse(null);

        if (product!=null){
            product.setTitle(productDTO.getTitle());
            product.setDescription(productDTO.getDescription());
            product = repository.save(product);
        }

        ProductDTO response =   ProductMapper.mapper.productToProductDto(product);

        return response;
    }

    public void deleteProduct(int productId) {
        Product product = repository.findById(productId).orElse(null);

        if (product!=null){
            repository.delete(product);
        }
    }

    public ProductDTO addImageToProduct(int productId, MultipartFile file) throws IOException {

        Product product = repository.findById(productId).orElse(null);

        if (product==null){
            return null;
        }

        BucketObject bucketObject =  bucketDataSource.uploadFile(file);

        product.setImagePath(bucketObject.getFileName());
        product.setBucket(bucketObject.getBucket());

        repository.save(product);
        ProductDTO response =   ProductMapper.mapper.productToProductDto(product);

        return  response;
    }

}
