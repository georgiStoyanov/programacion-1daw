
import org.junit.Test;


public class CuatroEnRayaTest extends AbstractCuatroEnRayaTest {
    
	
	@Test
	public void testGanaJugador1Horizontal(){
		int columnas[] = { 
				1, 1, 2, 2, 3, 3, 
				1, 1, 2, 2, 3, 3,
				4
		};

		testCuatroEnRaya(true, "jugador\\s+1", columnas);
		
	}
	
	@Test
	public void testGanaJugador1Vertical(){
		int columnas[] = { 
				1, 2, 1, 2, 1, 2, 1
		};

		testCuatroEnRaya(true, "jugador\\s+1", columnas);
		
	}

	/**      
	 *       O
	 *      OX
	 *     OXO
	 *    OXXX
	 */
	@Test
	public void testGanaJugador2DiagonalAscendente(){
		int columnas[] = {
				2, 1,
				3, 2,
				3, 3,
				4, 4,
				4, 4,
		};

		testCuatroEnRaya(true, "jugador\\s+2", columnas);
	}
	
	@Test
	public void testGanaJugador2DiagonalDescendente(){
		int columnas[] = {
				7-2, 7-1,
				7-3, 7-2,
				7-3, 7-3,
				7-4, 7-4,
				7-4, 7-4,
		};

		testCuatroEnRaya(true, "jugador\\s+2", columnas);
		
	}
	
	
	
    protected void invocaCuatroEnRaya() {
    	invocaMain( "CuatroEnRaya", new String[0] );
    }
}
