package exam.test;
// static initialization block...
// √ ±‚»≠...
public class StaticExamTest3 {
	static int i = 0;
	
	
	public static void main(String[] args) {
		System.out.println("2. main method static block..." + i);
	}

	static {
		i = 300;
		System.out.println("1. static initialization block..." + i);
	}
}
