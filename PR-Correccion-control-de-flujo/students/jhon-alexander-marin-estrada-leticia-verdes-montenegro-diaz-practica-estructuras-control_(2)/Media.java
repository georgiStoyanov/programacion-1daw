
/**
 *
  Se necesita calcular la media de un conjunto de números reales.
  El programa comenzará preguntando por la cantidad de números que forman parte de la media. 
  Esta cantidad se supondrá entera y no negativa.
  Después preguntará por todos esos números (indicando su orden), y finalizará mostrando la media de los mismos.

  @author Jhon Alexander Marín Estrada / Leticia Verdes Montenegro Díaz

 */

import java.util.Scanner;
public class Media
{
    public static void main(String[] args){
    
        Scanner in = new Scanner(System.in);
        
        //PIDO LOS NUMERO DE LA MEDIA
        System.out.println("Bienvenido al calculador de medias. Cuantos numeros formaran parte de la media?");
        double CantidadNumeros = Double.parseDouble(in.nextLine());
        double Media = 0;
        double suma = 0;
        int contador;
        
        
        for( contador = 0; contador < CantidadNumeros; contador++  ){
            
            System.out.println("Numero " + (contador + 1) + ":");
            double Numeros = Double.parseDouble(in.nextLine());
           
            if(Numeros > 0){
                
                suma = suma + Numeros;
            }
            
          
        }
          Media = suma / contador;
        System.out.println(Media);
    }
}
    

