package fly.child;

import fly.parent.Flyer;

/*
 * �������̽��� �θ�� �� �ڽ� Ŭ������
 * �θ��� �߻�޼��带 ��� �����ϵ��� ����ȴ�.
 */
public class Bird implements Flyer{ // expends ��� implements

	@Override
	public void fly() {
		System.out.println("Bird...fly...");
	}

	@Override
	public void take_off() {
		System.out.println("Bird..take_off...");
	}

	@Override
	public void land() {
		System.out.println("Bird...land...");
	} 
	
	// �ڽĸ��� �޼���...
	public String layEggs() {
		return "���� ���� ���";
	}
}
