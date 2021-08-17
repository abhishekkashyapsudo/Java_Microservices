package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class CustomersDao {
	
	private List<Customer> customers;
	
	public CustomersDao() {
		this.customers = new ArrayList<>();
		this.customers.add(new Customer("101", "test"));
	}
	
}
