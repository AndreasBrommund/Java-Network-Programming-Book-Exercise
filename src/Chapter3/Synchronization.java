package Chapter3;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;


public class Synchronization extends Thread {

	public String filename; 
	
	public Synchronization(String filname){
		this.filename = filname;
	}
	
	@Override
	public void run(){
		try{
			
			FileInputStream in = new FileInputStream(filename);
			MessageDigest sha = MessageDigest.getInstance("SHA-256");
			DigestInputStream din = new DigestInputStream(in, sha);
			while(din.read() != -1);
			din.close();
			byte[] digest = sha.digest();
			synchronized (System.out) {
				System.out.println(filename+ ": ");
				System.out.println(DatatypeConverter.printHexBinary(digest));
				System.out.println();
			}
		}catch(IOException ex){
			System.err.println(ex);
		}catch(NoSuchAlgorithmException ex){
			System.err.println(ex);
		}
		
	}
	public static void main(String[] args) {

		Thread t = new Synchronization("hej.txt");
		t.start(); 
		t = new Synchronization("då.txt");
		t.start(); 
		t = new Synchronization("java.txt");
		t.start(); 
		t = new Synchronization("text.txt");
		t.start(); 
		
	}
}

