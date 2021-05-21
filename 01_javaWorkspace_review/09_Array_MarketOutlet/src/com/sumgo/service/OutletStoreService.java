package com.sumgo.service;

import com.sumgo.vo.Customer;
import com.sumgo.vo.Product;

public class OutletStoreService {

	// 1. Ư�� ��(���� �̸�����)�� ������ ��ǰ ������ ��� �����ִ� ���
	public Product[] getProductsByName(Customer[] cList, String name) {
		for (Customer c : cList)
			if (c.getName().equals(name)) return c.getPros();
		return null;
	}
	
	// 2. Ư�� ��(���� �̸�����)�� ������ ��ǰ �� �ְ��� ������ �����ִ� ���
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
	
	// 3. ��� ���� ������ ��ǰ �� price1 �̻� price2 ������ ������ �����ִ� ���
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
