package collection.test;

import java.util.HashSet;
import java.util.Set;

/*
 * Set의 자식...HashSet
 * 1. 중복 허용 x
 * 2. 순서 x
 */
public class HashSetTest2 {

	public static void main(String[] args) {
		
		HashSet<String> set = new HashSet();
		
		set.add("강호동");
		set.add("이수근");
		set.add("서장훈");
		set.add("강호동");
		set.add("김희철");
		
		System.out.println(set.size());
		System.out.println(set);
		
		set.remove("서장훈");
		
		System.out.println(set);
		
		set.clear();
		System.out.println(set);
		
	}

}
