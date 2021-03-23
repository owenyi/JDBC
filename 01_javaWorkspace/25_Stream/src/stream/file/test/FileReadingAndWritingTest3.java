package stream.file.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileReadingAndWritingTest3 {

	public static void main(String[] args) throws IOException {
		
		// 1. 스트림생성 -- 입력 2개(FileReader, BufferedReader)
		BufferedReader br = new BufferedReader(new FileReader("src\\hope.txt"));
		PrintWriter pw = new PrintWriter(new FileWriter("src\\result.txt", true), true); // 이어쓰기, auto flushing
//		PrintWriter pw = new PrintWriter("src\\result.txt"); // 가능
		try {
			// 2. while문에서 파일의 내용을 읽고
			String line = null;
			while ((line = br.readLine()) != null) {
				// 3. 또 다른 파일로 출력(Sink)하는 로직을 작성
				pw.println(line);
			}
//		bw.flush(); //auto flushing 기능...데이터를 모아두지 말고 입력되는 족족 바로 출력한다.
		} finally {
			br.close();
			pw.close();
		}
		
	}

}
