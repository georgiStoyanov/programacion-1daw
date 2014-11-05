/**
 * Programa que clasifica triángulos en función de la longitud de sus lados
 * 
 * @author Iván Hernanz Pérez
 * @version 24-oct-2014
 */
import java.util.Scanner;

public class ClasificaTriangulo{
    public static void main( String[] args ){
        Scanner in = new Scanner( System.in );
        
        System.out.println( "Este programa clasifica triángulos:" );
        
        // Variables
        int hipotenusa = Integer.MIN_VALUE;
        int cateto1 = Integer.MIN_VALUE;
        int cateto2 = Integer.MIN_VALUE;
        
        // Introducción Datos
        System.out.println( "Longitud del primer lado:" );
        int lado1 = Integer.parseInt( in.nextLine() );
        
        System.out.println( "Longitud del segundo lado:" );
        int lado2 = Integer.parseInt( in.nextLine() );
        
        System.out.println( "Longitud del tercer lado:" );
        int lado3 = Integer.parseInt( in.nextLine() );
        
        // Averiguar Hipotenusa
        if ( lado1 > lado2 ){    
            if( lado1 > lado3 ){
                hipotenusa = lado1;
            }
            else{
                hipotenusa = lado3;     
            }
        }
        else {
            if ( lado2 > lado3 ){
                hipotenusa = lado2;
            }
            else{
                hipotenusa = lado3;        
            }
        }
        // Averiguar Catetos
        if ( lado1 == hipotenusa ){    
               cateto1 = lado2;              
               cateto2 = lado3;     
        }
        else {
            cateto1 = lado1;
            if ( lado2 == hipotenusa ){
                cateto2 = lado3;
            }
            else{
                cateto2 = lado2;        
            }
        }    
         // Clasificación Triángulos  
      	 // ¿Es Equilátero?
        if ( (lado1 == lado2) &&  (lado1 == lado3 ) && (lado2 == lado3)) {          
            System.out.println( "Es un triángulo equilátero" );               
        } 
        // ¿Es Isósceles?
        else if( ((lado1 == lado2) ||  (lado1 == lado3 ) || (lado2 == lado3)) && ((cateto1 + cateto2) >= hipotenusa)) {
            System.out.println( "Es un triángulo isósceles" );         
        }
        // ¿Es Rectángulo?
        else if ( (hipotenusa * hipotenusa) == (cateto1 * cateto1) + (cateto2 * cateto2)) {    
            System.out.println( "Es un triángulo rectángulo" );       
        }
         // ¿Es Escaleno?
        else if( ((cateto1 + cateto2) >= hipotenusa) && ( (lado1 != lado2) && (lado1 != lado3) && (lado2 != lado3) )  ){  
             System.out.println( "Es un triángulo Escaleno" );
        }
       // ¿Es Imposible?
       else{
          System.out.println( "Es un triángulo Imposible" ); 
        }              
    }
}