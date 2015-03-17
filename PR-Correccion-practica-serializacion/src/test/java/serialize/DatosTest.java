package serialize;

import org.junit.Test;


import static org.junit.Assert.*;

public class DatosTest {

    @Test
    public void creaCarpetaDatos(){
        CarpetaDatos cd = FabricaDeDatos.creaCarpetaDatos("nombre");
        assertTrue( "El nombre de la carpeta de datos creada no es correcto", cd.getNombre().equals("nombre") );
    }

    @Test
    public void seCreaVacia(){
        CarpetaDatos cd = FabricaDeDatos.creaCarpetaDatos("nombre");
        assertTrue( "El una carpeta recien creada no tiene datos", cd.getDatos().length == 0 );
    }

    
    private void _meterUnDatoDeTexto(CarpetaDatos cd){
        cd.addDatoTexto("1", "1");
        Dato[] datos = cd.getDatos();
        assertTrue( "Si se añade un dato, debe tener un dato", datos.length == 1 );
        Dato d = datos[0];
        assertTrue( "El dato añadido era de texto, pero es de tipo:" + d.getClass(), d instanceof DatoTexto );
        assertTrue( "El dato de texto creado no tiene el nombre indicado", d.getNombre().equals("1") );
        DatoTexto dt = (DatoTexto) d;
        assertTrue( "El dato de texto creado no tiene el valor indicado", dt.getValor().equals("1") );
    }
    
    @Test
    public void meterUnDatoDeTexto(){
        CarpetaDatos cd = FabricaDeDatos.creaCarpetaDatos("nombre");
        _meterUnDatoDeTexto(cd);
    }

    @Test
    public void meterUnaCarpetaDeDatos(){
        CarpetaDatos cd = FabricaDeDatos.creaCarpetaDatos("nombre");
        _meterUnaCarpetaDeDatos(cd);
    }
    
    private void _meterUnaCarpetaDeDatos(CarpetaDatos cd){
        cd.addCarpetaDatos("1");
        Dato[] datos = cd.getDatos();
        assertTrue( "Si se añade una carpeta, debe tener un dato", datos.length == 1 );
        Dato d = datos[0];
        assertTrue( "El dato añadido era una carpeta, pero es de tipo:" + d.getClass(), d instanceof CarpetaDatos );
        assertTrue( "La carpeta creada no tiene los valores pasados", d.getNombre().equals("1") );
    }

    @Test
    public void meterUnaCarpetaEnUnaCarpeta(){
        CarpetaDatos cd = FabricaDeDatos.creaCarpetaDatos("nivel1").addCarpetaDatos("nivel2");
        _meterUnaCarpetaDeDatos(cd);
    }

    @Test
    public void meterUnDatoDeTextoEnUnaCarpeta(){
        CarpetaDatos cd = FabricaDeDatos.creaCarpetaDatos("nivel1").addCarpetaDatos("nivel2");
        _meterUnDatoDeTexto(cd);
    }

}
