package poly.test;
/*
 * Singleton Pattern : �ϳ��� Ŭ�����κ��� �ϳ��� ��ü�� �����ϵ��� �ϴ� ����
 *    1. Ŭ���� �ȿ��� �ϴ� ��ü �ϳ��� ����
 *        private static ��ü�� �����Ѵ�.
 *    2. �ٸ� ������(�ٸ� Ŭ����)�� ��ü ������ ���� ���ϵ��� ���Ƶд�
 *        private ������( ) { }
 *    3. ����� ���� �ϳ��� ��ü�� ��𼭵��� ������ �� �� �ֵ��� public static �޼��带 �����д�.
 */
class EncoreCompany{
	private String companyName;
	
	// 1. static private���� ��ü �ϳ� ����...��ü�� �ϳ�
	private static EncoreCompany encore = new EncoreCompany();
	
	// 2. private�� ������ ����...�ٸ� �������� ��ä ���� ����
	private EncoreCompany() {
		companyName = "Encore";
		System.out.println("Company Name ..." + companyName);
	}
	
	// 3. public �޼��� ����...����� ���� ��ü�� �ٸ� ������ ������ �� �� �ֵ���
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
