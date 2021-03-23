package poly.test;
/*
 * Singleton Pattern : 하나의 클래스로부터 하나의 객체만 생성하도록 하는 패턴
 *    1. 클래스 안에서 일단 객체 하나는 생성
 *        private static 객체를 생성한다.
 *    2. 다른 곳에서(다른 클ㄹ스)는 객체 생성을 하지 못하도록 막아둔다
 *        private 생성자( ) { }
 *    3. 만들어 놓은 하나의 객체를 어디서든지 가져다 쓸 수 있도록 public static 메서드를 만들어둔다.
 */
class EncoreCompany{
	private String companyName;
	
	// 1. static private으로 객체 하나 생성...객체는 하나
	private static EncoreCompany encore = new EncoreCompany();
	
	// 2. private로 생성자 생성...다른 곳에서는 객채 생성 못함
	private EncoreCompany() {
		companyName = "Encore";
		System.out.println("Company Name ..." + companyName);
	}
	
	// 3. public 메서드 생성...만들어 놓은 객체를 다른 곳에서 가져다 쓸 수 있도록
	public static EncoreCompany getCompany() {
		return encore;
	}
}

public class SingletonTest {

	public static void main(String[] args) {
		EncoreCompany encore1 = EncoreCompany.getCompany();
		EncoreCompany encore2 = EncoreCompany.getCompany();
		EncoreCompany encore3 = EncoreCompany.getCompany();
		
		System.out.println(encore1); // poly.test.EncoreCompany@4926097b
		System.out.println(encore2); // poly.test.EncoreCompany@4926097b
		System.out.println(encore3); // poly.test.EncoreCompany@4926097b
	}

}
