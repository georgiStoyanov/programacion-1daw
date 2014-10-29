/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oscar Fernández González y Ana Guijarro Arbiol
 */
import java.util.Scanner;
public class Despertador {
    public static void main(String[]args){
    
    System.out.println("Bienvenido al programador de despertadores");
    
    Scanner in = new Scanner (System.in);
    
    System.out.println("¿Que dia de la semana es hoy?");
    
    int dia = Integer.parseInt(in.nextLine());
    
    System.out.println("¿Cuantos dias debo programar el despertador?");
    
    int diasProgDesp = Integer.parseInt(in.nextLine());
    
    for(int i=0;i<diasProgDesp;i++){
    
    int d=(dia+i)%7+1;
    
    switch(d){
    
        case 1:
        case 2:
        case 3:
        case 4:
        case 5: System.out.print("  7:30");break;
        case 6: System.out.print("  10:30");break;
        case 7: System.out.print("  OFF");break;
        default: System.out.print("ERROR");
    }
    
   
   
   }     
    
 }
}

 

