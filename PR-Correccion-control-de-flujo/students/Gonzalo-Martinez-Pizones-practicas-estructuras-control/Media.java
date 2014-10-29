/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

import java.util.Scanner;

/*
  Se necesita calcular la media de un conjunto de números reales.
  El programa comenzará preguntando por la cantidad de números que forman parte de la media. 
  Esta cantidad se supondrá entera y no negativa.
  Después preguntará por todos esos números (indicando su orden), y finalizará mostrando la media de los mismos.

  @author Gonzalo Martinez Pizones
  */
public class Media  {
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        double sumatorio = 0;
        System.out.println("Bienvenido al calculador de medias. Cuantos numeros formaran parte de la media?");
        int numero = Integer.parseInt(in.nextLine());
        for (int contador =1;contador<=numero;contador++){
           System.out.println("Introduzca el numero "+ contador);
           double sumando = Double.parseDouble(in.nextLine());
           sumatorio = sumatorio + sumando;
        }
        double media = sumatorio / numero;
        System.out.println("La Media es: "+ media);
    }
}
