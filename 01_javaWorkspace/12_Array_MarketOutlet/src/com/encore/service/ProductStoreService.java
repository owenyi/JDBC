package com.encore.service;

import com.encore.vo.Product;

/*
 * ProductStore에 있는 다양한 상품들을 다루는 기능만을 모아 놓은 클래스...
 * 이런 기능만으로 작성된 클래스를 Service(or Manage) 클래스라 한다.
 * 
 * 이 클래스에서 다루는 기능들...
 * 1) 다양한 상품들의 maker를 출력하는 기능
 * 2) 상품들의 총 구입액을 리턴하는 기능
 * 3) 특정 금액 이상이 되는 상품을 리턴하는 기능
 * 4) 특정 회사 제품들을 리턴하는 기능
 * 5) 구입한 상품의 평균가를 리턴하는 기능
 * --> 기능의 Identifier 지정하는 방법도 함께
 */
public class ProductStoreService {
	public void printAllProductMaker(Product[] pros) {
		for (Product p : pros) System.out.println(p.getMaker());
	}
	
	public int getTotalPrice(Product[] pros) {
		int total = 0; // int(return type)의 변수 먼저 선언
		for (Product p : pros) total += p.getPrice() * p.getQuantity();
		return total;
	}
	
	public Product[] getMorePrice(Product[] pros, int price) {
		Product[] temp = new Product[pros.length];
		int idx = 0;
		for (Product p : pros) {
			if (p.getPrice() >= price) {
				temp[idx++] = p;
			}
		}
		return temp;
	}
	
	public Product[] getCertainCompany(Product[] pros, String company) {
		Product[] temp = new Product[pros.length];
		int idx = 0;
		for (Product p : pros) {
			if (p.getCompany().equals(company))
				temp[idx++] = p;
		}
		return temp;
	}
	
	public int getAvgPrice(Product[] pros) {
		// 위에서 정의한 총 가격을 구하는 메소드를 호출...재사용
		// 총 가격을 갯수로 나눈다.
		return getTotalPrice(pros) / pros.length;
	}
}
