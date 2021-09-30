package com.developers.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_details")
public class OrderDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderDetailId;
	
	@ManyToOne
	private Orders orderId;
	
	@ManyToOne
	private ProductDetails productDetailId;
	
	@Column(name="quantity")
	private int quantity;

	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetails(int orderDetailId, Orders orderId, ProductDetails productDetailId, int quantity) {
		super();
		this.orderDetailId = orderDetailId;
		this.orderId = orderId;
		this.productDetailId = productDetailId;
		this.quantity = quantity;
	}

	public int getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public Orders getOrderId() {
		return orderId;
	}

	public void setOrderId(Orders orderId) {
		this.orderId = orderId;
	}

	public ProductDetails getProductDetailId() {
		return productDetailId;
	}

	public void setProductDetailId(ProductDetails productDetailId) {
		this.productDetailId = productDetailId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderDetailId=" + orderDetailId + ", orderId=" + orderId + ", productDetailId="
				+ productDetailId + ", quantity=" + quantity + "]";
	}
	
	
	
	
	
}
