package fly.parent;

// ����, �����ϴ��� �߻� ����� ��� ���� �������̽�
/*
 * �������̽��� ���� ���
 * 1. static final ���
 * 2. public abstract �޼���
 */
public interface Flyer {
	// �ʵ尡 ����...����� ����
	public static final int SIZE = 100;
	// abstract method...����θ� �ְ� �����ΰ� ���� �޼���
	public abstract void fly();
	// public abstract�� ������ �� �ִ�.
	void land();
}
