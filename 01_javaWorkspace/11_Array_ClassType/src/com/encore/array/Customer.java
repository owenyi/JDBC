package com.encore.array;

public class Customer {
	// 1. 필드 선언
	private String name;
	private int ssn;
	private Account[] accs;
	
	// 2. 주입의 통로
	public Customer(String name, int ssn) {
		super();
		this.name = name;
		this.ssn = ssn;
	}
	
	
	
	public void setAccs(Account[] accs) {
		this.accs = accs;
//		this.accs = new Account[accs.length];
//		for (int i = 0; i < accs.length; i++) {
//			this.accs[i] = accs[i];
//		}
	}
	
	public Account[] getAccs() {
		return accs;
	}

	// 3. 필드 정보 받아옴
	public String getCustomerInfo() {
		String accsDetails = "";
		for (int i = 0; i < accs.length - 1; i++) {
			accsDetails += accs[i].getDetail() + ", ";
		}
		accsDetails += accs[accs.length - 1].getDetail();
		return name + ", " + ssn + ", " + accsDetails;
	}
}
