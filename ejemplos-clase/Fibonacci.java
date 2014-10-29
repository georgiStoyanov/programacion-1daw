
/**
 * Write a description of class Fibonacci here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fibonacci
{
    public static long fibonacci ( long l ){
        if ( l == 0 ) return 0;
        else if ( l == 1 ) return 1;
        else return fibonacci (l -1) + fibonacci (l -2);
    }
    
    public static void main( String args[] ){
        for( long l = 0 ; l <= 15 ; l += 1 ){
            System.out.printf( "F%d = %d\n", l, fibonacci(l) );
        }
    }

}
