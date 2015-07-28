package Chapter5;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;


public class DownloadAWebPage {
	public static void main(String[] arg) {
		String[] args = new String[1];
		args[0] = "http://www.oreilly.com:";
		
		if(args.length > 0){
			InputStream in = null; 
			try{
				//Open the URL for reading
				URL u = new URL(args[0]);
				in = u.openStream();
				//Buffer the input to increase performance 
				in = new BufferedInputStream(in);
				//chain the InputStream to a Reader
				Reader r = new InputStreamReader(in);
				int c; 
				while ((c = r.read())!= -1){
					System.out.print((char)c);
				}			
			}catch(MalformedURLException ex){
				System.err.println(args[0] + " is not a parseable URL");
			}catch (IOException ex) {
				System.err.println(ex);
			}finally{
				if(in != null){
					try{
						in.close();
					}catch(IOException e){
						//Ignore
					}
				}
			}
		}
	}
}
