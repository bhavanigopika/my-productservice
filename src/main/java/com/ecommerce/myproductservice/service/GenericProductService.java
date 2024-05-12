package com.ecommerce.myproductservice.service;

import com.ecommerce.myproductservice.models.GenericProduct;
import com.ecommerce.myproductservice.repository.IGenericProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class GenericProductService {
    private final IGenericProductRepository genericProductRepository;

    public GenericProductService(IGenericProductRepository genericProductRepository){
        this.genericProductRepository = genericProductRepository;
    }

    private static final String[] PRODUCT_NAMES= {
            "TV", "Headphones", "Smartphone", "Laptop", "Tablet",
            "Camera", "Speaker", "Drone", "Gaming Console", "Smartwatch",
            "Fitness Tracker", "External Hard Drive", "Monitor", "Router",
            "Printer", "Keyboard", "Mouse", "Earbuds", "Projector", "Desk"
    };

    public boolean generateProductData() {

        List<GenericProduct> productList = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < PRODUCT_NAMES.length; i++){
            String productName = PRODUCT_NAMES[i];
            int price = random.nextInt(10000);

            GenericProduct genericProduct = new GenericProduct(productName, price);
            productList.add(genericProduct);
        }
        //save to the repository
        genericProductRepository.saveAll(productList);
        return true;

    }

    public List<GenericProduct> searchProducts(String query) {
        List<GenericProduct> all = genericProductRepository.findAll();
        return all;
        //or
        //return genericProductRepository.findAll();
    }

    public Page<GenericProduct> searchProductsByPagination(String query, int pageNumber, int pageSize, String sorting) {
        //return genericProductRepository.findAll(PageRequest.of(pageNumber, pageSize));
        return switch (sorting){
            case "id-asc" ->
                    genericProductRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC,"id"));
            case  "name-desc" ->
                    genericProductRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.Direction.DESC,"name"));
            default ->
                    genericProductRepository.findAll(PageRequest.of(pageNumber, pageSize));
        };
        //return genericProductRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.Direction.DESC,"id"));
    }
}
