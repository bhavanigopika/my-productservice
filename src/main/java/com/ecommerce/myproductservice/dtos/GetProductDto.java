package com.ecommerce.myproductservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetProductDto {
    private String name;
    private Double price;
    private String imageUrl;
}
