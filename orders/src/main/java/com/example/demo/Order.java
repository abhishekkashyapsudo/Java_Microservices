package com.example.demo;

public class Order {
	private String orderId;
	private String productId;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Order(String orderId, String productId) {
		super();
		this.orderId = orderId;
		this.productId = productId;
	}
	public Order() {
		super();
	}
	
	
	
}
