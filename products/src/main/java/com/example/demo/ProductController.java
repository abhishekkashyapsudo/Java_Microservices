package com.example.demo;

import java.util.List;

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

@RequestMapping("products")
@RestController
@EnableCircuitBreaker
public class ProductController {
	
	@Resource
	private ProductsService service;
	
	@GetMapping("/all")
	public List<Product> getAll() {
		return service.getAllProdcts();
		
	}
	
	@GetMapping("/name/{name}")
	public Product getByName(@PathVariable String name) {
		return service.getByName(name);
	}
	
	@GetMapping("/code/{code}")
	public Product getByCode(@PathVariable String code) {
		return service.getByCode(code);
		
	}
	
	@GetMapping("/qty/{code}")
	public String dec(@PathVariable String code) {
		Product p = service.getByCode(code);
		if(p ==null) {
			return " "
					+ "Not exists";
		}
		p.setQuantity(p.getQuantity()-1);
		return "Updated";
		
	}
	
	@PostMapping("/add")
	public String addProduct(@RequestParam("code") String productCode,@RequestParam("name") String name, @RequestParam("quantity") int qty,
			@RequestParam("price") double price,@RequestParam("category") String category) {
		return service.addProduct(productCode,name,  qty, price, category);
		
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
