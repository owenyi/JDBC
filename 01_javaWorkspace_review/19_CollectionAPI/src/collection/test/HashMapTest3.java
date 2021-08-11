package collection.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/*
 * Map의 자식...HashMap
 * 1. key-value 쌍으로 데이터 저장
 * 2. key는 중복x, value 중복o
 * 3. 순서x
 */
public class HashMapTest3 {

	public static void main(String[] args) {

		HashMap<String, Integer> map = new HashMap();
		
		map.put("강호동", 50);
		map.put("이수근", 45);
		map.put("서장훈", 47);
		map.put("김희철", 40);
		
		System.out.println(map);
		
		Set<String> keys = map.keySet();
		System.out.println(keys);
		
		Collection<Integer> values = map.values();
		System.out.println(values);
		
	}

}
