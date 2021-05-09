package com.sumgo.test;

import com.sumgo.vo.Product;

public class ProductArrayTest1 {

	public static void main(String[] args) {
		Product[] pros = {
			new Product("°¡±×¸°", 3000, 1, "µ¿¾ÆÁ¦¾à"),
			new Product("Á¨ºÏ", 1000000, 1, "ASUS"),
			new Product("»þÇÁ", 3000, 2, "zetstream")
		};
		
		for (Product p : pros)
			System.out.println(p);
	}

}
