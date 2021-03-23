package collection.test;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 * Map의 자식 클래스...HashMap
 * key-value를 쌍으로 연결해서 데이터를 저장하는 특징을 가진다.
 * key는 중복을 허용치 않고 value는 중복이 가능하다.
 * 순서는 없다.
 */
public class HashMapTest4 {

	public static void main(String[] args) {
		
		Map<String, Integer> map = new HashMap<String, Integer>(); // Map의 자료형에 기본형이 들어가면 안되는 이유는??
		
		map.put("강호동", 90);
		map.put("이수근", 95);
		map.put("서장훈", 99);
		map.put("김희철", 80);
		
		// 1. 키만 받아온다.
		Set<String> keys = map.keySet();
		// 2. 키들을 돌면서
		Iterator<String> it = keys.iterator();
		int total = 0;
		while (it.hasNext()) {
			// 3. 키 값 뽑고
			String name = it.next();
			// 4. 키 갑셍 해당하는 점수 뽑고
			int score = map.get(name);
			total += score;
		}
		// 5. 최종적으로 모든 성적의 합과 평균 값을 출력한다.
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
		
		// 최고 성적
		System.out.println("최고 성적 : " + Collections.max(col));
		// 최저 성적
		System.out.println("최저 성적 : " + Collections.min(col));
		
		
	}

}
