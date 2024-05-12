package com.ecommerce.myproductservice.repository;

import com.ecommerce.myproductservice.models.GenericProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IGenericProductRepository extends JpaRepository<GenericProduct, Long> {
    Page<GenericProduct> findAll(Pageable pageable);
    Page<GenericProduct> findAllByName(String name, Pageable pageable);
}
