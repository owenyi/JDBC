package file.test;

import java.io.File;

/*
 * ���� = ���丮���� + �����̸�
 * �ش� Ŭ����������
 * ������ �پ��� ������� ����
 * �Լ��� ����� �ڼ��� �˾ƺ��� ������ �ۼ�
 * getParentFile() : File, getParent() : String
 * mkdir(), mkdirs() 
 */
public class FileExamTest1 {

	public static void main(String[] args) {
		
		File dir = new File("C:\\filetest");
		File dir2 = new File("C:\\filetest1\\step1\\code");
		File dir3 = new File("C:\\filetest1\\exam\\data.dat"); // �ӽ��� ���ϰ� ���丮 ������ �ȵȴ�
		
		System.out.println("������ �����Ǿ�����?");
		
//		dir.mkdir(); // mkdirs()�� �ϳ� ����� �͵� ������
		dir.mkdirs();
		dir2.mkdirs();
		dir3.getParentFile().mkdirs();
		
		
	}

}
