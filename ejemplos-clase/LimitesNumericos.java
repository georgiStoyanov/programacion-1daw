
/**
 * Write a description of class LimitesNumericos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LimitesNumericos
{
    public static void main( String[] args ){
        System.out.println( "Integer: " + Integer.MIN_VALUE + " -- " + Integer.MAX_VALUE );
        
        System.out.println( "Byte: " + Byte.MIN_VALUE + " -- " + Byte.MAX_VALUE );        

        System.out.println( "Float: " + Float.MIN_VALUE + " -- " + Float.MAX_VALUE );        
        
        
        System.out.println( "Float.MAX_VALUE+1:" + (Float.MAX_VALUE+1) );
        
        System.out.println( "Float.MAX_VALUE? :" + ((Float.MAX_VALUE+1)-Float.MAX_VALUE) );        

        
        System.out.println( "tautología:" + ( 5 < 8 ) );
        
        System.out.println( "false AND false:" + (false && false) );
    }

}
