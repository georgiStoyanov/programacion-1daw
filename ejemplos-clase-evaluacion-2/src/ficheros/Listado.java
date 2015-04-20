package ficheros;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Listado {

	public static void main(String[] args) {
		if( args.length == 0 ){
			System.out.println("uso: <directorio>");
			System.exit(0);
		}
		
		File dir = new File(args[0]);
		
		File[] ficheros = dir.listFiles();
		
		Comparator<File> comparadorFicheros = new Comparator<File>(){
			@Override
			public int compare(File o1, File o2){
				long ret = o1.length() - o2.length();
				if( ret < 0 ) return -1;
				else if( ret > 0 ) return 1;
				else return 0;
			}
		};
		
		
		Arrays.sort(ficheros, comparadorFicheros);
		
		for( File f: ficheros ){
			if( f.isDirectory() ){
				continue;
			}
			System.out.printf("% 6d %s\n", f.length(), f.getName());
		}
			
	}
}
