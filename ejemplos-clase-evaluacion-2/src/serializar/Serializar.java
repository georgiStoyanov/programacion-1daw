package serializar;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serializar {

	public static void main(String[] args) throws IOException {
		
		ObjectOutputStream out = new ObjectOutputStream(System.out);
		out.writeObject(args);
	}
}
