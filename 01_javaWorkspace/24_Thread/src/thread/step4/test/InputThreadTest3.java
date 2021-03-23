package thread.step4.test;

import javax.swing.JOptionPane;

/*
 * ī���� �۾� - CountThread
 * �����Է� �۾� - LottoInputThread
 * 
 * �� ���� �����尡 Process �ȿ��� ���� ���ҽ��� �����ϸ鼭 ���� ��Ȳ�� �������� �ۼ�
 * ī���õǴ� ��Ȳ�� ���� �����ϵ��� ������ �ۼ�
 * 
 * 1. ī��Ʈ�� �� ���� ������ ���� �Է��� �ȵǸ� - �ش� ���α׷��� ����
 * 2. ī��Ʈ ���� ���߿� ���ڰ� �ԷµǸ� - �� �̻� ī������ �������� �ʵ��� �Ѵ�
 * --> �� �� ���� �䱸������ �����ǵ��� ������ �ϼ�
 */
class CountThread implements Runnable {
	
	InputThreadTest3 process;

	public CountThread(InputThreadTest3 process) {
		super();
		this.process = process;
	}

	@Override
	public void run() {
		for (int i = 10; i >= 1; i--) {
			if (process.inputCheck) break;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

			}
			System.out.println("ct�켱���� : " + Thread.currentThread().getPriority());
			System.out.println(i);
		}
		
		if (!process.inputCheck) {
			System.out.println("10�ʰ� ����Ǿ����ϴ�...�� �Է½ð� �ʰ�!!!");
			System.exit(0);
		}
	}

}

class LottoInputThread implements Runnable {
	
	InputThreadTest3 process;
	
	public LottoInputThread(InputThreadTest3 process) {
		super();
		this.process = process;
	}

	@Override
	public void run() {
		String input = JOptionPane.showInputDialog("���� �ζ� ��ȣ �������ڸ� ���ڸ� �Է��ϼ���.");
		System.out.println("�Է��� ���ڴ� " + input + "�Դϴ�.");
		
		process.inputCheck = true;
	}
	
}

public class InputThreadTest3 {
	// �ʵ�...Data...Resource...Thread�� ����
	boolean inputCheck = false;
	
	public static void main(String[] args) {
		InputThreadTest3 process = new InputThreadTest3();
		CountThread ct = new CountThread(process);
		LottoInputThread lt = new LottoInputThread(process);
		
		Thread t1 = new Thread(ct);
		Thread t2 = new Thread(lt);
		
		t1.start();
		t2.start();

	}

}
