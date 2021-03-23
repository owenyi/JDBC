package com.encore.array;

public class Account {
	// 1. 필드 선언
	private double balance;
	private String bankName;
	
	// 2. 주입의 통로...생성자/setter
	public Account(double balance, String bankName) {
		super();
		this.balance = balance;
		this.bankName = bankName;
	}
	
	public String getBankName() {
		return bankName;
	}
	
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}



	// 3. 필드 정보를 받아옴
	public String getDetail() {
		return balance + ", " + bankName;
	}
	
	// 4. 나머지 기능
	public void withdraw(double amt) {
		if (balance >= amt) balance -= amt;
		else return;
	}
	
	public void deposit(double amt) {
		if (amt >= 1000) balance += amt;
		else return;
	}
}
