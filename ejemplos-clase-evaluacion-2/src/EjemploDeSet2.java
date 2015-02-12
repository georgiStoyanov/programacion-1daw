import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class EjemploDeSet2 {

	static class ComparadorInversoDeCadenas implements Comparator<String>{
		@Override
		public int compare(String o1, String o2) {
			System.err.printf("Me piden comparar %s y %s\n", o1, o2);
			return -o1.compareTo(o2);
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		
		Comparator<String> comparadorInversoDeCadenas = new ComparadorInversoDeCadenas();		
		Set<String> conjunto = new TreeSet<String>(comparadorInversoDeCadenas);
		
		while( true ){
			String linea = in.nextLine();
			if( linea.trim().equalsIgnoreCase("fin") ){
				break;
			}
			conjunto.add(linea.trim());
		}
		
		System.out.println("Cadenas del set");
		for (String s : conjunto) {
			System.out.println(s);
		}
		
		
	}
	
}
