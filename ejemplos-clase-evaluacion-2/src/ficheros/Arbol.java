package ficheros;

import java.io.File;

public class Arbol {
	private static void listaDirectorios(File dir, String indent) {
		System.out.println(indent + dir.getName());
		for (File f : dir.listFiles()) {
			if (f.isDirectory()) {
				listaDirectorios(f, indent + "  ");
			}
			if (f.isFile()) {
				System.out.println(indent + "  ->" + f.getName());

			}

		}
	}

	public static void main(String args[]) {
		File root = new File(".");
		listaDirectorios(root, " ");
	}

}
