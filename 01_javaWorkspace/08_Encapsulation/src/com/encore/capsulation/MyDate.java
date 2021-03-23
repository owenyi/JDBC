package com.encore.capsulation;
/*
 * Encapsulation Pattern
 * 1. �ٸ� Ŭ�������� ���������� ������ �� ������
 *    �ʵ� �տ� ---> private �����Ѵ�.
 * 2. Ŭ������ �ʵ忡 ������ setter / getter �Ѵ�.
 *    �׸��� ��׵��� �ٸ� Ŭ���������� ���� ������ �� �ֵ��� public
 * 3. 
 *    setXxx() {
 *        // ù ���ο��� (�ʵ� �ʱ�ȭ �Ǳ� ����!!!) �� Ÿ���� ���� ���� �� �ֵ��� ������ �����Ѵ�.
 *    }
 */
public class MyDate {
	// private �����ϸ� Ŭ���� �ȿ����� ���� ����
	private int month;
	private int day;
	
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		if (month >=1 && month <= 12) {
			this.month = month;
		} else {
			System.out.println("1���� 12���� �Է����ּ���.");
			// ���α׷� �������´�.
			System.exit(0);
		}
	}
	public int getDay() {
		return day;
	}
	// 1, 3, 5, 7, 8, 10, 12 : 31
	// 2 : 28
	// 4, 6, 9, 11 : 30
	// ������ ����
	public void setDay(int day) {
		switch (month) {
			case 0:
				System.out.println("�� �������� ���� ������ �����ϴ�.");
				System.exit(0);
			case 2:
				if (day >= 1 && day <= 28) {
					this.day = day;
				} else {
					System.out.println(month + "�� �Դϴ�. " + "1�Ϻ��� 28�ϱ��� �Է����ּ���.");
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
					System.out.println(month + "�� �Դϴ�. " + "1�Ϻ��� 30�ϱ��� �Է����ּ���.");
					System.exit(0);
				}
				break;
			default:
				if (day >= 1 && day <= 31) {
					this.day = day;
				} else {
					System.out.println(month + "�� �Դϴ�. " + "1�Ϻ��� 31�ϱ��� �Է����ּ���.");
					System.exit(0);
				}
		}
	}
	
	
}
