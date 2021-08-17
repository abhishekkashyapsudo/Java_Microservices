package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ProductsDao {

	private List<Product> products;
	
	public ProductsDao() {
		this.products = new ArrayList<>();
		this.products.add(new Product("C1","Test", 10, 20, "ELECTRONICS"));
	}
	public List<Product> getAllProdcts() {
		return products;
	}

	public Product getByName(String name) {
		for(Product p: products) {
			if(p.getName().equalsIgnoreCase(name))
				return p;
		}
		return null;
	}


	public String addProduct(String productCode,String name,  int qty, double price, String category) {
		for(Product p: products) {
			if(p.getProductCode().equalsIgnoreCase(productCode))
				return "Product with passed product code already exists";
		}
		products.add(new Product(productCode, name, qty, price, category));
		return "Product added successfully";
	}





	public String updateProduct(String productCode,String name,  int qty, double price, String category) {
		for(Product p: products) {
			if(p.getProductCode().equalsIgnoreCase(productCode)) {
				p.setName(name);
				p.setQuantity(qty);
				p.setPrice(price);
				p.setCategory(category);
				return "Product updated successfully";
			}
		}
		return "Product with passed product code not exists";

	}





	public String delete(String code) {
		Product temp = null;
		for(Product p: products) {
			if(p.getProductCode().equalsIgnoreCase(code))
			{
				temp = p;
				break;
			}
		}
		if(temp == null) {
			return "No order exists with the passed product code";
		}
		return "Product deleted successfully";
	}
	public Product getByCode(String code) {
		for(Product p: products) {
			if(p.getProductCode().equalsIgnoreCase(code))
				return p;
		}
		return null;
	}
	
}
