package com.sumgo.service;

import com.sumgo.vo.Product;

public class ProductStoreService {
	
	public Product getProductByName(Product[] pros, String name) {
		for (Product p : pros) {
			if (p.getName().equals(name)) return p;
		}
		return null;
	}
	
}
