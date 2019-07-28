package com.vanilla.crud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {

	@Id
	@GeneratedValue
	@Column(name = "product_id")
	private Long productId;
	@Column(name = "product_type")
	private String productType;
	@Column(name = "product_name")
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
