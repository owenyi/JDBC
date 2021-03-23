package collection.test;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 * Map�� �ڽ� Ŭ����...HashMap
 * key-value�� ������ �����ؼ� �����͸� �����ϴ� Ư¡�� ������.
 * key�� �ߺ��� ���ġ �ʰ� value�� �ߺ��� �����ϴ�.
 * ������ ����.
 */
public class HashMapTest4 {

	public static void main(String[] args) {
		
		Map<String, Integer> map = new HashMap<String, Integer>(); // Map�� �ڷ����� �⺻���� ���� �ȵǴ� ������??
		
		map.put("��ȣ��", 90);
		map.put("�̼���", 95);
		map.put("������", 99);
		map.put("����ö", 80);
		
		// 1. Ű�� �޾ƿ´�.
		Set<String> keys = map.keySet();
		// 2. Ű���� ���鼭
		Iterator<String> it = keys.iterator();
		int total = 0;
		while (it.hasNext()) {
			// 3. Ű �� �̰�
			String name = it.next();
			// 4. Ű ���� �ش��ϴ� ���� �̰�
			int score = map.get(name);
			total += score;
		}
		// 5. ���������� ��� ������ �հ� ��� ���� ����Ѵ�.
		System.out.println(total);
		System.out.println(total / map.size());
		
		Collection<Integer> col = map.values(); // 90, 95, 99, 80
		Iterator<Integer> it2 = col.iterator();
		int sum = 0;
		while (it2.hasNext()) {
			int jeomsu = it2.next();
			sum += jeomsu;
		}
		System.out.println(sum);
		System.out.println(sum / map.size());
		
		// �ְ� ����
		System.out.println("�ְ� ���� : " + Collections.max(col));
		// ���� ����
		System.out.println("���� ���� : " + Collections.min(col));
		
		
	}

}
