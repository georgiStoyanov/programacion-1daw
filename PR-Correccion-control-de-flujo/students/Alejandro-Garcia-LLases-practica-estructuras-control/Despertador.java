
/**
 * Write a description of class despertador here.
 * 
 * @author (Alejandro Garcia LLases) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Despertador
{
    public static void main( String[] args ){
        
        
        System.out.println( "Bienvenido al programa de despertadores" );
        System.out.println( "Que dia de la semana es hoy?" );
        Scanner in = new Scanner( System.in );
        int diasemana = Integer.parseInt(in.nextLine());
        
        System.out.println( "cuantos dias debo de programar el despertador");
        int diasprograma = Integer.parseInt(in.nextLine());
        switch( diasemana ){ //casos para saber en que dia de la semana estoy
           case 1: //es lunes
           int bucle=0;
                for (int n= 2; bucle < diasprograma; n= n+1){
                    if(n>=8){
                        n = n-7;
                        }
                       
                    if ( n<=5){
                        System.out.print( "7:30 " );
                        bucle= bucle +1;
                    }
                        else if(n==6){
                            System.out.print( "10:30 " );
                            bucle= bucle +1;}
                            else if (n==7){
                                System.out.print( "OFF " );
                                bucle= bucle +1;}
                            }
                        
                    
                break;
           case 2: 
                bucle=0;
                for (int n= 3; bucle < diasprograma; n= n+1){
                    if(n>=8){
                        n = n-7;
                        }
                       
                    if ( n<=5){
                        System.out.print( "7:30 " );
                        bucle= bucle +1;
                    }
                        else if(n==6){
                            System.out.print( "10:30 " );
                            bucle= bucle +1;}
                            else if (n==7){
                                System.out.print( "OFF " );
                                bucle= bucle +1;}
                            }
                        
                    
                break;
           case 3: 
                bucle=0;
                for (int n= 4; bucle < diasprograma; n= n+1){
                    if(n>=8){
                        n = n-7;
                        }
                       
                    if ( n<=5){
                        System.out.print( "7:30 " );
                        bucle= bucle +1;
                    }
                        else if(n==6){
                            System.out.print( "10:30 " );
                            bucle= bucle +1;}
                            else if (n==7){
                                System.out.print( "OFF " );
                                bucle= bucle +1;}
                            }
                        
                    
                break;
           case 4:
               bucle=0;
                for (int n= 5; bucle < diasprograma; n= n+1){
                    if(n>=8){
                        n = n-7;
                        }
                       
                    if ( n<=5){
                        System.out.print( "7:30 " );
                        bucle= bucle +1;
                    }
                        else if(n==6){
                            System.out.print( "10:30 " );
                            bucle= bucle +1;}
                            else if (n==7){
                                System.out.print( "OFF " );
                                bucle= bucle +1;}
                            }
                        
                    
                break;
           case 5:
                bucle=0;
                for (int n= 6; bucle < diasprograma; n= n+1){
                    if(n>=8){
                        n = n-7;
                        }
                       
                    if ( n<=5){
                        System.out.print( "7:30 " );
                        bucle= bucle +1;
                    }
                        else if(n==6){
                            System.out.print( "10:30 " );
                            bucle= bucle +1;}
                            else if (n==7){
                                System.out.print( "OFF " );
                                bucle= bucle +1;}
                            }
                        
                    
                break;
           case 6: 
                bucle=0;
                for (int n= 7; bucle < diasprograma; n= n+1){
                    if(n>=8){
                        n = n-7;
                        }
                       
                    if ( n<=5){
                        System.out.print( "7:30 " );
                        bucle= bucle +1;
                    }
                        else if(n==6){
                            System.out.print( "10:30 " );
                        bucle= bucle +1;}
                            else if (n==7){
                                System.out.print( "OFF " );
                                bucle= bucle +1;}
                            }
                        
                    
                break;
                case 7: 
                bucle=0;
                for (int n= 1; bucle < diasprograma; n= n+1){
                    if(n>=8){
                        n = n-7;
                        }
                       
                    if ( n<=5){
                        System.out.print( "7:30 " );
                        bucle= bucle +1;
                    }
                        else if(n==6){
                            System.out.print( "10:30 " );
                            bucle= bucle +1;}
                            else if (n==7){
                                System.out.print( "OFF " );
                                bucle= bucle +1;}
                            }
                        
                    
                break;
            }


        }
    }

