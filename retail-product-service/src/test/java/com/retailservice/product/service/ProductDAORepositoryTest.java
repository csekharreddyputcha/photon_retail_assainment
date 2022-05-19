package com.retailservice.product.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.retailservice.product.model.Product;
import com.retailservice.product.model.ProductPrice;
import com.retailservice.product.repository.ProductDaoRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
class ProductDAORepositoryTest {
	
	@Autowired
	private ProductDaoRepository productRepository;

	@Test
	void get_product_details_test() {
		
		List<Product> productList = productRepository.findAll();		
		assertEquals(5, productList.stream().count()); 
		
	}
	
	@Test
	void get_product_details_by_id_test() {
		
		Optional<Product> productOptional = productRepository.findById(1234);
		assertTrue(productOptional.isPresent());
		Product product = productOptional.isPresent()?productOptional.get():null;
		assertEquals("Test Test", product.getName()); 
		
	}
	
	@Test
	void save_product_details_test() {
		
		ProductPrice price = new ProductPrice();
		price.setPrice(567.34);
		Product product = new Product();
		product.setProductPrice(price);
		product.setSku("ABC4568");
		product.setName("Test Product99");
		product.setCategory("baby");
		product.setLastUpdated("2022-04-13");
		productRepository.save(product);
		
	}

}
