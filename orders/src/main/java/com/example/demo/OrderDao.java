package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class OrderDao {
	
	private List<Order> orders = new ArrayList<>();
	
	


	public void addOrder(String id, String code) {
		this.orders.add(new Order(id, code));
	}
	
	public List<Order> all() {
		return this.orders;
	}
}
