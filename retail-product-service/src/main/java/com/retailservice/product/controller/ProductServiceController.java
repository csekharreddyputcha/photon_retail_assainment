package com.retailservice.product.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retailservice.product.model.ProductDTO;
import com.retailservice.product.service.ProductService;


@RestController
@RequestMapping("/products")
public class ProductServiceController {
	
	
	public ProductService productService;
	@Autowired
	public ProductServiceController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping
	public List<ProductDTO> getProductDetails(){		
		return productService.getProductDetails();
	}
	
	@GetMapping("/id/{id}")
	public ProductDTO getProductById(@PathVariable("id") Integer id){		
		return productService.getProductById(id);
	}
	
	@GetMapping("/category/{category}")
	public List<ProductDTO> getProductByCategory(@PathVariable("category") String category){		
		return productService.getProductsByCategory(category);
	}

}
