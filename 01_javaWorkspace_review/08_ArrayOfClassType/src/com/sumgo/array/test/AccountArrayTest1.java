package com.sumgo.array.test;

import com.sumgo.array.Account;

public class AccountArrayTest1 {

	public static void main(String[] args) {
		// 1. Account 타입 배열 생성...사이즈는 3
		Account[] arr = new Account[3];
		
		// 2. 각각의 칸에 신한, 국민, 우리은행 통장을 생성
		arr[0] = new Account(100, "신한");
		arr[1] = new Account(200, "국민");
		arr[2] = new Account(300, "우리");
		
		// arr[0].bankName = "기업"; // 이게 안 되니까 setter가 필요하다.
		
		// 3. for문으로 출력
		for (Account a : arr) {
			System.out.println(a.getDetail());
		}
	}

}
