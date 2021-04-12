package com.sumgo.cons;

import com.sumgo.util.MyDate;

public class Programmer {
	
	public String name;
	public String gender;
	public String lang;
	public int career;
	public MyDate birthday;
	
	public Programmer(String name, String gender, String lang, int career, MyDate birthday) {
		this.name = name;
		this.gender = gender;
		this.lang = lang;
		this.career = career;
		this.birthday = birthday;
	}
	
	public String getInfo() {
		return name + ", " + gender + ", " + lang + ", " + career + ", " + birthday;
	}
	
	// �������� ������ �����ϴ� ��� (���� = ���� * 1000)
	public int getAnnualSalary() {
		return career * 1000;
	}
	
	public String getName() {
		return name;
	}
	
}
