import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EjemploDeMap {

	private static class Alumno {
		public String nombre;
		public String curso;

		public Alumno(String n, String c) {
			nombre = n;
			curso = c;
		}
		
		@Override
		public String toString() {
			return "(" + nombre + " -- " + curso + ")";
		}
	}

	public static void main(String[] args) {
		Alumno[] alumnos = new Alumno[] { 
				new Alumno("pepe", "daw"),
				new Alumno("juana", "daw"),
				new Alumno("rosa", "daw"),
				new Alumno("maria", "dam"),
				new Alumno("juan", "smr"),
				new Alumno("pepa", "asir"), 
				new Alumno("manolo", "asir") 
		};

		Map<String, Alumno> nombreToAlumno = new HashMap<String, Alumno>();
		Map<String, Set<Alumno>> cursoToAlumnos = new HashMap<String, Set<Alumno>>();
		for (Alumno a : alumnos) {
			nombreToAlumno.put(a.nombre, a);
			
			Set<Alumno> conjuntoAlumnos = cursoToAlumnos.get(a.curso);
			if( conjuntoAlumnos == null ){
				conjuntoAlumnos = new HashSet<Alumno>();
				cursoToAlumnos.put( a.curso, conjuntoAlumnos );
			}
			conjuntoAlumnos.add(a);
			
		}

		System.out.println("De nombre a alumno");
		System.out.printf("%s -> %s\n", "pepe", nombreToAlumno.get("pepe"));
		System.out.printf("%s -> %s\n", "juan", nombreToAlumno.get("juan"));
		System.out.printf("%s -> %s\n", "maria", nombreToAlumno.get("maria"));

		System.out.println("De curso a alumno");
		System.out.printf("%s -> %s\n", "daw", cursoToAlumnos.get("daw"));
		System.out.printf("%s -> %s\n", "dam", cursoToAlumnos.get("dam"));
		System.out.printf("%s -> %s\n", "smr", cursoToAlumnos.get("smr"));
		System.out.printf("%s -> %s\n", "asir", cursoToAlumnos.get("asir"));

	}
}



















