package chatting.step2.client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
/*
 * 키보드로 데이터를 읽어들여서 서버로 보낸다.
 * 
 * 다시 서버가 보낸 메시지를 읽어서 메세지를 출력
 * 
 * 입력 - - -
 * 출력 - - -
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
			
			br1 = new BufferedReader(new InputStreamReader(System.in)); // 사용자...키보드 입력
			pw = new PrintWriter(s.getOutputStream(), true);
			
			br2 = new BufferedReader(new InputStreamReader(s.getInputStream())); // 서버...소켓으로 입력
			
			System.out.println("Client Stream Creating...");
			while (true) {
				String line = br1.readLine(); // 키보드로 입력받은 데이터 읽어서
				pw.println(line); // 서버로 전송
				
				//////////Blocking//////////
				
				String serverMsg = br2.readLine();
				System.out.println("서버가 보낸 메세지" + serverMsg);
			}
		} catch (Exception e) {
			System.out.println("서버와의 연결이 끊어졌습니다...");
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
