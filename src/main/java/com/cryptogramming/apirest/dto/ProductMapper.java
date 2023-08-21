package com.cryptogramming.apirest.dto;

import com.cryptogramming.apirest.domain.document.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "imagePath" , target = "file")
    ProductDTO productToProductDto(Product product);

    @Mapping(source = "file" , target = "imagePath")
    Product productDtoToProduct(ProductDTO productDTO);

}
