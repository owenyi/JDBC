package exam.test;
/*
 * ===== static�� Ű���� ���� =====
 * 1. ��ü ���� ���� ���� �޸𸮿� �ö󰣴�.
 * 2. ��ü ���� ���� ������...Class File Loader ��������...�� �� �޸𸮿� �ö󰣴�.
 * 3. static�� ������ �ʵ�� ������ ��ü�鿡�� ���� �����Ѵ�!
 * 4. static�� static���� ���Ѵ�.
 * 5. static��� �ȿ����� this ��� ���Ѵ�.
 * 6. static�� final�� ������ ���� �Բ� ���ȴ�.
 *     ex) ����� ����...static final int BASIC_SALARY = 1000;
 * 7. static initialization block
 * 8. �̱���
 */
class Member {
	static String name1 = "ö��";
	String name2 = "����";
	
	public static void getMember1() {
		System.out.println("�ȳ�, �� " + name1 + "��");
//		System.out.println("�ȳ�, �� " + name2 + "��"); �� �ȴ�.
	}
	public void getMember2() {
		System.out.println("�ȳ�, �� " + name2 + "��");
//		System.out.println("�ȳ�, �� " + name1 + "��"); �ȴ�.
	}
}

public class StaticExamTest1 {

	public static void main(String[] args) {
		// static�� ������ �޼ҵ�� �ٷ� �����ؼ� ����� �� �ִ�...Class�̸�.static�޼ҵ�
		Member.getMember1();

		// getMember2()�� ��ü ���� ���Ŀ� ����� �� �ִ�.
		Member m = new Member();
		m.getMember2();
	}

}