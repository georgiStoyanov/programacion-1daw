
/**
 * Write a description of class DarVueltaAPalabra here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DarVueltaAPalabra
{
  public static void main(String args[] ){  
      String palabra = "palabra ";
      
      String inversa = "";
      // EMPEZAR EN length()-1
      // ACABAR EN 0
      for( int i = palabra.length()-1 ; i >= 0 ; i -= 1 ){
          inversa += palabra.charAt(i);
      }
      
      System.out.printf( "la cadena inversa de |%s| es |%s|\n", palabra, inversa );
  }
}
