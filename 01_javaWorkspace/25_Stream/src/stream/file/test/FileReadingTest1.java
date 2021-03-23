package stream.file.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReadingTest1 {

	public static void main(String[] args) throws IOException {
		
		// 1. ��Ʈ������ -- �Է� 2��(FileReader, BufferedReader)
		BufferedReader br = new BufferedReader(new FileReader("src\\hope.txt"));
		try {
			// 2. while������ ������ ������ �а�
			String line = null;
			while ((line = br.readLine()) != null) {
				// 3. �ַܼ� ����ϱ�...
				System.out.println(line);
			}
		} finally {
			br.close();
		}
		
	}

}
