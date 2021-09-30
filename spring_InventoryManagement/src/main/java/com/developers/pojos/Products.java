package com.developers.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class Products {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productId;
	
	@Column(name="product_name")
	private String productName;
	

	@ManyToOne
	private Category categoryId;
	
	@Column(name="description")
	private String description;

	@Column(name="price")
	private double price;
	
	public Products(int productId, String productName, Category categoryId, String description, double price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.categoryId = categoryId;
		this.description = description;
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Category getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Category categoryId) {
		this.categoryId = categoryId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Products [productId=" + productId + ", productName=" + productName + ", categoryId=" + categoryId
				+ ", description=" + description + ", price=" + price + "]";
	}
}
