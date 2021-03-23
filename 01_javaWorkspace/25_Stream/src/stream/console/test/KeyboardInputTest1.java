package stream.console.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * Ű����� �о���� �����͸� �ַܼ� ����ϴ� ������ �ۼ�
 * 1. ��Ʈ�� ��ü ����
 * 2. �о���δ�.
 * 3. �ַܼ� ����Ѵ�.
 */
public class KeyboardInputTest1 {

	public static void main(String[] args) {
		
		// 1. �Է� ��Ʈ���� �ʿ�...2��( �⺻(node), ����(filter) )
		System.out.println("1. ��Ʈ�� ����...");
		InputStreamReader ir = new InputStreamReader(System.in); // node
		BufferedReader br = new BufferedReader(ir);
		
		// 2. ������ ��Ʈ���� ����� ���...�о���δ�.
		try {
			String line = br.readLine();
			while (line.equals("\n")) {
				System.out.println("2. �����͸� �о���δ�...");
				System.out.println("Reading Data : " + line);
				line = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
//				ir.close(); // ������ �� �ϳ��� �ݾ��ָ� ���� �����ϱ� �ʿ� ����...�̷��� �Ѵٰ� ������ ���� ������
				br.close();
			} catch (IOException e) {
				
			}
		}
		
	}

}
