package com.encore.cons;
/*
 * 1. ������
 * ��ü�� ������ ���̵� ����(ȣ��)�Ǵ� ��.
 * 
 * 
 * 2. �⺻ ������
 * ::
 * ���� �� ����
 * {} �ȿ��� �ƹ��� ���۵� ���� �ʴ� ������.
 */
public class Shirt {
	// 1. �ʵ� ����
	public String brandName;
	public double price;
	public boolean longSleeved;
	
	// ������ �����ϸ� public Shirt() {} ���� ���� �ʾƵ� ȣ��� : �⺻ ������...�ʵ� �ʱ�ȭ�� ���Ѵ�.
	public Shirt(String brandName, double price, boolean longSleeved) {
		this.brandName = brandName;
		this.price = price;
		this.longSleeved = longSleeved;
	}
	
	public String getDetails() {
		return brandName + ", " + price + ", " + longSleeved;
	}
}
