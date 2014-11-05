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
public class Media {
    public static void main(String[]args){
    
        System.out.println("Programa que determina la media de un conjunto de números reales");

        System.out.println("----------------------------------------------------------------");

        System.out.println("Bienvenido al calculador de medias. ¿Cuántos números formaran parte de la media?");

        Scanner in = new Scanner(System.in);

        int numeroDatos = Integer.parseInt(in.nextLine());

        double suma = 0;

        double media = 0;

        for (int i = 1; i <= numeroDatos; i++) {

            System.out.println("Numero " + i + ":");

            double numeroIntroducido = Double.parseDouble(in.nextLine());

            suma = suma + numeroIntroducido;
        }

        media = (suma / numeroDatos);

        System.out.println("\n" + media);

    }

}
