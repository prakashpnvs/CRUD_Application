package com.vanilla.crud.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vanilla.crud.entity.Product;
import com.vanilla.crud.exception.ProductNotFoundException;
import com.vanilla.crud.repository.ProductRepository;

@RestController
public class Controller {

	@Autowired
	ProductRepository productRepository;

	@GetMapping(path = "/")
	public String status() {
		return "Application is Up!";
	}

	@PostMapping(path = "/products")
	public Product createProduct(@Valid @RequestBody Product newProduct) {
		return productRepository.save(newProduct);
	}

	@GetMapping(path = "/products/{id}")
	public Product readProductbyId(@PathVariable Long id) {
		return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
	}

	@PutMapping(path = "/products/{id}")
	public Product updateProduct(@RequestBody Product newProduct, @PathVariable Long id) {
		return productRepository.findById(id).map(product -> {
			product.setProductType(newProduct.getProductType());
			product.setProductName(newProduct.getProductName());
			return productRepository.save(product);
		}).orElseGet(() -> {
			newProduct.setProductId(id);
			return productRepository.save(newProduct);
		});
	}

	@DeleteMapping(path = "/products/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		productRepository.deleteById(id);
	}

	@PostMapping(path = "/listofproducts")
	public List<Product> createProducts(@Valid @RequestBody List<Product> listOfProducts) {
		return productRepository.saveAll(listOfProducts);
	}

}