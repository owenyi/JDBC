package chatting.step2.client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
/*
 * Ű����� �����͸� �о�鿩�� ������ ������.
 * 
 * �ٽ� ������ ���� �޽����� �о �޼����� ���
 * 
 * �Է� - - -
 * ��� - - -
 */
import java.net.Socket;

public class ChatClient {
	
	Socket s;
	BufferedReader br1, br2;
	PrintWriter pw;
	
	public void net() {
		try {
			s = new Socket("127.0.0.1", 5500);
			System.out.println("Socket Creating...");
			
			br1 = new BufferedReader(new InputStreamReader(System.in)); // �����...Ű���� �Է�
			pw = new PrintWriter(s.getOutputStream(), true);
			
			br2 = new BufferedReader(new InputStreamReader(s.getInputStream())); // ����...�������� �Է�
			
			System.out.println("Client Stream Creating...");
			while (true) {
				String line = br1.readLine(); // Ű����� �Է¹��� ������ �о
				pw.println(line); // ������ ����
				
				//////////Blocking//////////
				
				String serverMsg = br2.readLine();
				System.out.println("������ ���� �޼���" + serverMsg);
			}
		} catch (Exception e) {
			System.out.println("�������� ������ ���������ϴ�...");
		} finally {
			try {
				br1.close();
				pw.close();
				
				br2.close();
			} catch (IOException e) {
				
			}
		}
	}

	public static void main(String[] args) {

		ChatClient cc = new ChatClient();
		cc.net();
		
	}

}
