package generic.test;

import generic.Powder;
import generic.ThreeDPrinter;

public class ThreeDPrinterTest {

	public static void main(String[] args) {

		ThreeDPrinter<Powder> printer = new ThreeDPrinter<Powder>();
		
		printer.setMaterial(new Powder());
		
		Powder powder = printer.getMaterial();
		
	}

}
