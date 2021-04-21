package com.sumgo.encapsulation;
/*
 * Encapsulation Pattern
 * 1. �ʵ�� �ٸ� Ŭ�������� ���� �������� ���ϵ���
 *    �ʵ� �տ��� private
 * 2. Ŭ������ �б� ���� ������ getter/ setter
 *    + �߰����� �޼ҵ�
 *    �޼ҵ� �տ��� public
 */
public class MyDate {
	
	private int month;
	private int day;
	
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		if (month >= 1 && month <= 12) {
			this.month = month;
		} else {
			System.out.println("1���� 12���� �Է����ּ���.");
			// ���α׷��� ���� ���´�.
			System.exit(0);
		}
		
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		switch (month) {
			case 2:
				if (day >= 1 && day <= 28) {
					this.day = day;
				} else {
					System.out.println(month + "�� �Դϴ�. 1���� 28���� �Է����ּ���");
					System.exit(0);
				}
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				if (day >= 1 && day <= 30) {
					this.day = day;
				} else {
					System.out.println(month + "�� �Դϴ�. 1���� 30���� �Է����ּ���");
					System.exit(0);
				}
				break;
			default:
				if (day >= 1 && day <= 31) {
					this.day = day;
				} else {
					System.out.println(month + "�� �Դϴ�. 1���� 31���� �Է����ּ���");
					System.exit(0);
				}
		}
	}
	
}