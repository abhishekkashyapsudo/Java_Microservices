package com.example.demo;

import javax.annotation.Resource;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("customers")
@RestController
@EnableCircuitBreaker
public class CustomerController {
	
	@Resource
	private CustomersService service;
	
	@GetMapping("/all")
	public String getAll() {
		return service.getAllProdcts();
		
	}
	
	@GetMapping("/name/{name}")
	public String getByName(@PathVariable String name) {
		return service.getByName(name);
		
	}
	
	
	
	

}
