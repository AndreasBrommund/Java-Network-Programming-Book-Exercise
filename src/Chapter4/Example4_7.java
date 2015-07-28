package Chapter4;

import java.net.InetAddress;
import java.net.UnknownHostException;


public class Example4_7 {
	public static void main(String[] args) {
		try {
			InetAddress ibiblio = InetAddress.getByName("www.ibiblio.org");
		    InetAddress helios = InetAddress.getByName("helios.ibiblio.org");
			if(ibiblio.equals(helios)){
				System.out.println("www.ibiblio.org is the same as helios.ibiblio.org");
			}else{
				System.out.println("www.ibiblio.org is not the same as helios.ibiblio.org");
			}
		} catch (UnknownHostException e) {
			System.out.println("Host lookup failed.");
		}
	}
}
