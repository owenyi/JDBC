package com.encore.array.test;

import com.encore.array.Account;
import com.encore.array.Customer;

public class AccountArrayTest2 {

	public static void main(String[] args) {
		// Account Type 배열 선언, 생성, 초기화
		Account[] accs = {
				new Account(1000.0, "신한은행"),
				new Account(30000.0, "국민은행"),
				 new Account(40000.0, "우리은행")
		};
		
		// 1. Customer 객체를 생성
		Customer c = new Customer("이상순", 951205);
		
		// 2. James라는 고객이 통장 3개를 Hasing 하도록 한다.
		c.setAccs(accs);
		
		// 3. James가 개설한 통장들을 받아온다.
		Account[] returnAcc = c.getAccs();
		
		// 4. James가 개설한 통장들 주ㅡㅇ에서 신한은행 통장에만 50000만원을 입금한다.
		for (Account a : returnAcc) {
			if (a.getBankName().equals("신한은행")) a.deposit(50000.0);
		}
		
		// 5. 각 통장들의 잔고를 확인한다.
		System.out.println("==========통장의 잔고를 확인합니다.=============");
		for (Account account : returnAcc) System.out.println(account.getDetail());
	}

}
