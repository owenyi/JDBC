package collection.test2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import collection.vo.Customer;

public class CustomerMapTest2 {

	public static void main(String[] args) {

		HashMap<String, Customer> map = new HashMap<String, Customer>();
		
		map.put("111", new Customer("KANG", "��ȣ��", 48));
		map.put("222", new Customer("LEE", "�̼���", 44));
		map.put("333", new Customer("SEO", "������", 42));
		map.put("111", new Customer("LEE", "�̻��", 27));
		map.put("444", new Customer("KIM", "����ö", 35));
		
		// 1. KEY ���� 222�� ����� ������ ���
		System.out.println(map.get("222"));
		
		// 2. id�� LEE�� ����� ã�Ƽ� �� ����� �̸��� ���
		Collection<Customer> col = map.values();
		Iterator<Customer> it = col.iterator();
		while (it.hasNext()) {
			Customer c = it.next();
			if (c.getId().equals("LEE"))
				System.out.println(c.getName());
		}
		// key��
		Set<String> set = map.keySet();
		Iterator<String> itSet = set.iterator();
		while (itSet.hasNext()) {
			Customer c = map.get(itSet.next());
			if (c.getId().equals("LEE"))
				System.out.println(c.getName());
		}
		
		// 3. MAP�� ����� �������� ��� KEY ������ ���
		System.out.println(map.keySet());
		
		// 4. MAP�� ����� ����� ������ ���հ� ��� ������ ���		
		Collection<Customer> col2 = map.values();
		Iterator<Customer> it2 = col.iterator();
		int totalAge = 0;
		while (it2.hasNext()) {
			totalAge += it2.next().getAge();
		}
		System.out.println(totalAge);
		System.out.println(totalAge / map.size());	
		// key��
		Set<String> set2 = map.keySet();
		Iterator<String> itSet2 = set2.iterator();
		int totalAge2 = 0;
		while (itSet2.hasNext()) {
			totalAge2 += map.get(itSet2.next()).getAge();
		}
		System.out.println(totalAge2);
		System.out.println(totalAge2 / map.size());	
		
	}

}
