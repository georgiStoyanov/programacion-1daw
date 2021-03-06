package ficheros;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class ConversorDeCharset {

	private String charsetOrigen;
	private String charsetDestino;
	
	public ConversorDeCharset( String origen, String destino ){
		charsetOrigen = origen;
		charsetDestino = destino;
	}
	
	public void convierte( InputStream in, OutputStream out ) throws IOException{
		Reader reader = new InputStreamReader(in, charsetOrigen);
		Writer writer = new OutputStreamWriter(out, charsetDestino);
		char[] buffer = new char[512];
		int leidos = reader.read(buffer);
		while( leidos != -1 ){
			writer.write(buffer,0,leidos);
			leidos = reader.read(buffer);
		}
		writer.flush();
	}
	
	public static final ConversorDeCharset CONVERSOR_WINDOWS_LINUX = new ConversorDeCharset("ISO-8859-15", "UTF-8");
	public static final ConversorDeCharset CONVERSOR_LINUX_WINDOWS = new ConversorDeCharset("UTF-8", "ISO-8859-15");
	
	
}
