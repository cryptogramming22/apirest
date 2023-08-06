package com.cryptogramming.apirest.dto;

import com.cryptogramming.apirest.domain.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "imagePath" , target = "imageUrl")
    ProductDTO productToProductDto(Product product);

    @Mapping(source = "imageUrl" , target = "imagePath")
    Product productDtoToProduct(ProductDTO productDTO);

}
