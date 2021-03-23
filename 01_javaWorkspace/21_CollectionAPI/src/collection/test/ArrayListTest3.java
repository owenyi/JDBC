package collection.test;

import java.util.ArrayList;
import java.util.List;

/*
 * List
 * 1. 순서를 가지면서(내부적으로 index로 관리된다) 객체를 저장하는 방식
 * 2. 중복은 허용
 * 
 * 이전에는 Vector를 썼으나 요즘엔 ArrayList를 사용함
 * Vector는 동기화o, ArrayList는 동기화x
 * Vector는 한 번에 하나의 스레드 작업
 * ArrayList는 동시에 여러 스레드 작업
 * 극장 좌석 예매 예시
 * 동기화 때문에 Vector의 속도가 느려서 사용하지 않음
 * ArrayList는 개발자가 직접 동기화 처리 코드로 작성
 * HashTable(동기)와 HashMap(비동기)도 마찬가지
 */
public class ArrayListTest3 {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		list.add("강호동");
		list.add("이수근");
		list.add("강호동");
		list.add("서장훈");
		list.add("김희철");

		System.out.println(list);
		// 3번째 객체를 삭제
		String name = list.remove(2);
		// 삭제된 데이터를 출력
		System.out.println(name);
		// 첫번째 데이터를 아이유로 수정
		list.set(0, "아이유");
		// 모든 정보 출력
		System.out.println(list);
		
		// list에 저장된 멤버들 중에서 이름이 서장훈인 멤버를 받아온다.
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals("서장훈")) System.out.println(list.get(i));
		}
		
	}

}
