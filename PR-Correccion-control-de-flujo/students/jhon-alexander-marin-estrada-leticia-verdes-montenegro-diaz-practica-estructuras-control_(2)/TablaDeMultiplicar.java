
/**
 *  Desarrolla un programa que imprima las tablas de multiplicar de los números del 1 al 10.
  Si el usuario solicita la tabla de un número fuera de rango (entre 1 y 10), se indicará Fuera de rango

  @author Jhon Alexander Marín Estrada / Leticia Verdes Montenegro Díaz
 */



import java.util.Scanner;

public class TablaDeMultiplicar
{
    public static void main(String[] args){
    
        Scanner in = new Scanner(System.in);
        
            
        
        //PIDO EL NUMERO DE LA TABLA DE MULTIPLICAR
        System.out.println(" tabla de multiplicar para numero: ");
        int numero = Integer.parseInt(in.nextLine());
        
        //CREO VARIABLES
        int contador = 1;
        int resultado = Integer.MIN_VALUE;
        
        //LIMITE DE LOS NUMERO QUE SE PIDEN POR TECLADO
        if(numero > 1 && numero < 11){
        
           //CREO LA CONDICION PARA REPETIR LA MULTIPLICACION 
           for(contador = 1; contador <= 10; contador = contador + 1 ){
    
              //REALIZO LA OPERACION DE MULTIPLICAR
              resultado = numero * contador;
             
              //SACO RESULTADO POR PANTALLA
              System.out.println(+ numero + " x " + contador +" = " +resultado);
            }
         
        }else{
        
            System.out.println("fuera de rango...");
                    
        }
         
    }
  
}
