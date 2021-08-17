package com.example.demo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ProductsService {

	
	@Resource(name="restTemplate")
	private RestTemplate restTemplate;
	
	@Resource
	private ProductsDao dao;
	
	@Resource
	private LoadBalancerClient loadBalancer;

	



	public List<Product> getAllProdcts() {
		return dao.getAllProdcts();
	}

	public Product getByName(String name) {
		return dao.getByName(name);
	}





	public String addProduct(String productCode, String name, int qty, double price, String category) {
		return dao.addProduct(productCode,name,  qty, price, category);
	}





	public String updateProduct(String productCode,String name, int qty, double price, String category) {
		return dao.updateProduct(productCode,name,  qty, price, category);

	}





	public String delete(String code) {
		return dao.delete(code);
	}

	public Product getByCode(String code) {
		return dao.getByCode(code);
	}
}
