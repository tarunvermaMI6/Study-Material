package com.techie.microservices.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techie.microservices.demo.request.model.ProductRequest;
import com.techie.microservices.demo.response.model.ProductResponse;
import com.techie.microservices.demo.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

	private final ProductService productService;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add")
	public void addProduct(@RequestBody ProductRequest productRequest) {
		productService.addProduct(productRequest);

	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> getProduct(@PathVariable("id") int id) {

		try {
			ProductResponse productResponse = productService.getProduct(id);
			if (productResponse != null) {
				return new ResponseEntity<ProductResponse>(productResponse, HttpStatus.OK);
			}
			return new ResponseEntity<String>("Product not Found", HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<String>("Some Error Occurred", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAllProducts() {

		try {
			List<ProductResponse> products = productService.getAllProduct();
			if (products.size() > 0) {
				return new ResponseEntity<List<ProductResponse>>(products, HttpStatus.OK);
			}
			return new ResponseEntity<String>("No Products", HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<String>("Some Error Occurred", HttpStatus.BAD_REQUEST);
		}
	}
}
