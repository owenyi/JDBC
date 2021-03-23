package stream.object.step1.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/*
 * 역직렬화 코드
 * 생성된 person.obj 파일의 내용을 읽어와서
 * 콘솔로 정보를 출력...
 */
public class PersonObjectInputTest1 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		File f = new File("C:" + File.separator + "objfile" + File.separator + "person.obj");
		
		// 1.
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
		
		// 2.
		Person p = null;
		try {
			p = (Person) ois.readObject();
			System.out.println(p);
		} finally {
			// 3.
			ois.close();
		}
		
		
		
	}

}
