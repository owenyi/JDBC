package thread.step3.test;

import java.awt.Toolkit;

/*
 * Thread
 * 1) main 쓰레드...데몬 쓰레드...O
 * 2) 작업쓰레드...X
 *   -> 작업쓰레드를 만들지 않기 때문에 작업쓰레드를 어떤 경우에 쓰는지 알 수 있는 코드를 짤것임
 *   
 * 해당 코드에서는 별도의 쓰레드 클래스를 작성하지 않을 것이다.
 * main 쓰레드(Daemon Thread)만 실행되는 Process 코드를 작성할 것이다.
 * --> Single Thread...
 * 
 * Beep(경고음) 발생 + 경고음을 콘솔창으로 출력
 */
public class BeepPrintTest1 {

	public static void main(String[] args) {
		
		Toolkit	tool = Toolkit.getDefaultToolkit();
		
		// 경고음이 5번 울리는 작업...
		for (int i = 0; i < 5; i++) {
			tool.beep();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
			}
		}
		
		// 띵띵띵띵띵
		for (int i = 0; i < 5; i++) {
			System.out.println("띵~~~");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
			}
		}
		
	}

}
