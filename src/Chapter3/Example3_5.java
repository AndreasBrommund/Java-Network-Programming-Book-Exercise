package Chapter3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * Solve the problem we had before with, we use callback to solve the problem.  
 * 
 * @author andreasbrommund
 *
 */
public class Example3_5 implements Runnable{
	private String filename; 
	
	public Example3_5(String filename){
		this.filename = filename;
	}
	
	@Override
	public void run(){
		try {
			
			FileInputStream in = new FileInputStream(filename);
			MessageDigest sha = MessageDigest.getInstance("SHA-512");
			DigestInputStream din = new DigestInputStream(in,sha);
			while(din.read() != -1);
			din.close();
			byte[] digest = sha.digest(); 
			Example3_6.receiveDiest(digest, filename);
			
		} catch (IOException e) {
			System.err.println(e);
		} catch (NoSuchAlgorithmException e) {
			System.err.println(e);
		}
	}
}
