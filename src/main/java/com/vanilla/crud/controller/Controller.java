package com.vanilla.crud.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vanilla.crud.entity.Product;
import com.vanilla.crud.exception.ProductNotFoundException;
import com.vanilla.crud.repository.ProductRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/api/v1")
@Api(value = "Product Management")
public class Controller {

	@Autowired
	ProductRepository productRepository;

	@ApiOperation(value = "View a list of all available products", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 401, message = "Not authorized to access the resource"),
			@ApiResponse(code = 403, message = "Aceess forbidden"),
			@ApiResponse(code = 404, message = "Resource not found") })
	@GetMapping(path = "/products")
	@Cacheable
	public List<Product> retrieveListOfProducts() {
		return productRepository.findAll();
	}

	@ApiOperation(value = "Create a single product")
	@PostMapping(path = "/products")
	public Product createProduct(@Valid @RequestBody Product newProduct) {
		return productRepository.save(newProduct);
	}

	@ApiOperation(value = "View a product by Id")
	@Cacheable
	@GetMapping(path = "/products/{id}")
	public Product retrieveProductbyId(@PathVariable Long id) {
		return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
	}

	@ApiOperation(value = "Update a product by Id")
	@PutMapping(path = "/products/{id}")
	public Product updateProduct(@RequestBody Product newProduct, @PathVariable Long id) {
		retrieveProductbyId(id);
		return productRepository.findById(id).map(product -> {
			product.setProductType(newProduct.getProductType());
			product.setProductName(newProduct.getProductName());
			return productRepository.save(product);
		}).orElseGet(() -> {
			newProduct.setProductId(id);
			return productRepository.save(newProduct);
		});
	}

	@ApiOperation(value = "Delete a product by Id")
	@DeleteMapping(path = "/products/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		retrieveProductbyId(id);
		productRepository.deleteById(id);
	}

	@ApiOperation(value = "Create multiple products")
	@PostMapping(path = "/products/list")
	public List<Product> createListOfProducts(@Valid @RequestBody List<Product> listOfProducts) {
		return productRepository.saveAll(listOfProducts);
	}

}