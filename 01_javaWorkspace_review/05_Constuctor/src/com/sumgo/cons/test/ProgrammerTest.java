package com.sumgo.cons.test;

import com.sumgo.cons.Programmer;
import com.sumgo.util.MyDate;

public class ProgrammerTest {

	public static void main(String[] args) {
		// 1. pro1, pro2 ��ü ���� + �����ڷ� �ʵ忡 �� �Ҵ�
		// Taekmin
		// 2. �ʵ� ������ �ܼ�â���� ���
		// 3. Taekmin�� ������ ...�޷��Դϴ�...��µǵ��� ���� �ۼ�
		
		Programmer pro1 = new Programmer("Taekmin", "����", "Java", 2, new MyDate(2001, 12, 5));
		Programmer pro2 = new Programmer("Suelgi", "����", "python", 5, new MyDate(1996, 7, 8));
		
		System.out.println(pro1.getInfo()); // 2001-12-5
		System.out.println(pro2.getInfo());
		
	}

}
