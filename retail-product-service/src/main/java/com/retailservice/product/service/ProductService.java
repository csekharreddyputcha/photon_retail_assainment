package com.retailservice.product.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailservice.product.exception.ProductNotFoundException;
import com.retailservice.product.model.Product;
import com.retailservice.product.model.ProductDTO;
import com.retailservice.product.repository.ProductDaoRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductDaoRepository productRepository;
	
	public List<ProductDTO> getProductDetails(){
	 return productRepository.findAll().stream()	
			.map(product -> {
				ProductDTO productDTO = new ProductDTO();
				BeanUtils.copyProperties(product, productDTO);
				productDTO.setPrice(product.getProductPrice().getPrice());
				return productDTO;
			})
			.collect(Collectors.toList());
		
	}
	
	public ProductDTO getProductById(int id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		
		if(optionalProduct.isEmpty())
			throw new ProductNotFoundException("Product Not Found with given ID");
		
		ProductDTO productDTO = new ProductDTO();
		optionalProduct.ifPresent(product-> {
			BeanUtils.copyProperties(product, productDTO);
			productDTO.setPrice(product.getProductPrice().getPrice());
		});
		return productDTO;
	}
	
	public List<ProductDTO> getProductsByCategory(String category) {
			
			return productRepository.findAllByCategory(category).stream()
					.map(product -> {
						ProductDTO productDTO = new ProductDTO();
						BeanUtils.copyProperties(product, productDTO);
						productDTO.setPrice(product.getProductPrice().getPrice());
						return productDTO;
					})
					.collect(Collectors.toList());
		
	}

}
