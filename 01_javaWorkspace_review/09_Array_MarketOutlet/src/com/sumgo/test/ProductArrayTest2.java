package com.sumgo.test;

import com.sumgo.service.ProductStoreService;
import com.sumgo.vo.Product;

public class ProductArrayTest2 {

	public static void main(String[] args) {
		Product[] pros = {
				new Product("°¡±×¸°", 3000, 1, "µ¿¾ÆÁ¦¾à"),
				new Product("Á¨ºÏ", 1000000, 1, "ASUS"),
				new Product("»þÇÁ", 3000, 2, "zetstream")
			};
		
		ProductStoreService service = new ProductStoreService();
		
		System.out.println(service.getProductByName(pros, "»þÇÁ"));
		
		Product[] returnPros = service.getProductGTEPrice(pros, 3000);
		for (Product p : returnPros) System.out.println(p);
		
		System.out.println(service.getTotalPrice(pros));
	}

}