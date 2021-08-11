package collection.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/*
 * Map�� �ڽ�...HashMap
 * 1. key-value ������ ������ ����
 * 2. key�� �ߺ�x, value �ߺ�o
 * 3. ����x
 */
public class HashMapTest3 {

	public static void main(String[] args) {

		HashMap<String, Integer> map = new HashMap();
		
		map.put("��ȣ��", 50);
		map.put("�̼���", 45);
		map.put("������", 47);
		map.put("����ö", 40);
		
		System.out.println(map);
		
		Set<String> keys = map.keySet();
		System.out.println(keys);
		
		Collection<Integer> values = map.values();
		System.out.println(values);
		
	}

}
