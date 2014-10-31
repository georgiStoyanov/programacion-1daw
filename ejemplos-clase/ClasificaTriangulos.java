
/**
 * Write a description of class ClasificaTriangulos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClasificaTriangulos
{
    public static void main( String args[] ){
        int a; 
        int b; 
        int c;
        
        boolean equilatero = a == b && a == c;
        
        boolean isoscelesAB = a == b && a != c;
        boolean isoscelesAC = a == c && a != b;
        boolean isoscelesBC = c == b && a != c;        
        boolean isosceles = isoscelesAB || isoscelesAC || isoscelesBC;
        
        boolean rectanguloA = a*a == (b*b + c*c);
        boolean rectanguloB = b*b == (a*a + c*c);
        boolean rectanguloC = c*c == (b*b + a*a);
        boolean rectangulo = rectanguloA || rectanguloB || rectanguloC;
        
        boolean imposibleA = a >= b + c;
        boolean imposible = ...;
        
        boolean escaleno = !imposible && !rectangulo && !isosceles && !equilatero;
        
        
        
        
    }
}
