package collection.test;

import java.util.ArrayList;

/*
 * ArrayList 이전에는 Vector를 사용했음
 * Vector는 동기화o, ArrayList는 동기화x
 */
public class ArrayListTest1 {

	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("강호동");
		list.add("이수근");
//		list.add("강호동");
		list.add("서장훈");
		list.add("김희철");
		
		list.add(2, "강호동");
		System.out.println(list);
		
		String name = list.remove(2);
		
		System.out.println(name);
		System.out.println(list);
		
		list.set(0, "아이유");
		System.out.println(list);
		
		System.out.println(list.get(3));
		
		// list에 저장된 멤버 중에서 이름이 서장훈인 멤버를 출력
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals("서장훈")) System.out.println(list.get(i));
		}
		
	}

}
