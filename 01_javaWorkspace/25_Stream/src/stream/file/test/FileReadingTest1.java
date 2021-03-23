package stream.file.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReadingTest1 {

	public static void main(String[] args) throws IOException {
		
		// 1. 스트림생성 -- 입력 2개(FileReader, BufferedReader)
		BufferedReader br = new BufferedReader(new FileReader("src\\hope.txt"));
		try {
			// 2. while문에서 파일의 내용을 읽고
			String line = null;
			while ((line = br.readLine()) != null) {
				// 3. 콘솔로 출력하기...
				System.out.println(line);
			}
		} finally {
			br.close();
		}
		
	}

}
