/*
 * ==== static�� Ű���� ���� ====
 * 1. ��ü ���� ���� ���� �޸𸮿� �ö󰣴�.
 * 2. ��ü ���� ���� ������...Class File Loader ��������...�� �� �޸𸮿� �ö󰣴�.
 *    JVM(STACK | HEAP(new Ű����� ������ ��ü��) | ...Class Area(static�� �������� ���))
 * 3. static�� ������ �ʵ�� ������ ��ü�鿡�� ���� �����Ѵ�.!!!
 * 4. static�� static���� ���Ѵ�.
 * 5. static ��� �ȿ����� this ��� ���Ѵ�.
 * 6. static�� final�� ������ ���� �Բ� ���ȴ�.
 *    ex) ����� ����...static final int BASIC_SALARY = 1000;
 * 7. static initialization block
 * 8. �̱���
 */
package exam.test;

class Member{
	// �ʵ� ������ static ������ ����(local level�δ� ����� �� ����.)
	static String name = "ȫ�浿";
	static int age = 22;
	
	int count = 1; // �̰� �ʵ�
	
	public static void getMember() { // static block
		System.out.println("��/��/��/��/ " + name);
	}
	
	public void getMember2() { // non static block
		System.out.println("��/��/��/��/ " + count);
	}
}

public class StaticExamTest1 {


	public static void main(String[] args) {
		// static�� ������ ����� �ٷ� �����ؼ� ����� �� �ִ�...Class�̸�.static�޼���
		Member.getMember();
		
		//
		Member m = new Member();
		m.getMember();
	}

}
