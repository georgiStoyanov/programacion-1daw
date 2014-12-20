import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class SumaCapicua_capicua_test extends InputOutputTest{


    @Test
    public void testNoCapicua() {
	
	setInputStream( "34\n33\n" );
	invocaMain( "SumaCapicua", new String[0] );
	String out = getLastLineOut();
	
	assertTrue( "34 y 33 no es capicua:"  + out, out.matches("(?i).* no .*" ) );
	
    }


    @Test
    public void testSiCapicua1() {
	
	setInputStream( "3\n1\n" );
	invocaMain( "SumaCapicua", new String[0] );
	String out = getLastLineOut();
	
	boolean correcto = out.matches("(?i).* si .*" ) || ( out.matches("(?i).* capicua.*" ) && !out.matches("(?i).* no .*" ) );

	assertTrue( "3 y 1 si es capicua:" + out, correcto );
	
    }
    
    
    @Test
    public void testSiCapicua2() {
	
	setInputStream( "33\n33\n" );
	invocaMain( "SumaCapicua", new String[0] );
	String out = getLastLineOut();

	boolean correcto = out.matches("(?i).* si .*" ) || ( out.matches("(?i).* capicua.*" ) && !out.matches("(?i).* no .*" ) );

	
	assertTrue( "33 y 33 si es capicua:" + out, correcto );
	
    }

    
    @Test
    public void testSiCapicua3() {
	
	setInputStream( "330\n13\n" );
	invocaMain( "SumaCapicua", new String[0] );
	String out = getLastLineOut();

	boolean correcto = out.matches("(?i).* si .*" ) || ( out.matches("(?i).* capicua.*" ) && !out.matches("(?i).* no .*" ) );
	
	assertTrue( "330 y 13 si es capicua:" + out, correcto );
	
    }

    @Test
    public void testSiCapicua4() {
	
	setInputStream( "3300\n143\n" );
	invocaMain( "SumaCapicua", new String[0] );
	String out = getLastLineOut();
	
	boolean correcto = out.matches("(?i).* si .*" ) || ( out.matches("(?i).* capicua.*" ) && !out.matches("(?i).* no .*" ) );
	
	assertTrue( "3300 y 143 si es capicua:" + out, correcto );
	
    }
    
    
}
