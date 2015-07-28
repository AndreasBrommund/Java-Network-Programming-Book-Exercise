package Chapter3;

import javax.xml.bind.*; // for DatatypeConverter; requires Java 6 or JAXB 1.0

/**
 * 
 * Solve the problem we had before with, we use callback to solve the problem.  
 * Instant methods instead of class methods
 * 
 * @author andreasbrommund
 *
 */

public class Example3_8 {

	static String file = "hej.txt";
	
	private String filename;
	private byte[] digest;

	public Example3_8(String filename) {
		this.filename = filename;
	}

	public void calculateDigest() {
		Example3_7 cb = new Example3_7(filename, this);
		Thread t = new Thread(cb);
		t.start();
	}

	void receiveDigest(byte[] digest) {
		this.digest = digest;
		System.out.println(this);
	}

	@Override
	public String toString() {
		String result = filename + ": ";
		if (digest != null) {
			result += DatatypeConverter.printHexBinary(digest);
		} else {
			result += "digest not available";
		}
		return result;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 1000;i++) {
			// Calculate the digest
			Example3_8 d = new Example3_8(file);
			d.calculateDigest();
		}
	}
}