package stream.data.test;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
/*
 * scores.dat������ ������ readInt()�� �о�鿩��
 * ������ ������ ����ϰ�
 * ��� ������ ������ ���ϴ� ������ �ۼ�...
 * EOFException�� ������ ������ ������ �ʰ� ���� �������� ������ ������
 * main �޼ҵ� ����ο��� throws�� ������ �� ����.
 * ----------------------------------------------------
 * main �޼ҵ� ����ο��� throws�� ���ܸ� ������
 * main�� ȣ���� ��(JVM)���� ���ܸ� ó���� �� �ִ� ����
 * Compile Exception �迭�� �����ߴ�.
 */
public class DataOutputStreamTest4{

	public static void main(String[] args){

		int sum = 0;
		int score = 0;
		
		DataInputStream dis = null;
		try {
			// 1. ��Ʈ�� ����
			dis = new DataInputStream(new FileInputStream("src\\scores.dat"));
			System.out.println("Stream Creating...");
			
			while (true) {
				score = dis.readInt();
				System.out.println(score);
				sum += score;
			}
		} catch(EOFException e) {
			// ������ ���� �������� ����� �Ѿ�� ���̴�.
			System.out.println("��� ������ ���� " + sum + "��!!");
		} catch(IOException e) {
			
		} finally {
			try {
				dis.close();
			} catch (IOException e) {
				
			}
		}
		
	}

}
