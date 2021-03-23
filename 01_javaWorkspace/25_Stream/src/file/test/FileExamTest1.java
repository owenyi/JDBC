package file.test;

import java.io.File;

/*
 * 파일 = 디렉토리정보 + 파일이름
 * 해당 클래스에서는
 * 파일을 다양한 방법으로 생성
 * 함수의 기능을 자세히 알아보는 로직을 작성
 * getParentFile() : File, getParent() : String
 * mkdir(), mkdirs() 
 */
public class FileExamTest1 {

	public static void main(String[] args) {
		
		File dir = new File("C:\\filetest");
		File dir2 = new File("C:\\filetest1\\step1\\code");
		File dir3 = new File("C:\\filetest1\\exam\\data.dat"); // 머신은 파일과 디렉토리 구분이 안된다
		
		System.out.println("파일이 생성되었나요?");
		
//		dir.mkdir(); // mkdirs()로 하나 만드는 것도 가능함
		dir.mkdirs();
		dir2.mkdirs();
		dir3.getParentFile().mkdirs();
		
		
	}

}
