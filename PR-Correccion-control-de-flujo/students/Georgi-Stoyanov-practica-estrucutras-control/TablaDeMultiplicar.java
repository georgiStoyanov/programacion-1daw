import java.util.Scanner;
public class TablaDeMultiplicar
{ public static void main(String [] args){
      Scanner in = new Scanner(System.in);
        System.out.println("Tabla de multiplicar para el numero:");
        
        int numero= Integer.parseInt(in.nextLine());
        /* fuera de rango */
        if(numero>10){
            System.out.println("Fuera de rango");
        }
        /*multiplicator */
        if(numero<=10){
            for(int multi=1;multi<=10;multi=multi+1){
            System.out.println(numero+" x "+multi+" = "+multi*numero);
            }
        }
  }
}