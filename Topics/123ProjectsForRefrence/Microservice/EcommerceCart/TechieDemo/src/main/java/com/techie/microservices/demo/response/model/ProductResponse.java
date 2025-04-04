package com.techie.microservices.demo.response.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ProductResponse {

	private int quantity;
	private String productName;
	private String price;
}
