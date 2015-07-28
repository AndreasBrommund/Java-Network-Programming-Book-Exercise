package Chapter3;

import javax.xml.bind.DatatypeConverter;

/**
 *	This is not a good way to solve the problem, 
 * 	because in take a lot more work and is not guaranteed to work   
 *
 * @author andreasbrommund
 *
 */
public class Example3_4_not_a_good_way {

	public static void main(String[] args) {
		String filname = "hej.txt";
		
		Example3_3[] digests = new Example3_3[1000];
		
		for(int i = 0; i< 1000; i++){
			//Calculate the digest 
			digests[i] = new Example3_3(filname);
			digests[i].start();
		}
		for(int i = 0; i < 1000; i++){
			while(true){
				//Now print the result
				byte[] digest = digests[i].getDigest();
				if(digest != null){
					StringBuilder result = new StringBuilder(filname);
					result.append(": ");
					result.append(DatatypeConverter.printHexBinary(digest));
					System.out.println(result);
					break;
				}
			}
		}

	}

}
