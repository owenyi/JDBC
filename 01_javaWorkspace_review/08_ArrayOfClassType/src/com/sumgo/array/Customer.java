package com.sumgo.array;

public class Customer {

	private String name;
	private int ssn;
	private Account[] accs;
	
	public Customer(String name, int ssn) {
		this.name = name;
		this.ssn = ssn;
	}
	
	public void setAccs(Account[] accs) {
		this.accs = accs;
	}
	public Account[] getAccs() {
		return accs;
	}
	
	public String getCustomerInfo() { // accs[0].getDetail accs[1] accs[2]
		String accsDetail = "";
		for (Account a : accs) {
			accsDetail += a.getDetail();
		}
		return name + ", " + ssn + ", " + accsDetail;
	}
	
}
