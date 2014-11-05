/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerapractica;

/**
 *
 * @author Celia y Cesar
 */
import java.util.Scanner;

public class Despertador {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Programa de despertador");
        int hoy;

        System.out.println("Dime que dia de la semana es hoy");
        hoy = scanner.nextInt();
        
        System.out.println("Dias que voy a programar el despertador");
        int diasDespertador = scanner.nextInt();

        for (int contador = 0; contador < diasDespertador; contador++) {

            int dia = (hoy + contador) % 7 + 1;

            switch (dia) {

                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    System.out.print(" 7:30 ");
                    break;
                    
                case 6:
                    System.out.print(" 10:30 ");
                    break;
                    
                case 7:
                    System.out.print(" OFF ");
                    break;

            }

        }

    }

}
