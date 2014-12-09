import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class EstadisticaDeTexto_normal_test extends InputOutputTest{

  

    @Test
    public void testMancha() {
	
	setInputStream( "En un lugar de La Mancha de cuyo nombre no quiero acordarme\n\n" );
	
	invocaMain("EstadisticaDeTexto", new String[0] );
	
	String[] lines = getLinesOut(3);
	assertTrue( "Deberia haber al menos 3 lineas", lines.length >= 3 );
	assertTrue( "Deberia haber 12 palabras", lines[0].matches( ".* 12 .*") );
	assertTrue( "La mas larga es de 9", lines[1].matches( ".* 9 .*") );
	assertTrue( "La mas corta es de 2", lines[2].matches( ".* 2 .*") );
    }

    
    @Test
    public void testOrilla() {
	
	setInputStream( "en esta apartada orilla mas cerca la luna brilla\n\n" );
	
	invocaMain("EstadisticaDeTexto", new String[0] );
	
	String[] lines = getLinesOut(3);
	assertTrue( "Deberia haber al menos 3 lineas", lines.length >= 3 );
	assertTrue( "Deberia haber 9 palabras", lines[0].matches( ".* 9 .*") );
	assertTrue( "La mas larga es de 8", lines[1].matches( ".* 8 .*") );
	assertTrue( "La mas corta es de 2", lines[2].matches( ".* 2 .*") );
    }
    
}
