package com.encore.test;

public class SwitchNoBreakTest3 {

	public static void main(String[] args) {
		/*
		 * 1. 객체 생성...식구를 메모리에 올린다.
		 * 2. 그리고 식구를 호출한다 / 메소드 호출...
		 * 결과적으로 메모리 안 올라간 놈은 사용할 수 없다.
		 * 
		 * 
		 * 그런데 사용 가능한 것들은 항상 메모리에 올라가 있기 때문
		 * static한 성질의 것들은 미리 올라가있음
		 * 
		 * 왜 Math 클래스의 메소드는 전부 static으로 만들어놨을까? 자주 사용해서
		 * random()을 쓰면은 double에 해당하는 값이 리턴
		 */
		
		double m = Math.random();
		System.out.println(m);
		
		int time = (int)(Math.random() * 4) + 8; // 8~11
		System.out.println("[현재 시각 : " + time + "시]");
		
		switch (time) {
			case 8:
				System.out.println("출근을 준비합니다.");
			case 9:
				System.out.println("회사 도착, 오전 회의합니다.");
			case 10:
				System.out.println("오전 업무를 봅니다.");
			case 11:
				System.out.println("외근 나갑니다.");
		}
	}

}
