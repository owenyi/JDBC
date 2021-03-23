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
		
		System.out.println("1. file2 파일 이름을 출력 : " + file2.getName());
		System.out.println("2. file2 파일 경로를 출력 : " + file2.getPath());
		System.out.println("3. file2 파일 getParent() 결과를 출력 : " + file2.getParent());
		
		// 4. 해당 프로그램이 종료될 때 디렉토리 안에 있는 파일을 삭제하는 기능을 찾아서 적용
//		if (file2.delete()) System.out.println("파일이 삭제되었습니다.");
		file2.deleteOnExit(); // 프로그램 종료시
		
	}

}
