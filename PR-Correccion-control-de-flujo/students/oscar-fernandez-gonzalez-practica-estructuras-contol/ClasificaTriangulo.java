/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Oscar Fernández González y Ana Guijarro Arbiol
 */
import java.util.Scanner;
public class ClasificaTriangulo {

    public static void main(String[] args) {

        System.out.println("Este programa clasifica triángulos.");
        Scanner in = new Scanner(System.in);
        int mayor = 0;
        System.out.println("Introduce Longitud del primer lado: ");
        int ladoA = Integer.parseInt(in.nextLine());
        System.out.println("Introduce Longitud del segundo lado:");
        int ladoB = Integer.parseInt(in.nextLine());
        System.out.println("Introduce Longitud del tercer lado:");
        int ladoC = Integer.parseInt(in.nextLine());

        if ((ladoA > ladoB) && (ladoA > ladoC)) {
            mayor = ladoA;

        } else if (ladoB > ladoC) {
            mayor = ladoB;
        } else {
            mayor = ladoC;
        }

        if ((ladoA + ladoB > ladoC) && (ladoA + ladoC > ladoB)
                && (ladoB + ladoC) > ladoA) {

            if (ladoA == ladoB && ladoB == ladoC) {

                System.out.println("Es un triangulo: Equilátero");

            } else if (ladoA == ladoB || ladoB == ladoC || ladoA == ladoC) {

                System.out.println("Es un triángulo: Isósceles");
            } else if ((mayor * mayor == (ladoA * ladoA) + (ladoB * ladoB))
                    || (mayor * mayor == (ladoB * ladoB) + (ladoC * ladoC))
                    || (mayor * mayor == (ladoA * ladoA) + (ladoC * ladoC))) {

                System.out.println("Es un triángulo: Rectángulo");

            } else if (ladoA != ladoB && ladoB != ladoC && ladoA != ladoC) {

                System.out.println("Es un triángulo: Escaleno");

            }

        } else {
            System.out.println("Es un triángulo: Imposible");

        }
       
        
        
        
        
        
        
        
    }
    
}    
    
    
    
    
    
    
    
    
    
    

