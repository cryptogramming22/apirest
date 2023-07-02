package com.cryptogramming.apirest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private int id;
    private String imagePath;
    private String title;
    private String description;
}
