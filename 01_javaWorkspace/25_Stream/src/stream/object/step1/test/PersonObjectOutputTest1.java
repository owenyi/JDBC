package stream.object.step1.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
 * ================ Serialization(����ȭ) : Data Unpack ===================
 * Person ��ü�� ������(�ʵ� ��) �ٸ� ��(Sink : Person.obj)���� ������ ������ �ۼ�
 * 1. Stream ��ü�� ���� - - - ObjectOutputStream | FileOutputStream
 * 2. ������...�Ѹ���...����Ѵ� - - - ObjectOutputStream�� ����� ���...writeObject
 */
public class PersonObjectOutputTest1 {

	public static void main(String[] args) throws IOException {

		File f = new File("C:" + File.separator + "objfile" + File.separator + "person.obj");
		f.getParentFile().mkdirs(); // mkdirs()����
		// 1.
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
		
		// 2.
		Person p = new Person("�迬��", 30, "2233", "���ǵ�");
		oos.writeObject(p); // sink������ �������� ����...
		
		// 3.
		oos.close();
		System.out.println("person.obj ������ ����...Ȯ��");
		System.out.println("������ ��Ȯ�ϰ� ��µǾ�����");
		
	}

}
