package serializar;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class BajarURL {

	public static void main(String[] args) throws IOException {
		String url = "https://www.google.es/images/srpr/logo11w.png";
		String file = "bajado-con-s.png";
		
		
		URL u = new URL(url);
		
		InputStream in = u.openStream();
		FileOutputStream out = new FileOutputStream(file);
		int b = in.read();
		while( b != -1 ){
			out.write(b);
			b = in.read();
		}
		in.close();
		out.close();
			
	}
}
