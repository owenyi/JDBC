package collection.test;

import java.util.ArrayList;
import java.util.List;

/*
 * List
 * 1. ������ �����鼭(���������� index�� �����ȴ�) ��ü�� �����ϴ� ���
 * 2. �ߺ��� ���
 * 
 * �������� Vector�� ������ ���� ArrayList�� �����
 * Vector�� ����ȭo, ArrayList�� ����ȭx
 * Vector�� �� ���� �ϳ��� ������ �۾�
 * ArrayList�� ���ÿ� ���� ������ �۾�
 * ���� �¼� ���� ����
 * ����ȭ ������ Vector�� �ӵ��� ������ ������� ����
 * ArrayList�� �����ڰ� ���� ����ȭ ó�� �ڵ�� �ۼ�
 * HashTable(����)�� HashMap(�񵿱�)�� ��������
 */
public class ArrayListTest3 {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		list.add("��ȣ��");
		list.add("�̼���");
		list.add("��ȣ��");
		list.add("������");
		list.add("����ö");

		System.out.println(list);
		// 3��° ��ü�� ����
		String name = list.remove(2);
		// ������ �����͸� ���
		System.out.println(name);
		// ù��° �����͸� �������� ����
		list.set(0, "������");
		// ��� ���� ���
		System.out.println(list);
		
		// list�� ����� ����� �߿��� �̸��� �������� ����� �޾ƿ´�.
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals("������")) System.out.println(list.get(i));
		}
		
	}

}
