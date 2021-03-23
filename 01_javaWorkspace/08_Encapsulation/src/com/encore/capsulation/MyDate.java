package com.encore.capsulation;
/*
 * Encapsulation Pattern
 * 1. 다른 클래스에서 직접적으로 접근할 수 없도록
 *    필드 앞에 ---> private 지정한다.
 * 2. 클래스의 필드에 접근은 setter / getter 한다.
 *    그리고 얘네들이 다른 클래스에서도 서로 접근할 수 있도록 public
 * 3. 
 *    setXxx() {
 *        // 첫 라인에서 (필드 초기화 되기 직전!!!) 에 타당한 값만 받을 수 있도록 로직을 제어한다.
 *    }
 */
public class MyDate {
	// private 지정하면 클래스 안에서만 접근 가능
	private int month;
	private int day;
	
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		if (month >=1 && month <= 12) {
			this.month = month;
		} else {
			System.out.println("1부터 12까지 입력해주세요.");
			// 프로그램 빠져나온다.
			System.exit(0);
		}
	}
	public int getDay() {
		return day;
	}
	// 1, 3, 5, 7, 8, 10, 12 : 31
	// 2 : 28
	// 4, 6, 9, 11 : 30
	// 업으면 에러
	public void setDay(int day) {
		switch (month) {
			case 0:
				System.out.println("몇 월인지에 대한 정보가 없습니다.");
				System.exit(0);
			case 2:
				if (day >= 1 && day <= 28) {
					this.day = day;
				} else {
					System.out.println(month + "월 입니다. " + "1일부터 28일까지 입력해주세요.");
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
					System.out.println(month + "월 입니다. " + "1일부터 30일까지 입력해주세요.");
					System.exit(0);
				}
				break;
			default:
				if (day >= 1 && day <= 31) {
					this.day = day;
				} else {
					System.out.println(month + "월 입니다. " + "1일부터 31일까지 입력해주세요.");
					System.exit(0);
				}
		}
	}
	
	
}
