package Chapter5
        ;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class DownloadAnObject {
	public static void main(String[] arg) {
		String[] args = new String[1];
		args[0] = "http://www.oreilly.com:";
		if(args.length > 0){
			//Open the URL for reading 
			try{
				URL u = new URL(args[0]);
				Object o = u.getContent();
				System.out.println("I got a "+ o.getClass().getName());
			}catch(MalformedURLException ex ){
				System.err.println(args[0] + " is not a parseble URL");
			}catch(IOException ex){
				System.err.println(ex);
			}
		}
	}
}
