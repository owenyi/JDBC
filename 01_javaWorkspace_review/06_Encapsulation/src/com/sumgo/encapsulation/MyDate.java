package com.sumgo.encapsulation;
/*
 * Encapsulation Pattern
 * 1. 필드는 다른 클래스에서 직접 접근하지 못하도록
 *    필드 앞에는 private
 * 2. 클래스의 읽기 쓰기 권한을 getter/ setter
 *    + 추가적인 메소드
 *    메소드 앞에는 public
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
			System.out.println("1부터 12까지 입력해주세요.");
			// 프로그램을 빠져 나온다.
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
					System.out.println(month + "월 입니다. 1부터 28까지 입력해주세요");
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
					System.out.println(month + "월 입니다. 1부터 30까지 입력해주세요");
					System.exit(0);
				}
				break;
			default:
				if (day >= 1 && day <= 31) {
					this.day = day;
				} else {
					System.out.println(month + "월 입니다. 1부터 31까지 입력해주세요");
					System.exit(0);
				}
		}
	}
	
}