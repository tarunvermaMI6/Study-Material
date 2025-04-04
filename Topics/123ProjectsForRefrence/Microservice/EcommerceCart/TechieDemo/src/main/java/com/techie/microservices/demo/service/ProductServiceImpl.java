package com.techie.microservices.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.techie.microservices.demo.entity.Product;
import com.techie.microservices.demo.entity.repository.ProductRepository;
import com.techie.microservices.demo.request.model.ProductRequest;
import com.techie.microservices.demo.response.model.ProductResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository; // final keyword is mandatory
	
	/* using @RequiredArgsConstructor
	public ProductServiceImpl(ProductRepository productRepository) {
	
		this.productRepository = productRepository;
	} */
	
	@Override
	public List<ProductResponse> getAllProduct() {

		return productRepository.findAll().stream().map(prod -> ProductResponse.builder()
				.productName(prod.getProductName()).quantity(prod.getQuantity()).price(prod.getPrice()).build())
				.collect(Collectors.toList());
	}

	@Override
	public ProductResponse getProduct(int id) {
	
		Optional<Product> product = productRepository.findById(id);
		if(product.isPresent()) {
			
			return ProductResponse
					.builder()
					.productName(product.get().getProductName())
					.price(product.get().getPrice())
					.quantity(product.get().getQuantity()).build();
		}
		
		return null;
	}

	@Override
	public void addProduct(ProductRequest productRequest) {
		
		Product product = Product.builder().productName(productRequest.getProductName())
				.quantity(productRequest.getQuantity()).price(productRequest.getPrice()).build();
		
		productRepository.save(product);
	}

	@Override
	public void deleteProduct() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int updateProduct() {
		// TODO Auto-generated method stub
		return 0;
	}

}
