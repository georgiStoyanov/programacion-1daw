/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/*

  Desarrolla un programa que imprima las tablas de multiplicar de los números del 1 al 10.
  Si el usuario solicita la tabla de un número fuera de rango (entre 1 y 10), se indicará Fuera de rango

  @author Gonzalo Martinez Pizones
 */
public class TablaDeMultiplicar {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        System.out.println("Tabla de multiplicar para el numero:");
        int numero = Integer.parseInt(in.nextLine());
        if ((numero > 0)&&(numero <= 10)){
            for (int contador=1;contador <=10; contador=contador+1){
                int resultado = numero * contador;
                System.out.println(numero+" x "+(contador)+" = "+(resultado));
            }
        }else {
            System.out.println("Fuera de Rango");
        }
    }
}
