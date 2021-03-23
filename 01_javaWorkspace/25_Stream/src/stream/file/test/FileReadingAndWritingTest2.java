package stream.file.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileReadingAndWritingTest2 {

	public static void main(String[] args) throws IOException {
		
		// 1. ��Ʈ������ -- �Է� 2��(FileReader, BufferedReader)
		BufferedReader br = new BufferedReader(new FileReader("src\\hope.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("src\\result.txt", true));
		try {
			// 2. while������ ������ ������ �а�
			String line = null;
			while ((line = br.readLine()) != null) {
				// 3. �� �ٸ� ���Ϸ� ���(Sink)�ϴ� ������ �ۼ�
				bw.write(line);
				bw.newLine();
			}
//		bw.flush(); //auto flushing ���...�����͸� ��Ƶ��� ���� �ԷµǴ� ���� �ٷ� ����Ѵ�.
		} finally {
			br.close();
			bw.close();
		}
		
	}

}
