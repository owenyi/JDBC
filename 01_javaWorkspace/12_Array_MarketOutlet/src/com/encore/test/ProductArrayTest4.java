package com.encore.test;

import com.encore.service.OutletStoreService;
import com.encore.service.ProductStoreService;
import com.encore.vo.Customer;
import com.encore.vo.Product;
// OutletStoreService�� Hasing�Ǵ� Test Class...
public class ProductArrayTest4 {

	public static void main(String[] args) {
		OutletStoreService service = new OutletStoreService();
		
		Product[] pros1 = {
				new Product("���Ӹ���Ǫ", 23000, 2, "LG"), 
				new Product("��ټ�����", 2000, 7, "HP"), 
				new Product("�Ŷ��", 1200, 10, "SAMSUNG"),
				new Product("��Ÿ��", 340000, 1, "LG")
		};
		
		Product[] pros2 = {
				new Product("�׿�ġ��", 5600, 2, "CJ"), 
				new Product("�����", 2000, 2, "���"), 
				new Product("�Ŷ��", 2300, 10, "���")
		};
		
		Customer[] customers = new Customer[2];
		customers[0] = new Customer(111, "�̳���", "��赿");
		customers[1] = new Customer(222, "����", "��赿");
		
		customers[0].buyProducts(pros1);
		customers[1].buyProducts(pros2);
		
		///////////// �Ʒ������ʹ� Service�� ����� ȣ���� ���Դϴ�. ///////////
		System.out.println("\n======1. ======\n");
		Product[] returnProducts = service.getCertainCustomerProducts(customers, "�̳���");
		for (Product p : returnProducts) {
			System.out.println(p.getDetail());
		}

		System.out.println("\n======2. ======\n");
		String[] returnMakers = service.getCertainCustomerProductsMaker(customers, "�̳���");
		for (String m : returnMakers) {
			System.out.print(m + " ");
		}

		System.out.println("\n======3. ======\n");
		String[] returnNames = service.getCustomerNames(customers);
		for (String n : returnNames) {
			System.out.print(n + " ");
		}
		
		System.out.println("\n======4. ======\n");
		Customer returnCustomer = service.searchCustomer(customers, "�̳���");
		System.out.println(returnCustomer.getDetails());
		
		System.out.println("\n======5. ======\n");
		System.out.println(service.getMaxPrice(customers, "�̳���"));

		
		System.out.println("\n======6. ======\n");
		Product[] returnProducts2 = service.getMorePrice(customers, 5600);
		for (Product p : returnProducts2) {
			if (p == null) continue;
			System.out.println(p.getDetail());
		}
		
		System.out.println("\n======7. ======\n");
	}

}
