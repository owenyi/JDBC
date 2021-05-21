package com.sumgo.test;

import java.util.Arrays;

import com.sumgo.service.OutletStoreService;
import com.sumgo.vo.Customer;
import com.sumgo.vo.Product;

public class ProductArrayTest3 {

	public static void main(String[] args) {
		OutletStoreService service = new OutletStoreService();
		
		Product[] pros1 = {
				new Product("무선청소기", 70, 1, "LG"),
				new Product("건조기", 100, 1, "SAMSUNG")
		};
		Product[] pros2 = {
				new Product("새우깡", 1, 3, "농심"),
				new Product("이것이코딩테스트다", 2, 2, "한빛")
		};
		Customer c1 = new Customer(111, "이상순", "미추홀구", pros1);
		Customer c2 = new Customer(222, "김택민", "남동구", pros2);
		
//		System.out.println(c1);
//		System.out.println(c2);
		
		Customer[] cList = {c1, c2};
		
		for (Product p : service.getProductsByName(cList, "이상순"))
			System.out.println(p);
		
		System.out.println(service.getProductMaxPrice(cList, "이상순"));
		
		for (Product p : service.getProductsByPrice(cList, 1, 70)) {
			if (p != null) System.out.println(p);
		}
	}

}
