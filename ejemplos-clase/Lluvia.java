
/**
 * Antes de salir de casa, miro por la ventana para ver si esa lloviendo, y en ese
 caso llevo el paraguas. Si llovi ́ el d ́ anterior, no miro por la ventana, y llevo el
o
ıa
paraguas directamente. Si llueve dos d ́ seguidos, al d ́ siguiente no llevo el
ıas
ıa
paraguas sino un chubasquero, por precauci ́n

 * 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lluvia
{
    public static void main( String args[] ){
        
        System.out.println( "***********************************************" );
        /* PRIMER CASO */
        {
            boolean llovioAnteayer = true;
            boolean llovioAyer = true;
            boolean llueveHoy = true;
            
            boolean llueveDosDíasSeguidos = (llovioAyer && llueveHoy) ||
                                            (llovioAyer && llovioAnteayer );
            
            boolean llevoElParaguas = (llueveHoy || llovioAyer) && !llueveDosDíasSeguidos;
                                       
            /*
            boolean llevoElChubasquero = [una expresion que lo calcule];
            */

            
            System.out.println( "anteayer - ayer - hoy: " + llovioAnteayer + " - " +
                                                            llovioAyer + " - " +
                                                            llueveHoy );
            System.out.println( "paraguas:" + llevoElParaguas );                                                        
            /*
            System.out.println( "chubasquero:" + llevoElChubasquero );        
            */
        }
                                                        
        /* SEGUNDO CASO */
        {
            boolean llovioAnteayer = false;
            boolean llovioAyer = true;
            boolean llueveHoy = false;
            boolean llueveDosDíasSeguidos = (llovioAyer && llueveHoy) ||
                                            (llovioAyer && llovioAnteayer );
            
            boolean llevoElParaguas = (llueveHoy || llovioAyer) && !llueveDosDíasSeguidos;
               /*
            boolean llevoElChubasquero = [una expresion que lo calcule];
            */

            
            System.out.println( "anteayer - ayer - hoy: " + llovioAnteayer + " - " +
                                                            llovioAyer + " - " +
                                                            llueveHoy );
            System.out.println( "paraguas:" + llevoElParaguas );                                                        
            /*
            System.out.println( "chubasquero:" + llevoElChubasquero );        
            */
        }

         /* TERCER CASO */
        {
            boolean llovioAnteayer = true;
            boolean llovioAyer = true;
            boolean llueveHoy = false;
             boolean llueveDosDíasSeguidos = (llovioAyer && llueveHoy) ||
                                            (llovioAyer && llovioAnteayer );
            
            boolean llevoElParaguas = (llueveHoy || llovioAyer) && !llueveDosDíasSeguidos;
               /*
            boolean llevoElChubasquero = [una expresion que lo calcule];
            */

            
            System.out.println( "anteayer - ayer - hoy: " + llovioAnteayer + " - " +
                                                            llovioAyer + " - " +
                                                            llueveHoy );
            System.out.println( "paraguas:" + llevoElParaguas );                                                        
            /*
            System.out.println( "chubasquero:" + llevoElChubasquero );        
            */
        }                                         
        
           /* CUARTO CASO */
        {
            boolean llovioAnteayer = false;
            boolean llovioAyer = false;
            boolean llueveHoy = true;
            boolean llueveDosDíasSeguidos = (llovioAyer && llueveHoy) ||
                                            (llovioAyer && llovioAnteayer );
            
            boolean llevoElParaguas = (llueveHoy || llovioAyer) && !llueveDosDíasSeguidos;
              /*
            boolean llevoElChubasquero = [una expresion que lo calcule];
            */

            
            System.out.println( "anteayer - ayer - hoy: " + llovioAnteayer + " - " +
                                                            llovioAyer + " - " +
                                                            llueveHoy );
            System.out.println( "paraguas:" + llevoElParaguas );                                                        
            /*
            System.out.println( "chubasquero:" + llevoElChubasquero );        
            */
        }     
        
           /* QUINTO CASO */
        {
            boolean llovioAnteayer = true;
            boolean llovioAyer = false;
            boolean llueveHoy = true;
            boolean llueveDosDíasSeguidos = (llovioAyer && llueveHoy) ||
                                            (llovioAyer && llovioAnteayer );
            
            boolean llevoElParaguas = (llueveHoy || llovioAyer) && !llueveDosDíasSeguidos;
              /*
            boolean llevoElChubasquero = [una expresion que lo calcule];
            */

            
            System.out.println( "anteayer - ayer - hoy: " + llovioAnteayer + " - " +
                                                            llovioAyer + " - " +
                                                            llueveHoy );
            System.out.println( "paraguas:" + llevoElParaguas );                                                        
            /*
            System.out.println( "chubasquero:" + llevoElChubasquero );        
            */
        }             
        
    }
}
