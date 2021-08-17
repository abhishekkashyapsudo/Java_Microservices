package com.example.demo;

import javax.annotation.Resource;

import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class AdminService {

	
	@Resource(name="restTemplate")
	private RestTemplate restTemplate;
	
	@Resource
	private AdminDao dao;
	
	@Resource
	private LoadBalancerClient loadBalancer;

	//@HystrixCommand(fallbackMethod = "addFallback")
	public String addProduct(String productCode,String name, int qty, double price, String category) {
		String uri = loadBalancer.choose("products").getUri()+"/products/add";
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(uri)
				.queryParam("code", productCode)
				.queryParam("name", name)

				.queryParam("quantity", qty)
				.queryParam("price", price)
				.queryParam("category", category);
		ResponseEntity<String> res = restTemplate.exchange(builder.buildAndExpand().toUri(), HttpMethod.POST, null, String.class);
		
		return res.getBody();
	}
	
	public String addFallback(String productCode,String name, int qty, double price, String category) {
		return "Call to PRODUCTS FAILED...!!!";
	}
	
	//@HystrixCommand(fallbackMethod = "updateFallback")
	public String updateProduct(String productCode,String name, int qty, double price, String category) {
		String uri = loadBalancer.choose("products").getUri()+"/products/update";
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(uri)
				.queryParam("code", productCode)
				.queryParam("name", name)
				.queryParam("quantity", qty)
				.queryParam("price", price)
				.queryParam("category", category);
		ResponseEntity<String> res = restTemplate.exchange(builder.buildAndExpand().toUri(), HttpMethod.PUT, null, String.class);
		
		return res.getBody();
	}
	
	public String updateFallback(String productCode,String name, int qty, double price, String category){
		return "Call to PRODUCTS FAILED...!!!";
	}

	//@HystrixCommand(fallbackMethod = "deleteFallback")
	public String delete(String code) {
		String uri = loadBalancer.choose("products").getUri()+"/products/"+code;
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(uri);
				
		ResponseEntity<String> res = restTemplate.exchange(builder.buildAndExpand().toUri(), HttpMethod.DELETE, null, String.class);
		
		return res.getBody();

	}
	
	public String deleteFallback(String code) {
		return "Call to PRODUCTS FAILED...!!!";
	}
}
