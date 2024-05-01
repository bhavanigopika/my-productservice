package com.ecommerce.myproductservice.service;

import com.ecommerce.myproductservice.dtos.GetProductDto;
import com.ecommerce.myproductservice.exceptions.NotFoundException;
import com.ecommerce.myproductservice.models.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier("ProudctService")
public class ProductService {
    public GetProductDto getProductById(Long id) throws NotFoundException {

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://fakestoreapi.com/products/" + id;
        Product prod = restTemplate.getForObject(url, Product.class);
        System.out.println(prod);

        if(prod == null){
            //return null;
            //or you can define the exception as
            throw new NotFoundException();
        }
        return convertToDto(prod);
    }
    private static GetProductDto convertToDto(Product prod) {
        //call the database
        //call the fake store api
        //https://fakestoreapi.com/products/5
        GetProductDto obj = new GetProductDto();
        obj.setName(prod.getTitle());
        obj.setPrice(prod.getPrice());
        obj.setImageUrl(prod.getImage());
        /*obj.setName("iphone");
        obj.setPrice(19000.0);
        obj.setImageUrl("www.apple.com");*/
        return obj;

        /*GetProductDto getProductDto = new GetProductDto();
        return getProductDto;
        // or
        return new GetProductDto();*/
    }
    /*
   1. Make a call to 3rd party API from local host
   2. Deserialize into java object. Java object returned as Array of products prods
   3. Convert the Array into ArrayList of Dto objects.
   */
    public List<GetProductDto> getAllProducts() {
        RestTemplate restTemplate = new RestTemplate();
        //list all the products, so no id here. previous, we used + id;
        String url = "https://fakestoreapi.com/products";
        Product prods[] = restTemplate.getForObject(url, Product[].class);
        //I will create a for loop which iterate all the products
        List <GetProductDto> returnedProducts = new ArrayList<>();
        for(Product p: prods){
            returnedProducts.add(convertToDto(p));
        }
        //return al;
        return returnedProducts;
    }
}
