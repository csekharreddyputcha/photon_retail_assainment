package com.retailservice.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retailservice.product.model.ProductPrice;

public interface ProductPriceRepository extends JpaRepository<ProductPrice, Integer>{

}
