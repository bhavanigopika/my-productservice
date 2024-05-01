package com.ecommerce.myproductservice.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@Data
public class Product {
    private long id;
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
    private String seller;
    private Rating rating;
}
@Getter
@Setter
class Rating{
    private BigDecimal rate;
    private int count;
}
