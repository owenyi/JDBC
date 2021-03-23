package exception.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader;

class FileReading {
	public void readFile(String filename) {
		try {
			FileReader fr = new FileReader(filename);
			System.out.println("...new FileReader()...filename...");
		} catch (FileNotFoundException e) {
			/*
			 * 1. ����ΰų�
			 * 2. printStackTrace(), getMessage()�� ���µ�
			 * printStackTrace()...������ �߻��� ������ �����ؼ� ������ ��� --> �������ϴ� ����
			 *   -> ������ ���� printStacTrace��
			 *   -> �����ÿ��� ����ΰų� getMessage()�� �����
			 */
//			 e.printStackTrace();
//			 System.out.println(e.getMessage());
		}
		System.out.println("FileReader Creating...");
	}
}

public class CompileExceptionTest1 {

	public static void main(String[] args) {
		
		FileReading f = new FileReading();
		String path = "C:\\encore_lss\\util\\poem.txt";
		f.readFile(path);
		System.out.println("the end...");
		
	}

}
