package Chapter4;

import java.net.InetAddress;




public class Example4_5 {
	public static void main(String[] args) {
		
	}
	
	public static int getVersion(InetAddress ia){
		byte[] address = ia.getAddress();
		if(address.length == 4){
			return 4;
		}else if(address.length == 16){
			return 16;
		}else{
			return -1;
		}
		
	}
}


