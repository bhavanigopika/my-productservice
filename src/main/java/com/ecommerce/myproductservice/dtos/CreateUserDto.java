package com.ecommerce.myproductservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDto {
    private String name;
    private String email;
    //we will generate the id with ourselves
}
