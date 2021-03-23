package com.encore.datatype;

/*
 * 1. 필드
 *    int 사이즈, char 컬러, float 가격, String 제조회사, String 재질
 *    스크래치 여부를 알 수 있는 필드를 추가
 *    
 * 2. 메소드
 *    2개 정의
 *    - 값을 Test 클래스에서 받아서 필드에 입력하는 기능
 *    - 필드에 입력된, 혹은 저장된 값을 콘솔창으로 출력하는 기능
 */
public class WhiteBoard {
	public int size;
	public char color;
	public float price;
	public String company;
	public String material;
	public boolean scratch;
	
	public void setField(int size, char color, float price, String company, String material, boolean scratch) {
		this.size = size;
		this.color = color;
		this.price = price;
		this.company = company;
		this.material = material;
		this.scratch = scratch;
	}
	
	public void printInfo() {
		System.out.println(size + "\t" + color + "\t" + price + "\t" + company + "\t" + material + "\t" + scratch);
	}
}
