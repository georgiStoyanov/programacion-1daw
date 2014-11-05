/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerapractica;

import java.util.Scanner;

/**
 *
 * @author Celia y Cesar
 */
public class Triangulos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Este programa clasifica triángulos");
        
        System.out.println("Longitud del primer lado: ");
        int lado1 = Integer.parseInt(scanner.nextLine());

        System.out.println("Longitud del segundo lado: ");
        int lado2 = Integer.parseInt(scanner.nextLine());

        System.out.println("Longitud del tercer lado: ");
        int lado3 = Integer.parseInt(scanner.nextLine());

        if ((lado1 + lado2 > lado3) && (lado2 + lado3 > lado1)
                && (lado3 + lado1 > lado2)) {

            if ((lado1 == lado2) && (lado2 == lado3)) {
                System.out.println("Es un triángulo equilátero");

            }// hacer variables de los cuadrados para que se vea mas bonito
            else if ((lado1 * lado1) + (lado2 * lado2) == (lado3 * lado3)
                    || (lado1 * lado1) + (lado3 * lado3) == (lado2 * lado2)
                    || (lado2 * lado2) + (lado3 * lado3) == (lado1 * lado1)) {
                System.out.println("Es un triangulo rectángulo");
            } else if ((lado1 == lado2) || (lado1 == lado3) || (lado2 == lado3)) {

                System.out.println("Es un tríangulo isósceles");

            } else {

                System.out.println("Es un triángulo escaleno");

            }

        } else {
            System.out.println("Es un triangulo imposible");

        }
    }
}
