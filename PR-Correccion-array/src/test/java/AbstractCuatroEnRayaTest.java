import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;


public abstract class AbstractCuatroEnRayaTest extends InputOutputTest{
    

    protected void testCuatroEnRaya( boolean expectedPresent, String expected, int... columns) {
	String input = "";
	for (int c : columns) {
	    input += c + "\n";
	}

	setInputStream(input);
	invocaCuatroEnRaya();
	String out = getOut();
	String[] lines = out.split("\n");
	String lastLine = lines[lines.length - 1];

	String expectedRegex = "(?i).*" + expected + ".*";

	assertTrue("Se esperaba " + expected + ": " + lastLine, lastLine.matches(expectedRegex));
    }

    
    @Test
    public void testEmpate(){
	int columnas[] = new int[6*7];
	for( int i = 0 ; i < columnas.length ; i += 1 ){
	    columnas[i] = 1 + i%7;
	}
	
	System.err.println( mkstring(columnas) );
	
	testCuatroEnRaya( true, "empate", columnas );
    }

    @Test
    public void testEmpateConInvalidas(){
	ArrayList<Integer> columnasL = new ArrayList<Integer>();
	for( int i = 0 ; i < 6*7 ; i += 1 ){
	    columnasL.add( 1 + (i)%7 );
	}
	
	columnasL.add( 6*7 - 3, 1 );
	columnasL.add( 6*7 - 3, 2 );
	columnasL.add( 6*7 - 3, 3 );
	
	int columnas[] = new int[columnasL.size()];
	for( int i = 0 ; i < columnas.length ; i++ ){
	    columnas[i] = columnasL.get(i);
	}
	
	System.err.println( mkstring(columnas) );
	
	testCuatroEnRaya( true, "empate", columnas );
    }
    
    private String mkstring(int[] ints) {
	String ret = "";
	for( int i : ints ){
	    ret += i + " ";
	}
	return ret;
    }


    protected abstract void invocaCuatroEnRaya();

}
