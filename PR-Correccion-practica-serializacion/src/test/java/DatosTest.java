
import org.junit.Test;
import static org.junit.Assert.*;

import serialize.CarpetaDatos;
import serialize.FabricaDeDatos;

public class DatosTest {

    @Test
    public void creaCarpetaDatos(){
        CarpetaDatos cd = FabricaDeDatos.creaCarpetaDatos("nombre");
        assertTrue( "El nombre de la carpeta de datos creada no es correcto", cd.getNombre().equals("nombre") );
    }
    
}
