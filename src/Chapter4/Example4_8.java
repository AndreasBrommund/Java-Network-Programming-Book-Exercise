package Chapter4;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;


public class Example4_8 {
	public static void main(String[] args) {
		Enumeration<NetworkInterface> interfaces;
		try {
			interfaces = NetworkInterface.getNetworkInterfaces();
			
			while (interfaces.hasMoreElements()) {
				System.out.println(interfaces.nextElement());
				
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
