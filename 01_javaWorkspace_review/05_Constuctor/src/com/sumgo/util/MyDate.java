package com.sumgo.util;

public class MyDate {
	
	public int year;
	public int month;
	public int day;
	
	public MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public String getDate() {
		return year + "-" + month + "-" + day;
	}
	
}
