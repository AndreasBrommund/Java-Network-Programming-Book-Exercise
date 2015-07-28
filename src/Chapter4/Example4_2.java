package Chapter4;

import java.net.InetAddress;
import java.net.UnknownHostException;


public class Example4_2 {
	public static void main(String[] args) {
		InetAddress address;
		try {
			address = InetAddress.getLocalHost();
			System.out.println(address);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}
}
