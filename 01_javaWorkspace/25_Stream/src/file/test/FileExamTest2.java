package file.test;

import java.io.File;
import java.io.IOException;

public class FileExamTest2 {

	public static void main(String[] args) throws IOException {
		
		String dirName = "C:" + File.separator + "dir2" + File.separator + "mydir";
		File file1 = new File(dirName);
		File file2 = new File(dirName, "fileTest.dat");
		
		file1.mkdirs();
		if (file2.createNewFile()) System.out.println("fileTest Creating OK!!");
		
		System.out.println("1. file2 ���� �̸��� ��� : " + file2.getName());
		System.out.println("2. file2 ���� ��θ� ��� : " + file2.getPath());
		System.out.println("3. file2 ���� getParent() ����� ��� : " + file2.getParent());
		
		// 4. �ش� ���α׷��� ����� �� ���丮 �ȿ� �ִ� ������ �����ϴ� ����� ã�Ƽ� ����
//		if (file2.delete()) System.out.println("������ �����Ǿ����ϴ�.");
		file2.deleteOnExit(); // ���α׷� �����
		
	}

}
