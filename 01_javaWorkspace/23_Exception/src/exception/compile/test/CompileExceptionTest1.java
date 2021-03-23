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
			 * 1. 비워두거나
			 * 2. printStackTrace(), getMessage()를 쓰는데
			 * printStackTrace()...에러가 발생한 라인을 추적해서 원인을 출력 --> 추적당하는 원인
			 *   -> 개발할 때는 printStacTrace를
			 *   -> 배포시에는 비워두거나 getMessage()를 사용함
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
