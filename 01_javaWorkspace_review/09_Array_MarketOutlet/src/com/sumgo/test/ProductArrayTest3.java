package com.sumgo.test;

import java.util.Arrays;

import com.sumgo.service.OutletStoreService;
import com.sumgo.vo.Customer;
import com.sumgo.vo.Product;

public class ProductArrayTest3 {

	public static void main(String[] args) {
		OutletStoreService service = new OutletStoreService();
		
		Product[] pros1 = {
				new Product("����û�ұ�", 70, 1, "LG"),
				new Product("������", 100, 1, "SAMSUNG")
		};
		Product[] pros2 = {
				new Product("�����", 1, 3, "���"),
				new Product("�̰����ڵ��׽�Ʈ��", 2, 2, "�Ѻ�")
		};
		Customer c1 = new Customer(111, "�̻��", "����Ȧ��", pros1);
		Customer c2 = new Customer(222, "���ù�", "������", pros2);
		
//		System.out.println(c1);
//		System.out.println(c2);
		
		Customer[] cList = {c1, c2};
		
		for (Product p : service.getProductsByName(cList, "�̻��"))
			System.out.println(p);
		
		System.out.println(service.getProductMaxPrice(cList, "�̻��"));
		
		for (Product p : service.getProductsByPrice(cList, 1, 70)) {
			if (p != null) System.out.println(p);
		}
	}

}
