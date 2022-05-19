package com.retailservice.product.model;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
	
	private int productId;
	private String sku;
	private String name;
	private String category;
    private String lastUpdate; 
    private double price;

}
