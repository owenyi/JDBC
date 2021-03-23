package chatting.step3.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * Socket ��ſ��� Ŭ���̾�Ʈ�� ������ ��� �ִ� ���μ���
 * ������ �����ؼ� ��û�� �ϰ����ϴ� ���������� ������ �õ�
 * �� �� �������� ������ �ִ� ��Ʈ�� ������ ��Ʈ�� �̿��ؾ� ������ �� �� �ִ�.
 * 
 * ��Ʈ�� �ڵ�
 * Ű����� �о���� �����͸� ������ ������ ������ �ۼ�
 */
public class ChatClient {
	Socket s;
	BufferedReader br; // ��ü������ ����
	PrintWriter pw; // �������κ��� ���� �޾Ƽ�...
	
	public void net() {
		try {
			s = new Socket("127.0.0.1", 60000);
			System.out.println("Socket Creating...");
			
			br = new BufferedReader(new InputStreamReader(System.in));
			pw = new PrintWriter(s.getOutputStream(), true);
			
			ClientThread ct = new ClientThread(s);
			ct.start();
			
			System.out.println("Client Stream Creating...");
			while(true) {
				String line = br.readLine();//Ű����� �Է¹��� ����Ÿ �о
				pw.println(line);//������ ������
			}
		} catch (UnknownHostException e) {
			System.out.println("�������� ���ῡ �����߽��ϴ�...");
		} catch (IOException e) {
			
		}
	}
	
	public static void main(String[] args) {
		
		ChatClient chatClient = new ChatClient();
		chatClient.net();

	}

}

class ClientThread extends Thread {
	
	Socket s;
	BufferedReader br1;
	
	
	ClientThread(Socket s) {
		this.s = s;
	}
	
	public void run() {
		try {
			br1 = new BufferedReader(new InputStreamReader(s.getInputStream()));
			while (true) {
				String str = br1.readLine();
				System.out.println("���� �޼��� " + str);
			}
		} catch (IOException e) {
			
		}
	}
	
}
