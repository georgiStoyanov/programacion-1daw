import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public abstract class AbstractCuatroEnRayaTest extends InputOutputTest {

	protected void testCuatroEnRaya(boolean expectedPresent, String expected,
			int... columns) {
		String input = "";
		for (int c : columns) {
			input += c + "\n";
		}

		System.err.println(mkstring(columns));
	
		setInputStream(input);
		try{
			invocaCuatroEnRaya();
		}
		finally{
			System.err.println(getOut());
		}
		String out = getOut();
		String[] lines = out.split("\n");
		String lastLine = lines[lines.length - 1];

		String expectedRegex = "(?i).*" + expected + ".*";

		
		
		assertTrue("Se esperaba " + expected + ": " + lastLine,
				lastLine.matches(expectedRegex));
	}

	@Test
	public void testEmpate() {
		int columnas[] = { 
				1, 1, 2, 2, 3, 3, 
				1, 1, 2, 2, 3, 3,
				1, 1, 2, 2, 3, 3,
				7, 7, 6, 6, 5, 5,
				7, 7, 6, 6, 5, 5,
				7, 7, 6, 6, 5, 4,
				4, 4, 4, 4, 4, 5
		};

		testCuatroEnRaya(true, "empate", columnas);
	}

	@Test
	public void testEmpateConInvalidas() {
		int columnasEmpate[] = { 
				1, 1, 2, 2, 3, 3, 
				1, 1, 2, 2, 3, 3,
				1, 1, 2, 2, 3, 3,
				7, 7, 6, 6, 5, 5,
				7, 7, 6, 6, 5, 5,
				7, 7, 6, 6, 5, 4,
				4, 4, 4, 4, 4, 5
		};
		
		ArrayList<Integer> columnasL = new ArrayList<Integer>();
		for (int i = 0; i < columnasEmpate.length; i += 1) {
			columnasL.add(columnasEmpate[i]);
		}

		columnasL.add(6 * 7 - 3, 1);
		columnasL.add(6 * 7 - 3, 2);
		columnasL.add(6 * 7 - 3, 3);

		int columnas[] = new int[columnasL.size()];
		for (int i = 0; i < columnas.length; i++) {
			columnas[i] = columnasL.get(i);
		}

		testCuatroEnRaya(true, "empate", columnas);
	}

	private String mkstring(int[] ints) {
		String ret = "";
		for (int i : ints) {
			ret += i + " ";
		}
		return ret;
	}

	protected abstract void invocaCuatroEnRaya();

}
