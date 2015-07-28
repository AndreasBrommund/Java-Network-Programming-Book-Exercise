package Chapter3;

import javax.xml.bind.DatatypeConverter;

/**
 * It might work if we are lucky. The different  this and the the  example is that in this case 
 * we are calling the getDigest method later and the thread have a chance to initialized digest before.  
 *   
 * @author andreasbrommund
 *
 */
public class Example3_4_lucky {
	public static void main(String[] args) {
		String filname = "hej.txt";
		
		Example3_3[] digests = new Example3_3[1000];
		
		for(int i = 0; i< 1000; i++){
			//Calculate the digest 
			digests[i] = new Example3_3(filname);
			digests[i].start();
		}
		for(int i = 0; i < 1000; i++){
			//Now print the result
			StringBuilder result = new StringBuilder(filname);
			result.append(": ");
			byte[] digest = digests[i].getDigest();
			result.append(DatatypeConverter.printHexBinary(digest));
			System.out.println(result);
			
		}

	}
}
