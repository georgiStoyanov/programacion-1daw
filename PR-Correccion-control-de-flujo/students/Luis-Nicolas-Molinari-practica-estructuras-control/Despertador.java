
/**
 * Write a description of class Despertador here.
 * 
 * @author (Luis Nicolas Molinari) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Despertador
{
    public static void main (String args [])
    {
        Scanner in = new Scanner (System.in);
        int diaDeHoy, cuantosDias , diaInicio ;
        
        
        System.out.println("Bienvenido al programador de despertadores");
        System.out.println("Que dia de la semana es hoy?");
        diaDeHoy= in.nextInt();
        
        
        if((diaDeHoy>0)&&(diaDeHoy<=7)){
        
        diaInicio=(diaDeHoy+1);
        
        System.out.println("Cuantos dias debo programar el despertador");
        cuantosDias= in.nextInt();
        
        
            if(cuantosDias>=1){
                while(cuantosDias>=1)
                {   
                diaInicio= (diaInicio%7);
                    switch (diaInicio){
                                    case 1:
                                            System.out.printf("07:30 ");
                                            break;
                                    
                                    case 2:
                                            System.out.printf("07:30 ");
                                            break;
                                    
                                    case 3:
                                            System.out.printf("07:30 ");
                                            break;
                                    
                                    case 4:
                                            System.out.printf("07:30 ");
                                            break;
                                    
                                    case 5:
                                            System.out.printf("07:30 ");
                                            break;
                                    
                                    case 6:
                                            System.out.printf("10:30 ");
                                            break;
                                    
                                    case 0:
                                            System.out.printf("OFF ");
                                                
                                            
            }
            
            diaInicio ++;
            cuantosDias -- ;
        }
    }
    else
    {
        System.out.println("cero no es una opcion valida para programar el despertador");
    }
}
else {
    System.out.println("no es un dia valido , los dias van de 1 a 7");
}
    
    
}
}
