package collection.test;

import java.util.ArrayList;

/*
 * ArrayList �������� Vector�� �������
 * Vector�� ����ȭo, ArrayList�� ����ȭx
 */
public class ArrayListTest1 {

	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("��ȣ��");
		list.add("�̼���");
//		list.add("��ȣ��");
		list.add("������");
		list.add("����ö");
		
		list.add(2, "��ȣ��");
		System.out.println(list);
		
		String name = list.remove(2);
		
		System.out.println(name);
		System.out.println(list);
		
		list.set(0, "������");
		System.out.println(list);
		
		System.out.println(list.get(3));
		
		// list�� ����� ��� �߿��� �̸��� �������� ����� ���
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals("������")) System.out.println(list.get(i));
		}
		
	}

}
