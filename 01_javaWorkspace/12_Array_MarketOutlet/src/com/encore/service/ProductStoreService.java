package com.encore.service;

import com.encore.vo.Product;

/*
 * ProductStore�� �ִ� �پ��� ��ǰ���� �ٷ�� ��ɸ��� ��� ���� Ŭ����...
 * �̷� ��ɸ����� �ۼ��� Ŭ������ Service(or Manage) Ŭ������ �Ѵ�.
 * 
 * �� Ŭ�������� �ٷ�� ��ɵ�...
 * 1) �پ��� ��ǰ���� maker�� ����ϴ� ���
 * 2) ��ǰ���� �� ���Ծ��� �����ϴ� ���
 * 3) Ư�� �ݾ� �̻��� �Ǵ� ��ǰ�� �����ϴ� ���
 * 4) Ư�� ȸ�� ��ǰ���� �����ϴ� ���
 * 5) ������ ��ǰ�� ��հ��� �����ϴ� ���
 * --> ����� Identifier �����ϴ� ����� �Բ�
 */
public class ProductStoreService {
	public void printAllProductMaker(Product[] pros) {
		for (Product p : pros) System.out.println(p.getMaker());
	}
	
	public int getTotalPrice(Product[] pros) {
		int total = 0; // int(return type)�� ���� ���� ����
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
		// ������ ������ �� ������ ���ϴ� �޼ҵ带 ȣ��...����
		// �� ������ ������ ������.
		return getTotalPrice(pros) / pros.length;
	}
}
