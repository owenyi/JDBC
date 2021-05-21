package com.sumgo.service;

import com.sumgo.vo.Customer;
import com.sumgo.vo.Product;

public class OutletStoreService {

	// 1. 특정 고객(고객의 이름으로)이 구입한 상품 정보를 모두 보여주는 기능
	public Product[] getProductsByName(Customer[] cList, String name) {
		for (Customer c : cList)
			if (c.getName().equals(name)) return c.getPros();
		return null;
	}
	
	// 2. 특정 고객(고객의 이름으로)이 구입한 상품 중 최고가의 물건을 보여주는 기능
	public Product getProductMaxPrice(Customer[] cList, String name) {
		for (Customer c : cList) {
			if (c.getName().equals(name)) {
				int maxP = 0;
				for (Product p : c.getPros()) {
					if (p.getPrice() > maxP) maxP = p.getPrice();
				}
				for (Product p : c.getPros()) {
					if (p.getPrice() == maxP) return p;
				}
			}
		}
		return null;
	}
	
	// 3. 모든 고객이 구입한 상품 중 price1 이상 price2 이하의 물건을 보여주는 기능
	public Product[] getProductsByPrice(Customer[] cList, int price1, int price2) {
		Product[] pros = new Product[4];
		int idx = 0;
		for (Customer c : cList) {
			for (Product p : c.getPros()) {
				if (p.getPrice() >= price1 && p.getPrice() <= price2) pros[idx++] = p;
			}
		}
		return pros;
	}
	
}
