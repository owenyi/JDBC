package stream.data.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputOutputTest5 {

	public static void main(String[] args) throws IOException {
		
		String inputFile = "png\\watermelon.png";
		String outputFile = "png\\water.png";
		
		DataInputStream dis = null;
		DataOutputStream dos = null;
		
		try {
			dis = new DataInputStream(new FileInputStream(inputFile));
			dos = new DataOutputStream(new FileOutputStream(outputFile));
			
			int data = 0;
			while ((data = dis.readInt()) != -1) dos.writeInt(data);
		} catch (EOFException e) {
			
		} finally {
			dis.close();
			dos.close();
		}

	}

}
