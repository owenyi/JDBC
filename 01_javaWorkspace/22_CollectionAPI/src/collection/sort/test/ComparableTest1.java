package collection.sort.test;

import java.util.ArrayList;
import java.util.Collections;

/*
 * 배열은 이게 가능 --> Arrays.sort(Xxx[])...sort()는 comparable에 의해서 정렬된 것이다.
 * 리스트는 이게 불가능 --> Arrays.sort(arraylist) 는 안돌아간다.
 * 리스트는 Collections.sort()를 하면 된다. implements Comparable하고 나서
 * 이번 에제에서는 Comparable을 사용해서 ArrayList안에 들어있는 객체들의 특정한 값에 의해서 정렬해보겠다.
 * 
 * 1. Comparable을 직접 상속받아서 구현하는 방법...compareTo를 정렬하고픈 필드(나이순, 이름순)에 맞춰서 구현
 * 2. Comparator를 sort 함수 안에서 직접 구현하는 방법
 */
class Person implements Comparable<Person>{
	private String name;
	private int age;
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Person() {
		super();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	@Override
	public int compareTo(Person p) { // 나이순으로 정렬
		return -(new Integer(age).compareTo(p.getAge()));
//		return new Integer(age).compareTo(p.getAge());
	}
//	@Override
//	public int compareTo(Person p) { // 이름순으로 정렬
//		return -name.compareTo(p.getName()); // 내림차순
////		return name.compareTo(p.getName());
//	}
}
public class ComparableTest1 {

	public static void main(String[] args) {
		
		ArrayList<Person> list = new ArrayList<Person>();
		list.add(new Person("강호동", 48));
		list.add(new Person("이수근", 45));
		list.add(new Person("서장훈", 38));
		
		Collections.sort(list);
		System.out.println(list);
		
	}

}
