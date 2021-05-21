package com.sumgo.vo;

import java.util.Arrays;

public class Customer {

	private int ssn;
	private String name;
	private String addr;
	// has a
	private Product[] pros;
	public Customer(int ssn, String name, String addr, Product[] pros) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.addr = addr;
		this.pros = pros;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Product[] getPros() {
		return pros;
	}
	public void setPros(Product[] pros) {
		this.pros = pros;
	}
	@Override
	public String toString() {
		return "Customer [ssn=" + ssn + ", name=" + name + ", addr=" + addr + ", pros=" + Arrays.toString(pros) + "]";
	}
	
}
