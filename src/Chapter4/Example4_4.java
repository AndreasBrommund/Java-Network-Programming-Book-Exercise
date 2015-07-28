package Chapter4;

import java.net.InetAddress;
import java.net.UnknownHostException;


public class Example4_4 {
	public static void main(String[] args) {
		try {
			InetAddress me = InetAddress.getLocalHost();
			String dottedQuad = me.getHostAddress();
			System.out.println("My address is "+ dottedQuad);
		} catch (UnknownHostException e) {
			System.out.println("I am sorry. I don't know my own address.");
		}
	}
}
