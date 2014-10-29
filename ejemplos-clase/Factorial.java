
/**
 * Write a description of class Factorial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Factorial
{

    public static void main(String[] args ){
        java.util.Scanner in = new java.util.Scanner(System.in);
        long a = Long.parseLong( in.nextLine() );
        long b = Long.parseLong( in.nextLine() );

        System.out.println( combinatorio(a,b) );
    }

    private static long factorial( long l ){
        
        new Throwable().printStackTrace(System.out);
        
        long ret = 1;

        for(int c = 1 ; c <= l ; c += 1 ){
            ret *= c;
        }

        return ret;
    }

    private static long combinatorio(long a, long b){
        long factA = factorial(a);
        long factB = factorial(b);
        long factAB = factorial(a-b);
        return factA/(factB * factAB);
    }

}
