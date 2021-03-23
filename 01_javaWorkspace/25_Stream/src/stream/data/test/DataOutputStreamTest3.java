package stream.data.test;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataOutputStreamTest3{

	public static void main(String[] args){

		String outFile = "src\\scores.dat";
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(new FileInputStream(outFile));
		} catch (FileNotFoundException e) {
			
		}
		
		int data = 0;
		try {
			while ((data = dis.readInt()) != -1) System.out.println(data);
		} catch(EOFException e) {
			
		} catch(IOException e) {
			
		} finally {
			try {
				dis.close();
			} catch (IOException e) {
				
			}
		}
		
	}

}
