package ficheros;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public class ComprimeFichero {

	public static void main(String args[]) throws IOException {
		if (args.length != 2) {
			System.out
					.println(" Uso : < fichero origen > < fichero destino comprimido > ");
			System.exit(0);
		}
		InputStream in = null;
		OutputStream out = null;
		
		try {
			in = new FileInputStream(args[0]);
			out = new GZIPOutputStream( new FileOutputStream(args[1]) );
			byte[] buffer = new byte[512];
			int bytesLeidos;
			do {
				bytesLeidos = in.read(buffer);
				out.write(buffer, 0, bytesLeidos);
			} while (bytesLeidos == buffer.length);

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
