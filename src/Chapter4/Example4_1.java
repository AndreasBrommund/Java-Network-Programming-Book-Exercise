package Chapter4;

import java.net.InetAddress;
import java.net.UnknownHostException;


public class Example4_1 {
	public static void main(String[] args) {
		InetAddress address;
		try {
			address = InetAddress.getByName("www.oreilly.com");
			System.out.println(address);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}
}
