package thread.step6.test;

public class MegaBoxProcess {

	public static void main(String[] args) {
		
		MegaBoxUser user = new MegaBoxUser();
		Thread user1 = new Thread(user, "����");
		Thread user2 = new Thread(user, "�̳���");
		
		user1.start();
		user2.start();		
		
	}

}