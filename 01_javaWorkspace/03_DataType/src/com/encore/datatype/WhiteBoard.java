package com.encore.datatype;

/*
 * 1. �ʵ�
 *    int ������, char �÷�, float ����, String ����ȸ��, String ����
 *    ��ũ��ġ ���θ� �� �� �ִ� �ʵ带 �߰�
 *    
 * 2. �޼ҵ�
 *    2�� ����
 *    - ���� Test Ŭ�������� �޾Ƽ� �ʵ忡 �Է��ϴ� ���
 *    - �ʵ忡 �Էµ�, Ȥ�� ����� ���� �ܼ�â���� ����ϴ� ���
 */
public class WhiteBoard {
	public int size;
	public char color;
	public float price;
	public String company;
	public String material;
	public boolean scratch;
	
	public void setField(int size, char color, float price, String company, String material, boolean scratch) {
		this.size = size;
		this.color = color;
		this.price = price;
		this.company = company;
		this.material = material;
		this.scratch = scratch;
	}
	
	public void printInfo() {
		System.out.println(size + "\t" + color + "\t" + price + "\t" + company + "\t" + material + "\t" + scratch);
	}
}
