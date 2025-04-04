package com.techie.microservices.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Product {

	@Column(name="product_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	private int quantity;
	@Column(name="product_name")
	private String productName;
	private String price;

}
