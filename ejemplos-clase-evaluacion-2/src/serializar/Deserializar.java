package serializar;

import java.io.IOException;
import java.io.ObjectInputStream;


public class Deserializar {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(System.in);
		Object o = in.readObject();
		String[] strings = (String[]) o;
		for( String s: strings ){
			System.out.println( s );
		}
	}
}
