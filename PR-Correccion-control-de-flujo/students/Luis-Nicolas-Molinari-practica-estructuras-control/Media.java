
/**
 * Write a description of class Media here.
 * 
 * @author (Luis Nicolas Molinari) 
 * @version (a version number or a date)
 */

    import java.util.Scanner ;
public class Media
{
  public static void main ( String args [] )
  {
  Scanner in = new Scanner ( System.in );
  int mediaIn, cont=1;
  double valorIn, sumatorio=0;
  
  System.out.println (" Bienvenido al calculador de medias. Cuantos numeros formaran parte de la media?");
  mediaIn=in.nextInt();
  
  
  
        if(mediaIn<=0)
        {
          System.out.println (" valor no valido es imposible ingresar -"+mediaIn+" numeros");
        }
        else if (mediaIn==0)
        {
            System.out.println (" Fin de progrgrama as elegido ingresar "+mediaIn+" numeros");
        }
        else
        {
            while (cont<=mediaIn)
            {
                System.out.println ("Numero "+cont+":");
                valorIn = in.nextDouble();
                sumatorio += valorIn ;
                cont++;
                
                
                
            }
            System.out.println(sumatorio/mediaIn);
        }

}
}
