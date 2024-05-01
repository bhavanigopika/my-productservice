package com.ecommerce.myproductservice.controller;

import com.ecommerce.myproductservice.dtos.GetProductDto;
import com.ecommerce.myproductservice.models.Product;
import com.ecommerce.myproductservice.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class ProductController {
    private final ProductService prodServ;

    public ProductController(ProductService prodServ) {
        this.prodServ = prodServ;
    }


    @GetMapping("/{id}")
    public @ResponseBody GetProductDto getProductById(@PathVariable("id") long id) throws Exception {
        return prodServ.getProductById(id);//It goes to ProductService class
    }

    @GetMapping("")
    public @ResponseBody List<GetProductDto> getAllProducts() {
        return prodServ.getAllProducts();
    }
    @PostMapping("")
    public String createProduct(@RequestBody Product prod){
        System.out.println(prod.getPrice());
        System.out.println(prod.getTitle());
        System.out.println(prod.getId());
        System.out.println(prod.getCategory());
        System.out.println(prod.getDescription());
        System.out.println(prod.getImage());
        return "Product created";
    }
}