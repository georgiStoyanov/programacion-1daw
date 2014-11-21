import org.junit.Test;

public class CuatroEnRayaTest extends AbstractCuatroEnRayaTest {

    @Test
    public void testGanaJugador1Horizontal(){
	testCuatroEnRaya( true, "jugador.*1", 1,1,2,2,3,3,4 );
    }

    @Test
    public void testGanaJugador2Vertical(){
	testCuatroEnRaya( true, "jugador.*2", 1,1,2,1,2,1,3,1 );
    }
    
    
    protected void invocaCuatroEnRaya() {
	CuatroEnRaya.main(null);
    }
}
