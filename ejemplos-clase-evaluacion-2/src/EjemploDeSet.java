import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class EjemploDeSet {

	public static void main(String[] args) {
		String[] cadenas = {
				"a", "b", "hola", "que", "a", "hola"
		};
		
		System.out.println("Cadenas originales");
		for (String s : cadenas) {
			System.out.println(s);
		}
		
		Set<String> conjunto = new TreeSet<String>();
		List<String> lista = Arrays.asList(cadenas);
		conjunto.addAll( lista );
		
		System.out.println("Cadenas del set");
		for (String s : conjunto) {
			System.out.println(s);
		}
		
		
	}
	
}
