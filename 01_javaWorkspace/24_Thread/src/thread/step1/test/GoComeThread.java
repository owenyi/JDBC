package thread.step1.test;
/*
 * Thread Ŭ������ ��� �޾Ƽ� Thread�� ������.
 * Thread�� 2���� �����Ѵ�.
 * GoThread, ComeThread
 */
class GoThread extends Thread {
	
	// Thread ����� ������ �Ʒ�ó�� �����
	public void run() { // Thread�� �۵��ϴ� �κ�...run() ��� �ȿ��� �ش� �����尡 �����ϴ� ���� Ȯ���� �� �ִ�.
		int i = 0;
		while (true) {
			System.out.println("Go..." + i);
			i++;
			if (i == 20) break;
		}
	}
			
}

class ComeThread extends Thread {
	
	public void run() {
		int i = 0;
		while (true) {
			System.out.println("Come..." + i);
			i++;
			if (i == 20) break;
		}
	}
			
}

public class GoComeThread {

	public static void main(String[] args) {

		// GoComeThread��� ���μ��� �ȿ��� 2���� �����带 ���۽��Ѻ����� ����
		GoThread t1 = new GoThread();
		ComeThread t2 = new ComeThread();
		
		t1.start();
		t2.start();

	}

}
