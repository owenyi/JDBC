package collection.sort.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorTest2 {

	public static void main(String[] args) {

		ArrayList<Person> list = new ArrayList<Person>();
		list.add(new Person("��ȣ��", 48));
		list.add(new Person("�̼���", 45));
		list.add(new Person("������", 38));
		
		// Arrays.sort(�迭) | Collections.sort(����Ʈ, Comparator��ü)
		Collections.sort(list, new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) { // Anonymous Inner Class...�Լ��� ���α׷��� �䳻 https://mommoo.tistory.com/16
				return p1.getAge() - p2.getAge();
			}

			
		});
		
		for (Person p : list) System.out.println(p);
		
	}

}
