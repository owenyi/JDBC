package gui.client;
/*
 * TextField에 입력받은 내용을 TextArea에 붙이는 로직을 작성
 * TextField에 입력이 끝나면 다시 초기화..
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventHandler implements ActionListener {
	
	ChattingService service;
	String msg; //변경..
	
	EventHandler(ChattingService service){
		this.service=  service;
	}	
	@Override
	public void actionPerformed(ActionEvent e) {
		//
		msg = service.tf.getText(); // 엔터 치면 채팅창에 쳐지고 메세지는 지워지게
		service.tf.requestFocus();
		//
		service.pw.println("[" + service.nickName + "]" + msg);
		service.tf.setText("");
		
		service.threadGo();
	}
}




















