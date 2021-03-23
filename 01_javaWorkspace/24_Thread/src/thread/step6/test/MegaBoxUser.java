package thread.step6.test;
/*
 * Ư���� ���� �����ϴ� ������ Ŭ����
 * MegaBox���� �¼��� �����ϴ� ���� �����Ѵ�.
 * reverse()...��� ����� ����
 */
public class MegaBoxUser implements Runnable {
	
	private boolean seat = false; // �¼� ���Ű� �������� true�� �ٲ۴�.
	
	@Override
	public void run() { // run������ InterruptException�� ���� ���� ����...��?
		// �¼��� �����ϴ� ���...
		try {
			reserve();
		} catch (InterruptedException e) {
			
		}
	}
	
	// �¼��� �����ϴ� ���...
	public synchronized void reserve() throws InterruptedException {
		String tName = Thread.currentThread().getName();
		System.out.println(tName + "��, ��ȭ �����Ϸ� ���̽��ϴ�!!");
		if (seat == false) { // �¼��� ����ٸ�...���� ����
			Thread.sleep(1000);
			System.out.println(tName + "��, �¼� ���� ����!!");
			seat = true;
		} else { // �¼��� �̹� ���ŵ�...���� �Ұ���
			System.out.println(tName + "��, �̹� ���޵� �¼��Դϴ�...");
		}
	}
	
	
}
