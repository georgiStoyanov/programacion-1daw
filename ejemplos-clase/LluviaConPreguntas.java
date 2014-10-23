
/**
 * Write a description of class LluviaConPreguntas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Scanner;

public class LluviaConPreguntas
{
    public static void main( String[] args ){
        Scanner in = new Scanner( System.in );
        
        System.out.println( "Voy a ayudarte a decidir si llevar o no paraguas" );
        
        System.out.println( "¿Llovió anteayer?" );
        boolean llovioAnteayer = Boolean.parseBoolean(in.nextLine());
        
        System.out.println( "¿Llovió ayer?" );
        boolean llovioAyer = Boolean.parseBoolean(in.nextLine());
        
        System.out.println( "¿Está lloviendo hoy?" );        
        boolean llueveHoy = Boolean.parseBoolean(in.nextLine());
        
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
