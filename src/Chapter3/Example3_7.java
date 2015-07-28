package Chapter3;

import java.io.*;
import java.security.*;

/**
 * 
 * Solve the problem we had before with, we use callback to solve the problem.  
 * Instant methods instead of class methods
 * 
 * @author andreasbrommund
 *
 */

public class Example3_7 implements Runnable {

	private String filename;
	private Example3_8 callback;

	public Example3_7(String filename, Example3_8 callback) {
		this.filename = filename;
		this.callback = callback;
	}

	@Override
	public void run() {
		try {
			FileInputStream in = new FileInputStream(filename);
			MessageDigest sha = MessageDigest.getInstance("SHA-256");
			DigestInputStream din = new DigestInputStream(in, sha);
			while (din.read() != -1)
				; // read entire file
			din.close();
			byte[] digest = sha.digest();
			callback.receiveDigest(digest);
		} catch (IOException | NoSuchAlgorithmException ex) {
			System.err.println(ex);
		}
	}
}