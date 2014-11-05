
/**
 * Write a description of class TablaDeMultiplicar here.
 * 
 * @author (Luis Nicolas Molinari) 
 * @version (a version number or a date)
 */
import java.util.Scanner ;
public class TablaDeMultiplicar
{
  public static void main ( String args [] )
  {
  Scanner in = new Scanner ( System.in );
  int tablaIn;
  
  System.out.println (" Ingresa la Tabla que quieres del 1 al 10 ");
  tablaIn=in.nextInt();
  
   System.out.println ("Tabla de multiplicar para el numero:");
   System.out.println (tablaIn);
  
        if((tablaIn>10)||(tablaIn<=0))
        
        {
            System.out.println ("Fuera de rango");
        }
        else 
        {
            for(int i=1;i<=10;i++)
            {
                System.out.println(tablaIn+" x "+i+" = "+(tablaIn*i));
            }
        }
  }
}
