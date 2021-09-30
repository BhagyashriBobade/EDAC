package com.developers.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="product_details")
public class ProductDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productDetailId;
	
	
	@ManyToOne
	private Users supplier;
	
	@ManyToOne
	private Products productId;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="available_quantity")
	private int availableQuantity;

	public ProductDetails() {
		super();
	}
	
	public ProductDetails(Users supplier) {
		
		this.supplier = supplier;
		
	}
	

	public ProductDetails(int productDetailId, Users supplier, Products productId, int quantity,
			int availableQuantity) {
		super();
		this.productDetailId = productDetailId;
		this.supplier = supplier;
		this.productId = productId;
		this.quantity = quantity;
		this.availableQuantity = availableQuantity;
	}

	@Override
	public String toString() {
		return "ProductDetails [productDetailId=" + productDetailId + ", supplier=" + supplier + ", productId="
				+ productId + ", quantity=" + quantity + ", availableQuantity=" + availableQuantity + "]";
	}

	public int getProductDetailId() {
		return productDetailId;
	}

	public void setProductDetailId(int productDetailId) {
		this.productDetailId = productDetailId;
	}

	public Users getSupplier() {
		return supplier;
	}

	public void setSupplier(Users supplier) {
		this.supplier = supplier;
	}

	public Products getProductId() {
		return productId;
	}

	public void setProductId(Products productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	
}
