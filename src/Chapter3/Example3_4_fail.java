package Chapter3;

import javax.xml.bind.DatatypeConverter;

/**
 * You are going to get a NullPointerExeptoion 
 * Because the main thread faster than the thread so the digests filed are not initialized. 
 * 
 * @author andreasbrommund
 *
 */
public class Example3_4_fail{

	public static void main(String[] args) {
		String filname = "hej.txt";
		
		for(int i = 0; i < 1000; i++){
			//Calculate the digest 
			Example3_3 dr = new Example3_3(filname);
			dr.start();
			
			//Now print the result
			StringBuilder result = new StringBuilder(filname);
			result.append(": ");
			byte[] digest = dr.getDigest();
			result.append(DatatypeConverter.printHexBinary(digest));
			System.out.println(result);
			
		}

	}

}
