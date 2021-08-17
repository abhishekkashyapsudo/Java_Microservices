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
public class OrdersService {

	
	@Resource(name="restTemplate")
	private RestTemplate restTemplate;
	
	@Resource
	private OrderDao dao;
	
	@Resource
	private LoadBalancerClient loadBalancer;

	
	
	public String all() {
		return "Call to PRODUCTS FAILED...!!!";
	}
	
	
	
	
	
	public String byNAme() {
		return "Call to PRODUCTS FAILED...!!!";
	}

	@HystrixCommand(fallbackMethod = "all")

	public String getAllProdcts() {
		String uri = loadBalancer.choose("products").getUri()+"/products/all";
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(uri);
				
		ResponseEntity<String> res = restTemplate.exchange(builder.buildAndExpand().toUri(), HttpMethod.GET, null, String.class);
		
		return res.getBody();
	}

	@HystrixCommand(fallbackMethod = "byNAme")
	public String getByName(String name) {
		String uri = loadBalancer.choose("products").getUri()+"/products/name/"+name;
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(uri);
				
		ResponseEntity<String> res = restTemplate.exchange(builder.buildAndExpand().toUri(), HttpMethod.GET, null, String.class);
		
		return res.getBody();
	}
	
	





	public String create(String id, String code) {
		Product p = getProduct(code);
		if(p==null) {
			return "No such product exists";
		}
		else if (p.getQuantity() <= 0) {
			return "Quantity is Inadequate";
			
		}
		else {
			decrementQty(code);
			dao.addOrder(id, code);

		}
		return null;
	}




	@HystrixCommand(fallbackMethod = "byNAme")
	private void decrementQty(String code) {
		String uri = loadBalancer.choose("products").getUri()+"/products/qty/"+code;
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(uri);
				
		restTemplate.exchange(builder.buildAndExpand().toUri(), HttpMethod.GET, null, String.class);
		
	}





	private Product getProduct(String code) {
		String uri = loadBalancer.choose("products").getUri()+"/products/code/"+code;
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(uri);
				
		ResponseEntity<Product> res = restTemplate.exchange(builder.buildAndExpand().toUri(), HttpMethod.GET, null, Product.class);
		
		return res.getBody();
	}
}
