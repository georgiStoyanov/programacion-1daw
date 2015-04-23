package examen;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.Reader;
import java.util.zip.GZIPInputStream;

public class FicheroSorpresa {

	/**
	 * Recibirá un nombre de fichero. Se garantiza que el fichero existe. El
	 * fichero puede ser: - Un fichero de texto UTF-8: se devolverá el contenido
	 * del fichero como String - Un fichero con un objeto serializado: se
	 * devolverá el valor como cadena del objeto, con String.valueOf() -
	 * Cualquiera de los anteriores, comprimido con GZIP: se descomprimirá y se
	 * devolverá lo mismo que si no estuviera comprimido - Ante un error:
	 * devolverá null
	 * 
	 * @param file
	 * @return
	 */
	public String ficheroSorpresa(String file) {
		String ret = null;

		ret = leeFicheroSerializado(file, true);
		if (ret != null) {
			return ret;
		}

		ret = leeFicheroSerializado(file, false);
		if (ret != null) {
			return ret;
		}

		ret = leeFicheroUTF8(file, true);
		if (ret != null) {
			return ret;
		}

		ret = leeFicheroUTF8(file, false);
		if (ret != null) {
			return ret;
		}




		return null;

	}

	private String leeFicheroSerializado(String file, boolean gzip) {
		try{
			ObjectInputStream oin = null;
			try{
				InputStream in = new FileInputStream(file);
				if( gzip ){
					in = new GZIPInputStream(in);
				}
				oin = new ObjectInputStream(in);
				Object o = oin.readObject();
				return String.valueOf(o);
				
			}
			finally{
				if( oin != null ){
					oin.close();
				}
			}
			
		}
		catch( IOException e ){
			return null;
		}
		catch( ClassNotFoundException e ){
			return null;
		}

	}

	private String leeFicheroUTF8(String file, boolean gzip) {
		try {
			Reader reader = null;
			try {
				String ret = "";
				InputStream in = new FileInputStream(file);
				if( gzip ){
					in = new GZIPInputStream(in);
				}
				reader = new InputStreamReader(in,"UTF-8");
				char buffer[] = new char[512];
				int leidos = reader.read(buffer);

				while (leidos > 0) {
					String s = new String(buffer, 0, leidos);
					ret += s;
					leidos = reader.read(buffer);
				}

				return ret;
			} finally {
				if (reader != null) {
					reader.close();
				}
			}
		} catch (IOException e) {
			return null;
		}
	}


}