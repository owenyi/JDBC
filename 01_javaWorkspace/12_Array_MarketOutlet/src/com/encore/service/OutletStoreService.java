package com.encore.service;

import com.encore.vo.Customer;
import com.encore.vo.Product;

/*
 * ��ǰ�� �����ϴ� ��,
 * ������ ������ ��ǰ������ �ٷ�� �����
 * ��Ƴ��� ���� Ŭ����...
 * 
 */
public class OutletStoreService {
//	// 1. Ư�� ���� ������ ��ǰ ������ �����ϴ� ��� -------- param name?
//	public Product[] getProduct(Customer vo) {
//		return vo.getProducts();
//	}
//	
//	// 2. Ư�� ���� ������ ��ǰ�� maker�鸸 �����ϴ� ���
//	public String[] getAllProductMaker(Customer vo) {
//		Product[] pros = vo.getProducts();
//		String[] temp = new String[pros.length];
//		int idx = 0;
//		for (Product p : pros) temp[idx++] = p.getMaker();
//		return temp;
//	}
//	
//	// 3. Outlet�� �ִ� ��� ���� �����ϴ� ��� ------------ return String[] names?
//	public Customer[] getAllCustomer(Customer[] custs) {
//		Customer[] temp =  new Customer[custs.length];
//		int idx = 0;
//		for (Customer c : custs) temp[idx++] = c;
//		return temp;
//	}
//	
//	// 4. ��� �� �߿� Ư�� ���� �˻�(ã�Ƴ���)�ϴ� ��� ----------- param name? return Customer?
//	public Customer getACustomer(Customer[] custs, int ssn) {
//		Customer customer = null;
//		for (Customer c : custs) {
//			if(c.getSsn() == ssn)
//				customer = c;
//		}
//		return customer;
//	}
//	
//	// 5. Ư�� ���� ������ ���� �� �ְ��� �ش��ϴ� ������ ������ �����ϴ� ��� ---------- param name? return int
//	public int maxPriceProduct(Customer c) {
//		int maxPrice = 0;
//		Product[] pros = c.getProducts();
//		for (Product p : pros) {
//			if (maxPrice < p.getPrice())
//				maxPrice = p.getPrice();
//		}
//		return maxPrice;
//	}
//	
//	// 6. ��� ���� ������ ���� �� Ư�� ���� �̻��� ��ǰ�� �����ϴ� ��� ----- param Customer Arr, return Product Arr?
//	public Product[] getMorePriceProducts(Customer[] custs, int price) {
//		int len = 0;
//		for (Customer c : custs) 
//			len += c.getProducts().length;
//		Product[] temp = new Product[len];
//		int idx = 0;
//		for (Customer c : custs) {
//			Product[] products = c.getProducts();
//			for (Product p : products) {
//				if (p.getPrice() >= price) temp[idx++] = p;
//			}
//		}
//		return temp;
//	}
//	
//	// 7. ������ ���׿� ����ִ� ���鸸 �����ϴ� ��� -------- param Customer or name? return name?
//	public Customer[] getSameAddressCustomer(Customer[] custs, String address) {
//		Customer[] temp = new Customer[custs.length];
//		int idx = 0;
//		for (Customer c : custs) {
//			if (c.getAddress().equals(c))
//				temp[idx++] = c;
//		}
//		return temp;
//	}
	
	public Product[] getCertainCustomerProducts(Customer[] customers, String name) {
		for (Customer c : customers) {
			if (c.getName().equals(name)) return c.getProducts();
		}
		return null;
	}
	
	public String[] getCertainCustomerProductsMaker(Customer[] customers, String name) {
		for (Customer c : customers) {
			if (c.getName().equals(name)) {
				Product[] products = c.getProducts();
				String[] makers = new String[products.length];
				int idx = 0;
				for (Product p : products) {
					makers[idx++] = p.getMaker();
				}
				return makers;
			}
		}
		return null;
	}
	
	public String[] getCustomerNames(Customer[] customers) {
		int len = customers.length;
		String[] names = new String[len];
		for (int i = 0; i < len; i++) {
			names[i] = customers[i].getName();
		}
		return names;
	}
	
	public Customer searchCustomer(Customer[] customers, String name) {
		for (Customer c : customers) {
			if (c.getName().equals(name)) return c;
		}
		return null;
	}
	
	public int getMaxPrice(Customer[] customers, String name) {
		for (Customer c : customers) {
			if (c.getName().equals(name)) {
				Product[] products = c.getProducts();
				int max = products[0].getPrice();
				for (Product p : products) {
					if (max < p.getPrice()) max = p.getPrice();
				}
				return max;
			}
		}
		return 0;
	}
	
	public Product[] getMorePrice(Customer[] customers, int price) {
		int len = 0;
		for (Customer c : customers) 
			len += c.getProducts().length;
		Product[] returnProducts = new Product[len];
		int idx = 0;
		for (Customer c : customers) {
			Product[] products = c.getProducts();
			for (Product p : products) {
				if (p.getPrice() >= price) returnProducts[idx++] = p;
			}
		}
		return returnProducts;
	}
	
	
	
}
