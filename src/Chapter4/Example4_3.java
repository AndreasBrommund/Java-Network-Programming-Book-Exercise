package Chapter4;

import java.net.InetAddress;
import java.net.UnknownHostException;


public class Example4_3 {
	public static void main(String[] args) {
		InetAddress ia;
		try {
			ia = InetAddress.getByName("208.201.239.100");
			System.out.println(ia.getCanonicalHostName());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
