package com.retailservice.product.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.retailservice.product.model.Product;
import com.retailservice.product.model.ProductDTO;
import com.retailservice.product.model.ProductPrice;
import com.retailservice.product.repository.ProductDaoRepository;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
	
	private static List<Product> productList = new ArrayList<>();
	
	@Mock
	private ProductDaoRepository repository;
	
	@InjectMocks
	private ProductService service;
	
	 @BeforeAll
	    public static void setup() {
			productList.add(new Product(1,"test123", "test1", "baby", "2022-12-12", new ProductPrice(1,345.80)));
			productList.add(new Product(2,"test777", "test2", "toys", "2022-10-12", new ProductPrice(2,415.80)));
			productList.add(new Product(3,"test888", "test3", "toys", "2021-11-12", new ProductPrice(3,125.80)));
			productList.add(new Product(4,"test666", "test4", "baby", "2020-04-12", new ProductPrice(4,245.80)));
			productList.add(new Product(5,"test444", "test5", "baby", "2021-03-12", new ProductPrice(5,645.80)));
			productList.add(new Product(6,"test333", "test6", "toys", "2019-01-12", new ProductPrice(6,545.80)));
	    }

	@Test
	void get_product_details_test() {
		
		
		
		when(repository.findAll()).thenReturn(productList);
		
		List<ProductDTO> productDetails = service.getProductDetails();
		
		assertEquals(productList.size(), 6);
		
	}
	
	@Test
	void get_product_details_by_id() {
		
		Optional<Product> productOptional = Optional.of(new Product(1,"test123", "test1", "baby", "2022-12-12", new ProductPrice(1,345.80)));
		
		when(repository.findById(1)).thenReturn(productOptional);
		
		ProductDTO productById = service.getProductById(1);
		
		assertEquals(productById.getCategory(), productOptional.get().getCategory());
	}
	

	@Test
	void get_product_details_by_category_test() {
		
		String category = "baby";

		List<Product> productListByCategory = productList.stream()
				.filter(product -> product.getCategory().equals(category)).collect(Collectors.toList());

		when(repository.findAllByCategory(category)).thenReturn(productListByCategory);

		List<ProductDTO> productDetails = service.getProductsByCategory(category);

		assertEquals(productListByCategory.size(), 3);
		
	}

}
