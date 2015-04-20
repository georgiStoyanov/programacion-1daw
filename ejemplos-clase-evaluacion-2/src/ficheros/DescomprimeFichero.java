package ficheros;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class DescomprimeFichero {

	public static void main(String args[]) throws IOException {
		if (args.length != 2) {
			System.out
					.println(" Uso : < fichero origen comprimido > < fichero destino > ");
			System.exit(0);
		}
		InputStream in = null;
		OutputStream out = null;
		
		try {
			in = new GZIPInputStream( new FileInputStream(args[0]) );
			out = new FileOutputStream(args[1]);
			byte[] buffer = new byte[512];
			int bytesLeidos = in.read(buffer);
			while (bytesLeidos > 0){
				out.write(buffer, 0, bytesLeidos);
				bytesLeidos = in.read(buffer);
			} 

			System.out.println(" Fichero copiado ");
		}

		finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}
}
