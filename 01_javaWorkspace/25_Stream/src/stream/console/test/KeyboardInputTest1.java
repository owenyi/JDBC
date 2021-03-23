package stream.console.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * 키보드로 읽어들인 데이터를 콘솔로 출력하는 로직을 작성
 * 1. 스트림 객체 생성
 * 2. 읽어들인다.
 * 3. 콘솔로 출력한다.
 */
public class KeyboardInputTest1 {

	public static void main(String[] args) {
		
		// 1. 입력 스트림만 필요...2개( 기본(node), 보조(filter) )
		System.out.println("1. 스트림 생성...");
		InputStreamReader ir = new InputStreamReader(System.in); // node
		BufferedReader br = new BufferedReader(ir);
		
		// 2. 생성한 스트림의 기능을 사용...읽어들인다.
		try {
			String line = br.readLine();
			while (line.equals("\n")) {
				System.out.println("2. 데이터를 읽어들인다...");
				System.out.println("Reading Data : " + line);
				line = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
//				ir.close(); // 마지막 거 하나만 닫아주면 같이 닫히니까 필요 없음...이렇게 한다고 에러는 나지 않지만
				br.close();
			} catch (IOException e) {
				
			}
		}
		
	}

}
