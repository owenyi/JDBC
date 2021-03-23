package thread.step4.test;

import javax.swing.JOptionPane;

/*
 * 카운팅 작업 - CountThread
 * 숫자입력 작업 - LottoInputThread
 * 
 * 두 개의 쓰레드가 Process 안에서 서로 리소스를 공유하면서 도는 상황을 로직으로 작성
 * 카운팅되는 상황을 서로 공유하도록 로직을 작성
 * 
 * 1. 카운트가 다 끝날 때까지 숫자 입력이 안되면 - 해당 프로그램을 종료
 * 2. 카운트 진행 도중에 숫자가 입력되면 - 더 이상 카운팅을 진행하지 않도록 한다
 * --> 위 두 가지 요구사항이 충족되도록 로직을 완성
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
			System.out.println("ct우선순위 : " + Thread.currentThread().getPriority());
			System.out.println(i);
		}
		
		if (!process.inputCheck) {
			System.out.println("10초가 경과되었습니다...값 입력시간 초과!!!");
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
		String input = JOptionPane.showInputDialog("최종 로또 번호 마지막자리 숫자를 입력하세요.");
		System.out.println("입력한 숫자는 " + input + "입니다.");
		
		process.inputCheck = true;
	}
	
}

public class InputThreadTest3 {
	// 필드...Data...Resource...Thread가 공유
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
