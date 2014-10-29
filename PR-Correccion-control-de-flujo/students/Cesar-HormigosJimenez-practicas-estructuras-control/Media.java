/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Celia y Cesar
 */
import java.util.Scanner;

public class Media {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
        System.out.println("Programa de media");
       
        System.out.println("Dime de cuantos numeros quieres calcular la media");
        
        int numeros = scanner.nextInt();
        double suma = 0;
        
        for (int x = 1; x <= numeros; x++) {
            System.out.println("Dime el numero " + x);
            double numero = scanner.nextDouble();
            suma = suma + numero;

        }
        double media = suma / numeros;
        System.out.println("La media es " + media);
    }
}
