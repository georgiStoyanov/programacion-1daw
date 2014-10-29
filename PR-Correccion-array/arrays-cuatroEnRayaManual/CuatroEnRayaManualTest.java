
import org.junit.Test;


public class CuatroEnRayaManualTest extends AbstractCuatroEnRayaTest {

    @Test
    public void testSaleConCero(){
	testCuatroEnRaya( false, "empate", 0 );
    }

    
    protected void invocaCuatroEnRaya() {
    	invocaMain( "CuatroEnRayaManual", new String[0] );
    }
}
