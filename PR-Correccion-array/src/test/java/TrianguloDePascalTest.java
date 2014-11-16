import static org.junit.Assert.*;

import org.junit.Test;

public class TrianguloDePascalTest extends InputOutputTest {

    @Test
    public void test1() {
	testN(1, 1);
    }

    @Test
    public void test3() {
	testN(3, 1, 3, 3, 1);
    }

    @Test
    public void test15() {
	testN(15, 1, 14, 91, 364, 1001, 2002, 3003, 3432, 3003, 2002, 1001, 364, 91, 14, 1);
    }

    /**
     * 
     * @param row
     *            Fila del triangulo
     * @param expected
     *            Lo que deberia ser la fila
     */
    private void testN(int row, long... expected) {
	String regex = "\\s*";
	String humanReadable = "";
	for (long l : expected) {
	    regex += l + "\\s*";
	    humanReadable += l + " ";
	}
	setInputStream(row + "\n");
	TrianguloDePascal.main(new String[0]);
	String out = getOut();
	String[] lines = out.split("\n");
	String lastLine = lines[lines.length-1];
	assertTrue("La fila " + row + " debería ser " + humanReadable + ": " + out, lastLine.matches(regex));
    }
}
