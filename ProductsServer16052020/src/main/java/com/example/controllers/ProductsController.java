package com.example.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.beans.Product;

@RestController
@RequestMapping("products")
public class ProductsController {
	private List<Product> products = new ArrayList<Product>();

	@GetMapping("getAll")
	public List<Product> getAllProducts() {
		products.add(new Product("Laptop", 9000, new Date(System.currentTimeMillis())));
		products.add(new Product("N95 Mask", 60, new Date(System.currentTimeMillis())));
		products.add(new Product("Labradoodle", 1800, new Date(System.currentTimeMillis())));
		products.add(new Product("Poodledoodle", 900, new Date(System.currentTimeMillis())));
		return products;
	}
}
