package examen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopiaDirectorio {

	public static final int OK = 0;
	public static final int ORIGEN_NO_EXISTE_O_NO_ES_DIRECTORIO = -1;
	public static final int DESTINO_YA_EXISTE = -2;
	public static final int ERROR_CREANDO_DESTINO = -3;

	/**
	 * Copia un directorio recursivamente en otro directorio. Si no sucede
	 * ningún error devolverá OK (0) Si el directorio origen no existe,
	 * devolverá ORIGEN_NO_EXISTE_O_NO_ES_DIRECTORIO (-1), y no hará nada. Si el
	 * directorio destino ya existe, devolverá DESTINO_YA_EXISTE (-2), y no hará
	 * nada. Si el directorio destino no puede crearse, devolverá
	 * ERROR_CREANDO_DESTINO (-3), y no hará nada. En linux, el comando tree -s
	 * te dará información de si has copiado bien o mal el directorio
	 * 
	 * @param args
	 * @throws IOException
	 */
	public int copia(String directorioOrigen, String directorioDestino)
			throws IOException {

		File origen = new File(directorioOrigen);
		if (!origen.isDirectory() || !origen.exists()) {
			return ORIGEN_NO_EXISTE_O_NO_ES_DIRECTORIO;
		}

		File destino = new File(directorioDestino);
		if (destino.exists()) {
			return DESTINO_YA_EXISTE;
		}

		if (!destino.mkdirs()) {
			return ERROR_CREANDO_DESTINO;
		}

		copiaDirectorio( origen, destino );
		return OK;

	}
	
	private void copiaDirectorio( File origen, File destino ) throws IOException{
		destino.mkdirs();
		String[] files = origen.list();
		for (String file : files) {
			File f = new File(origen, file);
			if (f.isDirectory()) {
				copiaDirectorio(f, new File(destino, file) );
			} else {
				copiaFichero(f, new File(destino, file));
			}

		}
	}

	private void copiaFichero(File origen, File destino) throws IOException {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(origen);
			out = new FileOutputStream(destino);
			int b = in.read();
			while (b != -1) {
				out.write(b);
				b = in.read();
			}
		} finally {
			if (in != null)
				in.close();
			if (out != null)
				out.close();

		}

	}

}