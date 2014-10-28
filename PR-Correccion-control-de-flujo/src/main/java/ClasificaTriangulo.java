/**
 * Se desea clasificar cada triángulo según sus características. Por orden de
 * importancia, nos interesan los triángulos: - Equiláteros - Isósceles -
 * Rectángulos - Escalenos - Y por último, los triángulos imposibles
 * 
 * Cuando un triángulo es de cierto tipo, ya no se comprueba si pertenece a un
 * tipo posterior.
 * 
 * Desarrolla un programa Java que pregunte por la longitud del primer, segundo
 * y tercer lado de un triángulo, y lo clasifique según el criterio anterior. Se
 * supondrá que las longitudes de los lados son números enteros.
 * 
 * @author Nombres de los autores
 */
public class ClasificaTriangulo {
	public static void main(String[] args) {

		int a = 5, b = 8, c = 3;

		boolean equilatero = a == b && b == c;

		boolean isoscelesAB = a == b;
		boolean isoscelesAC = a == c;
		boolean isoscelesBC = b == c;
		boolean isosceles = isoscelesAB ^ isoscelesAC ^ isoscelesBC;

		boolean rectanguloA = a * a == b * b + c * c;
		boolean rectanguloB = b * b == a * a + c * c;
		boolean rectanguloC = c * c == b * b + a * a;
		boolean rectangulo = rectanguloA || rectanguloB || rectanguloC;

		boolean imposibleA = a < b - c || a < c - b;
		boolean imposibleB = b < a - c || b < c - a;
		boolean imposibleC = c < a - b || c < b - a;
		boolean imposible = imposibleA || imposibleB || imposibleC;

		boolean escaleno = !imposible && !rectangulo && !isosceles
				&& !equilatero;

		System.out.println("a:" + a + "  b:" + b + "  c:" + c);
		System.out.println("equilatero:" + equilatero);
		System.out.println("isosceles:" + isosceles);
		System.out.println("rectangulo:" + rectangulo);
		System.out.println("imposible:" + imposible);
		System.out.println("escaleno:" + escaleno);
		
		if( equilatero ) System.out.println( "equilatero");
		else if( rectangulo ) System.out.println( "rectangulo ");
		else if( isosceles ) System.out.println( "isosceles" );
		else if( escaleno ) System.out.println( "escaleno" );
		else System.out.println( "imposible" );
	}
}
