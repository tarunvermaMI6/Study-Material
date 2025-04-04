package com.techie.microservices.demo.request.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductRequest {

	private int quantity;
	private String productName;
	private String price;
}
