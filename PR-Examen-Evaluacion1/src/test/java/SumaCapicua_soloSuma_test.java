import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class SumaCapicua_soloSuma_test extends InputOutputTest{


    @Test
    public void testSinIncorrectos() {
	
	setInputStream( "34\n33\n" );
	invocaMain( "SumaCapicua", new String[0] );
	String out = getLastLineOut();
	
	assertTrue( "34 y 33 son 67", out.matches(".*67.*" ) );
	
    }

    @Test
    public void testIncorrectoUno() {
	
	setInputStream( "treinta y cuatro\n34\n33\n" );
	invocaMain( "SumaCapicua", new String[0] );
	String out = getLastLineOut();
	
	assertTrue( "34 y 33 son 67", out.matches(".*67.*" ) );
	
    }

    @Test
    public void testIncorrectoUnoUno() {
	
	setInputStream( "treinta y cuatro\nhola\n34\n33\n" );
	invocaMain( "SumaCapicua", new String[0] );
	String out = getLastLineOut();
	
	assertTrue( "34 y 33 son 67", out.matches(".*67.*" ) );
	
    }
    
    @Test
    public void testIncorrectoDosDos() {
	
	setInputStream( "34\nhola\nhola\n33\n" );
	invocaMain( "SumaCapicua", new String[0] );
	String out = getLastLineOut();
	
	assertTrue( "34 y 33 son 67", out.matches(".*67.*" ) );
	
    }

    
    @Test
    public void testIncorrectoDos() {
	
	setInputStream( "34\ntreinta y tres\n33\n" );
	invocaMain( "SumaCapicua", new String[0] );
	String out = getLastLineOut();
	
	assertTrue( "34 y 33 son 67", out.matches(".*67.*" ) );
	
    }

    @Test
    public void testIncorrectoUnoDos() {
	
	setInputStream( "treinta y cuatro\n34\ntreinta y tres\n33\n" );
	invocaMain( "SumaCapicua", new String[0] );
	String out = getLastLineOut();
	
	assertTrue( "34 y 33 son 67", out.matches(".*67.*" ) );
    }
    
}
