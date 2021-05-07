package com.sumgo.array;

public class Account {
	
	private int balance;
	private String bankName;
	
	public Account(int balance, String bankName) {
		this.balance = balance;
		this.bankName = bankName;
	}
	
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public String getDetail() {
		return balance + ", " + bankName;
	}
	
	public void withdraw(int amount) {
		balance -= amount;
	}
	public void deposit(int amount) {
		balance += amount;
	}
	
	// toString 설명을 위해 추가
	public String toString() {
		return balance + ", " + bankName;
	}
	
}