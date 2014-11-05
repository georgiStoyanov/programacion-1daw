
/**
 * Desarrolla un programa que imprima las tablas de multiplicar de los 
 * números del 1 al 10.
 * Si el usuario solicita la tabla de un número fuera de rango (entre 1 
 * 10), se indicará fuera de rango.
 * 
 * @author Adrián Marcos Zarabozo González 
 */
import java.util.Scanner;
public class TablaDeMultiplicar
   {public static void main (String [] args){
        Scanner in = new Scanner (System.in);
        System.out.println("Tabla de multiplicar para el numero: ");
        int numeroTabla = Integer.parseInt(in.nextLine());
        
        if((numeroTabla<=10) && (numeroTabla >= 1)){
            for (int contador = 1; contador <= 10; contador= contador +1){
                System.out.println(numeroTabla + " x " + (contador) + " = " + (numeroTabla * contador));
            
            }
        }
        else{
            System.out.println("Fuera de rango ");
        }
    }
}
