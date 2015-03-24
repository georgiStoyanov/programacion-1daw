package serializar;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.zip.GZIPInputStream;

/*
 * Crea un programa que lea todos los ficheros .ser (un objeto
serializado) o .ser.gz (un objeto serializado y comprimido con
GZIP) de su directorio de trabajo. Despu ́s mostrar ́ por pantalla el
e
a
resultado de String.valueOf() de cada objeto deserializado

 */

public class DeserializarDirectorio {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		if( args.length != 1 ){
			System.out.println("uso: <directorio>");
			return;
		}
		
		File directorio = new File( args[0] );
		
		for( File f: directorio.listFiles() ){
			if( !f.isFile() ){
				System.out.println(f + ": no es un fichero" );
				continue;
			}
			
			String nombreFichero = f.getPath().toLowerCase();
			if( nombreFichero.endsWith(".ser") ){
				System.out.println(f + ":" + deserializa(f) );
			}
			else if( nombreFichero.endsWith(".ser.gz") ){
				System.out.println(f + ":" + deserializaGZIP(f) );
			}
			else{
				System.out.println(f + ": ignorado" );
			}
		}
			
	}

	private static String deserializaGZIP(File f) throws IOException, ClassNotFoundException {
		FileInputStream fis = null;
		GZIPInputStream gis = null;
		ObjectInputStream ois = null;
		try{
			fis = new FileInputStream(f);
			gis = new GZIPInputStream(fis);
			ois = new ObjectInputStream(gis);
			Object o = ois.readObject();
			return String.valueOf(o);
		}
		finally{
			if( fis != null ){
				fis.close();
			}
			if( ois != null ){
				ois.close();
			}
		}
	}

	private static String deserializa(File f) throws IOException, ClassNotFoundException {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try{
			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			return String.valueOf(o);
		}
		finally{
			if( fis != null ){
				fis.close();
			}
			if( ois != null ){
				ois.close();
			}
		}
	}

}
