package fly.parent;
// ������ �Ͱ� ���õ� �߻� ����� ��� ���� �������̽�
/*
 * �������̽��� �������
 * 1. static final ���
 * 2. public abstract �޼���
 */
public interface Flyer {
	// �ʵ尡 ����...����� ����
	public static final int SIZE = 100;
	public abstract void fly(); // abstract method...����θ� �ְ� �����ΰ� ���� �޼���
	void take_off(); // �޼��� ���� Ÿ�� �տ� ������ public abstract�� �����Ǿ� ����
	void land();
}
