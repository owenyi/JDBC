package test;

public class OperatorTest1 {

	public static void main(String[] args) {
		
		// �ı����� �޸𸮿� �ø��� -> ��� : �ּҰ� �Ҵ�
		Operator o1 = new Operator(); // 100
		Operator o2 = new Operator(); // 200
		//
		System.out.println("\n==");
		// ==
		System.out.println(o1); // test.Operator@4926097b --> at(@) 4926097b(�ּҰ�)
		System.out.println(o2);
		System.out.println(o1 == o2);
		o1 = o2;
		//
		System.out.println("===true�� �������� �ּҰ��� ���������ϴ� �������� �Ѵ�.===");
		//
		System.out.println(o1);
		System.out.println(o2);
		System.out.println(o1 == o2);
		
		
		int i = 5; // ���� ����, �޼ҵ� ��� �ȿ� �ִ�.
		int j = 3; // ���� ������ ����� ���� �ݵ�� �ʱ�ȭ�ؾ���, �ֳĸ� �⺻ ���� ����.
		
//		int k;
//		System.out.println(k); --> error
		
		
		System.out.println("\n%");
		// %
		System.out.println("������ % :: " + i % j);

		
		System.out.println("\n!=");
		// !=
		System.out.println(i == j);
		System.out.println(i != j);

		
		System.out.println("\n==, --");
		// ++(1�� ����), --(1�� ����)
		int k = 10;
		System.out.println(k++);
		System.out.println(k);
		
		int m = 10;
		System.out.println(++m);
		System.out.println(m);
		
		System.out.println("\n�� ������");
		// �� ������
		System.out.println(o1.test1() | o1.test2()); // ture or ture == true
		System.out.println(o1.test1() & o1.test2()); // true and false == false
		
		
		System.out.println("\nShort Circuit");
		// Short Circuit
		System.out.println(o1.test1() || o1.test2()); // ture or ture == true
		System.out.println(o1.test1() && o1.test2()); // true and false == false
		
	}

}

class Operator { // �� �տ� public ���̸� error��, ���ϸ� OperatorTest1.java�̱� ������ class OperatorTest1 �տ��� public�� ���� �� ����
	public boolean test1() {
		System.out.println("test1() Calling...");
		return true;
	}
	
	public boolean test2() {
		System.out.println("test2() Calling...");		
		return false;
	}
}