import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class EstadisticaDeTexto_especial_test extends InputOutputTest{

  

    @Test
    public void testEspecial() {
	
	setInputStream( "\n\n" );
	
	invocaMain("EstadisticaDeTexto", new String[0] );
	
	String[] lines = getLinesOut(3);
	
	System.err.println( Arrays.asList(lines) );
	
	assertTrue( "Deberia haber al menos 3 lineas:" + lines.length, lines.length >= 3 );
	assertTrue( "Deberia haber 0 palabras:" + lines[0], lines[0].matches( ".* 0.*") );
	assertTrue( "No hay:" + lines[1], lines[1].matches( "(?i).* no * hay .*") );
	assertTrue( "No hay:" + lines[2], lines[2].matches( "(?i).* no * hay .*") );
    }

    
}
