package com.techie.microservices.demo.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techie.microservices.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	
}
