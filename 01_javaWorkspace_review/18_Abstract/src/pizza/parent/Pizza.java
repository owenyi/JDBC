package pizza.parent;
/*
 * �߻�(abstract) Ŭ������ �뵵
 * 1. ���� ������ ���ڸ� ������ ���� �������� �۾�(�ʵ�, �޼���)�� �״�� �ڽĵ鿡�� �����ְ�
 * 2. ���� ������ ���ڰ� ������� �� �ִ� �������� �κ�(����)�� �߻� �޼���� �����صд�
 * 
 *     �Ϻ��� �߻� --> �������̽� --> ����ڿ� �ۼ��� ���� Contract
 *     �κ����� �߻� --> �߻� Ŭ���� --> ���������� �ٸ� �κ��� �̿����� �����ش�. --> �ڽ��� �̿��� �ϼ��ϵ��� ����
 */
public abstract class Pizza {
	
	private int price;
	private String storeName;
	
	public Pizza(int price, String storeName) {
		super();
		this.price = price;
		this.storeName = storeName;
	}
	public Pizza() {
		this(15000, "PizzaHut");
	}
	
	public void dough() {
		System.out.println("���� ���װ� �Բ� ���츦 ������ݴϴ�.");
	}
	// topping �ϰ� ����
	public void bake() {
		System.out.println("180�� �µ����� 10�а� �������ϴ�.");
	}
	public void cutting() {
		System.out.println("8�������� �߶��ݴϴ�.");
	}
	public void boxing() {
		System.out.println("�߷��� ���ڸ� ���ڿ� �����մϴ�.");
	}
	
	public abstract void topping();
	
	@Override
	public String toString() {
		return storeName + "������, " + price + "��";
	}

}
