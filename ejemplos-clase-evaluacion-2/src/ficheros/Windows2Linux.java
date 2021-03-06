package ficheros;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Windows2Linux {

	public static void main(String[] arg) throws IOException{
		InputStream in = null;
		OutputStream out = null;
		try{
			in = new FileInputStream(arg[0]);
			out = new FileOutputStream(arg[1]);
			
			ConversorDeCharset.CONVERSOR_WINDOWS_LINUX.convierte(in, out);
		}
		finally{
			if( in != null ){
				in.close();
			}
			if( out != null ){
				out.close();
			}
		}
		
	}
}
