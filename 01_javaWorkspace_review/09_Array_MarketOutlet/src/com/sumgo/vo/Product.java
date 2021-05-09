package com.sumgo.vo;
/*
 * ��ǰ�� ���� ������ ���� �ִ� Ŭ����
 * VO class : Value Object, Ư���� ������ ����ִ� Ŭ����
 * 
 * 1. Field
 * 2. Contructor
 * 3. setter / getter
 * 4. toString
 */
public class Product {
	
	private String name;
	private int price;
	private int quantity;
	private String company;
	public Product(String name, int price, int quantity, String company) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.company = company;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", quantity=" + quantity + ", company=" + company + "]";
	}
	
}
