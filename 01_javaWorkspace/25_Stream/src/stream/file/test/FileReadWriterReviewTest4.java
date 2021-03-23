package stream.file.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * hope.txt ������ ���� �����͸� �о --- FileReader Character�迭 ���
 * �ٸ� ����� result.txt ���Ϸ� ���� �����͸� ��� --- FileWriter Character�迭 ���
 * 
 * ��Ʈ�� �ڵ� �ۼ� ����
 * 1. �Է�, ��� ��Ʈ���� �Ѳ����� ����
 * 2. �ݺ��� �ȿ��� �����͸� ���� �� �о
 * 3. �ݺ��� �ȿ��� �о���� �����͸� Sink �������� ���� �� ���
 *    --> ���� �����͸� ����� ���� �о���̴� ���� ������� �ʰ�
 *        ��������ŭ ��Ƶξ��ٰ� �Ѳ����� ����ϴ� ������ ���δ�.
 *        1) auto flush��� -- flush()
 *        2) �ڿ��� ���� �� �� �ȿ� �ִ� �����͸� �Ѳ����� ��� -- close()
 */
class FileReadWriterReview{
	FileReadWriterReview() throws IOException {
		
		BufferedReader br = null;
		PrintWriter pw = null;
		// ������ ���⿡ �ۼ�...1, 2, 3
		try {
			br = new BufferedReader(new FileReader("src\\hope.txt"));
			pw = new PrintWriter("C:\\data\\result.txt"); // ���丮�� �����ؾ߸� ��� ��Ʈ���� ����...�� �ȿ� ��� ���ϵ� ���������.
			System.out.println("1. Stream Creating...");
			
			String line = null;
			System.out.println("2. FileReading...and Printing...");
			while ((line = br.readLine()) != null) pw.println(line);
		} finally {
			br.close();
			pw.close();
		}
		
	}
}

public class FileReadWriterReviewTest4 {

	public static void main(String[] args) throws IOException{

		new FileReadWriterReview();

	}

}
