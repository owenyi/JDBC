package gui.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/*
 * 여러 명의 클라이언트 접속을 받아서
 * 문자 기반의 메세지를 주고 받을 수 있는
 * 서버측 로직을 작성
 * 
 * ChatServer - - - - Process
 *   |-----> ServerSocket, ArrayList, Socket
 *           braodcast()
 *  
 * ChatTread - - - - Thread
 *   |-----> Socket, BufferedReader, PrintWriter
 */
public class ChatServer {
	
	ServerSocket server;
	Socket s;
	ArrayList<ChatThread> list;
	
	public ChatServer() {
		list = new ArrayList<ChatThread>();
	}
	
	public void broadcast(String message) {
		for (ChatThread t : list) {
			t.sendMessage(message);
		}
	}
	
	public void net() {
		try {
			server = new ServerSocket(60000);
			System.out.println("Server Ready...");
			
			while (true) { //윙윙윙...waiting for...
				s = server.accept();
				ChatThread ct = new ChatThread(s, this);
				list.add(ct);
				ct.start(); // ...작업이 병렬적으로 진행된다...
			}
		} catch (IOException e) {
			
		} finally {
			
		}
	}
	
	public static void main(String[] args) {

		ChatServer process = new ChatServer();
		process.net();
		
	}

}

// 서버와 연결된 클라이언트와 메세지를 주고 받는 일만 전담하는 쓰레드...작업쓰레드
class ChatThread extends Thread {
	Socket s;
	BufferedReader br;
	PrintWriter pw;
	ChatServer chatServer;
	
	ChatThread(Socket s, ChatServer chatServer) {
		this.s = s;
		this.chatServer = chatServer;
		
		System.out.println(s.getInetAddress() + "님이 접속하셨습니다.");
		chatServer.broadcast(s.getInetAddress() + "님이 채팅방에 들어오셨습니다.");
	}
	
	public void sendMessage(String str) {
		pw.println(str);
	}
	
	public void run() {
		try {
			// 원래는 생성자에서 스트림 생성해야 함
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			pw = new PrintWriter(s.getOutputStream(), true);
			
			while (true) {
				String line = br.readLine();
				chatServer.broadcast(line);
			}
		} catch (IOException e) {
			// 연결이 끊어지면 로직이 이곳으로...
			System.out.println(s.getInetAddress() + "님이 접속을 끊으셨습니다.");
			chatServer.broadcast(s.getInetAddress() + "님이 채팅방에 나가셨습니다.");
			//
			chatServer.list.remove(this);
		}
	}
	
}
