package com.vanilla.crud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="products")
@ApiModel(description = "Product details")
public class Product {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "product_id", unique = true, nullable = false)
	@ApiModelProperty(notes = "Product Id. Database generated")
	private Long productId;
	@Column(name = "product_type")
	@NotNull(message = "Product Type required")
	@Size(min = 1, max = 50, message = "Product Type should be atleast 1 character to a maximum of 50 characters")
	@ApiModelProperty(notes = "Type of the product")
	private String productType;
	@Column(name = "product_name")
	@NotNull(message = "Product Name required")
	@Size(min = 1, max = 50, message = "Product Name should be atleast 1 character to a maximum of 50 characters")
	@ApiModelProperty(notes = "Name of the product")
	private String productName;

	public Product() {
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Product(Long productId, String productType, String productName) {
		this.productId = productId;
		this.productType = productType;
		this.productName = productName;
	}

}
