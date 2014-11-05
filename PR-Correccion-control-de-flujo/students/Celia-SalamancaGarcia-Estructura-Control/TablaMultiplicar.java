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
public class TablaMultiplicar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Programa Tabla de multiplicar del 1 al 10");

        System.out.println("Dame un numero");
        int numero = scanner.nextInt();

        int resultado;

        if (numero > 0 && numero <= 10) {
            for (int x = 1; x <= 10; x++) {
                resultado = numero * x;
                System.out.println(+numero + " x " + x + " = " + resultado);
            }
        } else {
            System.out.println("numero fuera de rango");
        }
    }

}
