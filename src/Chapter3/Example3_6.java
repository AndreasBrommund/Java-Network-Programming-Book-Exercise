package Chapter3;

import javax.xml.bind.DatatypeConverter;

/**
 * 
 * Solve the problem we had before with, we use callback to solve the problem.  
 * 
 * @author andreasbrommund
 *
 */
public class Example3_6 {
	
	static String file = "hej.txt";
	
	public static void receiveDiest(byte[] digest,String name){
		StringBuilder result = new StringBuilder(name); 
		result.append(": ");
		result.append(DatatypeConverter.printHexBinary(digest));
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			//Calculate the digest 
			Example3_5 cb = new Example3_5(file);
			Thread t = new Thread(cb);
			t.start();
		}
	}
}
