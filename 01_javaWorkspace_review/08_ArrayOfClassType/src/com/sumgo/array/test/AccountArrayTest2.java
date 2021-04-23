package com.sumgo.array.test;

import com.sumgo.array.Account;
import com.sumgo.array.Customer;

public class AccountArrayTest2 {

	public static void main(String[] args) {
		Customer c = new Customer("�̻��", 951205);
		System.out.println(c.getAccs());
		
		Account[] accs = {
				new Account(100, "����"),
				new Account(200, "����"),
				new Account(300, "�츮")
		};
		c.setAccs(accs);
		System.out.println(c.getAccs());
		
		System.out.println(c.getCustomerInfo());
	}

}
