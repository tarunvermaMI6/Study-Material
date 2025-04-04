package com.techie.microservices.demo.controller;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.RestAssured;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestInstance(Lifecycle.PER_CLASS)
public class ProductControllerRestAssuredTest {

	@BeforeAll
	void setup() {
		RestAssured.baseURI = "http://localhost:8080/api/product";
	}
	
	@Test
	void testGetProduct() {
	
		given()
        .when()
            .get("/get/1")
        .then()
            .statusCode(200)
            .body("productName",equalTo("Fan"))
            .body("price", equalTo(500));
    }
	}

