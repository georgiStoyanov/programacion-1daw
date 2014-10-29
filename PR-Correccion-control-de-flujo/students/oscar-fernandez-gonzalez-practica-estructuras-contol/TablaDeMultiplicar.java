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
public class TablaDeMultiplicar {
    public static void main(String[]args){
        
        System.out.println("Programa que imprime tablas de multiplicar del 1 al 10");

        System.out.println("-----------------------------------------------------");

        System.out.println("Tabla de multiplicar para el número:  \n");

        Scanner in = new Scanner(System.in);

        int numeroTabla = Integer.parseInt(in.nextLine());

        if (numeroTabla < 1 || numeroTabla > 10) {

            System.out.println(" \nfuera de rango ");

        } else {

            for (int i =1; i<=10; i++) {

                System.out.println( numeroTabla + "x" + i + "=" + numeroTabla * i);

            }

        }

    }
}
