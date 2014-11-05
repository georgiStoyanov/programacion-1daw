/**
  Se necesita calcular la media de un conjunto de números reales.
  El programa comenzará preguntando por la cantidad de números que forman parte de la media. 
  Esta cantidad se supondrá entera y no negativa.
  Después preguntará por todos esos números (indicando su orden), y finalizará mostrando la media de los mismos.

  @author Jesus Salvador Barcenilla - Daniel Sanchez Lopez-Hermoso
*/
import java.util.Scanner;
public class Media
{
    public static void main ( String [] args)
    {

    Scanner in= new Scanner (System.in);
    
    double media=0;
    double suma=0;
    
    System.out.println("Bienvenido al calculador de medias. Cuantos numeros formaran parte de la media?");
    int max=Integer.parseInt( in.nextLine() );
    
    if (max<=0) {
            System.out.println("Has introducido un numero no válido");
        }
    else{
    
        int i;
    
        for(i=1;i<max+1;i++)
        
        
        {
            System.out.println("Número " +i+ " :");
            double numero=Double.parseDouble( in.nextLine() );            

            suma=suma+numero;
        }
    
        i=i-1;
        media=suma/i;
        System.out.println(media); 
       }
    }
}
