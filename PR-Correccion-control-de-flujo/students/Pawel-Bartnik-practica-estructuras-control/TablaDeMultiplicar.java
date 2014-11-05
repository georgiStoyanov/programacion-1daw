/**
 * @description : Tabla de multiplicar del 1 al 10. 
 * @author : Pawel Bartnik
 */
import java.util.Scanner;
public class TablaDeMultiplicar {
      public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        System.out.println("Tabla de multiplicar para el numero: ");
        n = in.nextInt();
             if (n>10 || n<1){
                 System.out.println("Fuera de rango");
                }
              else if(n<=10 ){
               for(int contador = 1; contador<=10; contador++){
                System.out.println(n + " x " + contador + " = " + n*contador);
               }   
             }
   }  
}