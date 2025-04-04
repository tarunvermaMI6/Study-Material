package com.techie.microservices.demo.service;

import java.util.List;

import com.techie.microservices.demo.entity.Product;
import com.techie.microservices.demo.request.model.ProductRequest;
import com.techie.microservices.demo.response.model.ProductResponse;

public interface ProductService {

	List<ProductResponse> getAllProduct();

	ProductResponse getProduct(int id);

	void addProduct(ProductRequest productRequest);

	void deleteProduct();

	int updateProduct();
}
