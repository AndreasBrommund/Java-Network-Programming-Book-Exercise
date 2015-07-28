package Chapter3;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;


public class Example3_2 implements Runnable{

	public String filename; 
	
	public Example3_2(String filname) {
		this.filename = filname; 
	}
	
	@Override
	public void run() {
		try{
			FileInputStream in = new FileInputStream(filename);
			MessageDigest sha = MessageDigest.getInstance("SHA-256");
			DigestInputStream din = new DigestInputStream(in, sha);
			while(din.read() != -1);
			din.close();
			byte[] digest = sha.digest();
			 
			StringBuilder result = new StringBuilder(filename); 
			result.append(": ");
			result.append(DatatypeConverter.printHexBinary(digest));
			System.out.println(result);
		}catch(IOException ex){
			System.err.println(ex);
		}catch(NoSuchAlgorithmException ex){
			System.err.println(ex);
		}
	}
	
	public static void main(String[] args) {
		for(int i = 0;i < 1000;i++){
			Thread t = new Thread(new Example3_2("hej.txt"));
			t.start();
		}
	}

}
