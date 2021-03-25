package broker.three.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * server side의 process class...main...
 * 서버 소켓을 가지면서 클라이언트의 접속을 기다린다...
 * 클라이언트가 접속을 하면 accept()로 맞아들여서 소켓을 리턴...이걸 Jury가 가져간다...
 * Jury 쓰레드 Start
 * 
 *   Thread
 *   1) 데몬 쓰레드...main
 *   2) 작업 쓰레드...Jury Thread
 *   3) 리스너 쓰레드...ProtocolHandler
 *     무한루핑 돌면서 계속적으로 클라이언트의 접속을 기다린다.
 *     특정한 기능을 하는 것은 아니다.
 */
public class ProtocolHandlerMy extends Thread {
	
	ServerSocket server;
	Socket s;
	JuryThread jury;
	Database db;
	public static final int MIDDLE_PORT = 60000;
	
	public ProtocolHandlerMy(String serverIP) {
		
		try {
			server = new ServerSocket(MIDDLE_PORT);
			db = new Database(serverIP);
		} catch (Exception e) {
			
		}
		System.out.println("Start Protocol Handler...service port..." + MIDDLE_PORT);
	}
	
	public void run() {
		while (true) {
			try {
				s = server.accept();
				JuryThread jt = new JuryThread(s, db);
				jt.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		ProtocolHandlerMy handler = new ProtocolHandlerMy("127.0.0.1");
		handler.start();
	}
}
