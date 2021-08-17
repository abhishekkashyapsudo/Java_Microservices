package com.example.demo;

import javax.annotation.Resource;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("adminservice")
@RestController
@EnableCircuitBreaker
public class AdminController {
	
	@Resource
	private AdminService service;
	
	@PostMapping("/add")
	public String addProduct(@RequestParam("code") String productCode,@RequestParam("name") String name, @RequestParam("quantity") int qty,
			@RequestParam("price") double price,@RequestParam("category") String category) {
		return service.addProduct(productCode, name, qty, price, category);
		
	}
	
	@PutMapping("/update")
	public String updateProduct(@RequestParam("code") String productCode,@RequestParam("name") String name, @RequestParam("quantity") int qty,
			@RequestParam("price") double price,@RequestParam("category") String category) {
		return service.updateProduct(productCode,name,  qty, price, category);
		
	}
	
	@DeleteMapping("/{code}")
	public String updateProduct(@PathVariable String code) {
		return service.delete(code);
		
	}
	
	
	

}
