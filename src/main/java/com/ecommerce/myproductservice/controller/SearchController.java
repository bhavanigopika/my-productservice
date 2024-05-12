package com.ecommerce.myproductservice.controller;

import com.ecommerce.myproductservice.models.GenericProduct;
import com.ecommerce.myproductservice.service.GenericProductService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")

public class SearchController {
    private final GenericProductService genericProductService;

    public SearchController(GenericProductService genericProductService) {
        this.genericProductService = genericProductService;
    }


    @GetMapping("/generate")
    public ResponseEntity generateData() {
        //Response entity wrapping the body plus header fields plus http status
        //200 - ok , 400 - not found
        return ResponseEntity.ok(genericProductService.generateProductData());
    }

    @GetMapping("all")
    //public List<GenericProduct> searchProducts(@RequestParam(value = "q", required = false) String q)
    //since no instance of type variable T exist so use responseEntity<T>
    public ResponseEntity<List<GenericProduct>> searchProducts(@RequestParam(value = "q", required = false) String query){
        return ResponseEntity.ok(genericProductService.searchProducts(query));
    }

    @GetMapping("")
    public ResponseEntity<Page<GenericProduct>> searchProductsByPage(
            @RequestParam(value = "q", required = false) String query,
            @RequestParam(value = "pageNo") int pageNumber,
            @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize,
            @RequestParam(value = "s", required = false, defaultValue = "id-asc") String sorting){

        return ResponseEntity.ok(genericProductService.searchProductsByPagination(query, pageNumber, pageSize, sorting));
    }
}
