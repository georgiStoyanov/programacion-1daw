import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;


public class EjemploDeSystem {

	public static void main(String[] args) throws IOException {
		Properties p = System.getProperties();
		p.store(System.out, "Las propiedades");
		
		
		System.out.printf( "El usuario es %s\n", p.get("user.name") );
		System.out.printf( "la version de java es %s\n", p.get("java.version") );
		
	}
}
