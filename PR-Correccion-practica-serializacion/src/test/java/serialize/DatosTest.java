package serialize;

import org.junit.Test;


import static org.junit.Assert.*;

public class DatosTest {

    @Test
    public void datosSonEquals(){
        CarpetaDatos cd = FabricaDeDatos.creaCarpetaDatos("nombre");
        DatoTexto dt1 = cd.addDatoTexto("1", "1");
        DatoTexto dt2 = cd.addDatoTexto("1", "1");
        assertTrue( "Dos datos de texto deberían ser iguales:" + dt1 + " -- " + dt2, dt1.equals(dt2) );
    }

    
    @Test
    public void carpetasVaciasSonEquals(){
        CarpetaDatos cd1 = FabricaDeDatos.creaCarpetaDatos("nombre");
        CarpetaDatos cd2 = FabricaDeDatos.creaCarpetaDatos("nombre");
        assertTrue( "Dos carpetas deberían ser iguales:" + cd1 + " -- " + cd2, cd1.equals(cd2) );
    }

    @Test
    public void carpetasVaciasNoSonEqualsPorNombre(){
        CarpetaDatos cd1 = FabricaDeDatos.creaCarpetaDatos("nombre");
        CarpetaDatos cd2 = FabricaDeDatos.creaCarpetaDatos("nombrE");
        assertTrue( "Dos carpetas deberían ser distintas:" + cd1 + " -- " + cd2, !cd1.equals(cd2) );
    }

    @Test
    public void carpetasAnidadasConUnTextoSonEquals(){
        CarpetaDatos r = FabricaDeDatos.creaCarpetaDatos("r");
        CarpetaDatos cd1 = r.addCarpetaDatos("nombre");
        cd1.addDatoTexto("1", "1");
        CarpetaDatos cd2 = r.addCarpetaDatos("nombre");
        cd2.addDatoTexto("1","1");
        assertTrue( "Dos carpetas deberían ser iguales:" + cd1 + " -- " + cd2, cd1.equals(cd2) );
    }

    @Test
    public void carpetasAnidadasConUnTextoNoSonEqualsPorValores(){
        CarpetaDatos r = FabricaDeDatos.creaCarpetaDatos("r");
        CarpetaDatos cd1 = r.addCarpetaDatos("nombre");
        cd1.addDatoTexto("1", "2");
        CarpetaDatos cd2 = r.addCarpetaDatos("nombre");
        cd2.addDatoTexto("1","1");
        assertTrue( "Dos carpetas deberían ser distintas:" + cd1 + " -- " + cd2, !cd1.equals(cd2) );
    }

    @Test
    public void carpetasAnidadasConDosTextosSonEquals(){
        CarpetaDatos r = FabricaDeDatos.creaCarpetaDatos("r");
        CarpetaDatos cd1 = r.addCarpetaDatos("nombre");
        cd1.addDatoTexto("1", "1");
        cd1.addDatoTexto("2", "2");
        CarpetaDatos cd2 = r.addCarpetaDatos("nombre");
        cd2.addDatoTexto("2","2");
        cd2.addDatoTexto("1","1");
        assertTrue( "Dos carpetas deberían ser iguales:" + cd1 + " -- " + cd2, cd1.equals(cd2) );
    }

    @Test
    public void carpetasAnidadasConDosTextosYCarpetaVaciaSonEquals(){
        CarpetaDatos r = FabricaDeDatos.creaCarpetaDatos("r");
        CarpetaDatos cd1 = r.addCarpetaDatos("nombre");
        cd1.addCarpetaDatos("a");
        cd1.addDatoTexto("1", "1");
        cd1.addDatoTexto("2", "2");
        
        CarpetaDatos cd2 = r.addCarpetaDatos("nombre");
        cd2.addDatoTexto("2","2");
        cd2.addDatoTexto("1","1");
        cd2.addCarpetaDatos("a");
        assertTrue( "Dos carpetas deberían ser iguales:" + cd1 + " -- " + cd2, cd1.equals(cd2) );
    }

    @Test
    public void carpetasAnidadasConDosTextosYCarpetaSonEquals(){
        CarpetaDatos r = FabricaDeDatos.creaCarpetaDatos("r");
        CarpetaDatos cd1 = r.addCarpetaDatos("nombre");
        cd1.addDatoTexto("1", "1");
        cd1.addDatoTexto("2", "2");
        CarpetaDatos cd11 = cd1.addCarpetaDatos("a");
        cd11.addDatoTexto("a1","1");
        CarpetaDatos cd2 = r.addCarpetaDatos("nombre");
        cd2.addDatoTexto("2","2");
        cd2.addDatoTexto("1","1");
        CarpetaDatos cd21 = cd2.addCarpetaDatos("a");
        cd21.addDatoTexto("a1","1");
        assertTrue( "Dos carpetas deberían ser iguales:" + cd1 + " -- " + cd2, cd1.equals(cd2) );
    }

    @Test
    public void carpetasAnidadasConDosTextosYCarpetaNoSonEqualsPorValores(){
        CarpetaDatos r = FabricaDeDatos.creaCarpetaDatos("r");
        CarpetaDatos cd1 = r.addCarpetaDatos("nombre");
        cd1.addDatoTexto("1", "1");
        cd1.addDatoTexto("2", "2");
        CarpetaDatos cd11 = cd1.addCarpetaDatos("a");
        cd11.addDatoTexto("a1","1");
        CarpetaDatos cd2 = r.addCarpetaDatos("nombre");
        CarpetaDatos cd21 = cd2.addCarpetaDatos("a");
        cd21.addDatoTexto("a1","2");
        cd2.addDatoTexto("2","2");
        cd2.addDatoTexto("1","1");
        assertTrue( "Dos carpetas deberían ser distintas:" + cd1 + " -- " + cd2, !cd1.equals(cd2) );
    }

    public void carpetasAnidadasConDosTextosYCarpetaNoSonEqualsPorNombre(){
        CarpetaDatos r = FabricaDeDatos.creaCarpetaDatos("r");
        CarpetaDatos cd1 = r.addCarpetaDatos("nombre");
        cd1.addDatoTexto("1", "1");
        cd1.addDatoTexto("2", "2");
        CarpetaDatos cd11 = cd1.addCarpetaDatos("a");
        cd11.addDatoTexto("a1","1");
        CarpetaDatos cd2 = r.addCarpetaDatos("nombre");
        CarpetaDatos cd21 = cd2.addCarpetaDatos("b");
        cd21.addDatoTexto("a1","1");
        cd2.addDatoTexto("2","2");
        cd2.addDatoTexto("1","1");
        assertTrue( "Dos carpetas deberían ser distintas:" + cd1 + " -- " + cd2, !cd1.equals(cd2) );
    }
    
    @Test
    public void carpetasAnidadasConDosTextosYCarpetaVaciaNoSonEqualsPorNombreCarpeta(){
        CarpetaDatos r = FabricaDeDatos.creaCarpetaDatos("r");
        CarpetaDatos cd1 = r.addCarpetaDatos("nombre");
        cd1.addDatoTexto("1", "1");
        cd1.addDatoTexto("2", "2");
        cd1.addCarpetaDatos("a");
        CarpetaDatos cd2 = r.addCarpetaDatos("nombre");
        cd2.addDatoTexto("2","2");
        cd2.addDatoTexto("1","1");
        cd2.addCarpetaDatos("b");
        assertTrue( "Dos carpetas deberían ser distintas:" + cd1 + " -- " + cd2, !cd1.equals(cd2) );
    }

    @Test
    public void carpetasAnidadasConDosTextosNoSonEqualsPorValores(){
        CarpetaDatos r = FabricaDeDatos.creaCarpetaDatos("r");
        CarpetaDatos cd1 = r.addCarpetaDatos("nombre");
        cd1.addDatoTexto("1", "1");
        cd1.addDatoTexto("2", "1");
        CarpetaDatos cd2 = r.addCarpetaDatos("nombre");
        cd2.addDatoTexto("2","2");
        cd2.addDatoTexto("1","1");
        assertTrue( "Dos carpetas deberían ser distintas:" + cd1 + " -- " + cd2, !cd1.equals(cd2) );
    }

    @Test
    public void carpetasAnidadasConDosTextosNoSonEqualsPorSize(){
        CarpetaDatos r = FabricaDeDatos.creaCarpetaDatos("r");
        CarpetaDatos cd1 = r.addCarpetaDatos("nombre");
        cd1.addDatoTexto("1", "1");
        cd1.addDatoTexto("1", "1");
        cd1.addDatoTexto("2", "2");
        CarpetaDatos cd2 = r.addCarpetaDatos("nombre");
        cd2.addDatoTexto("2","2");
        cd2.addDatoTexto("1","1");
        assertTrue( "Dos carpetas deberían ser distintas:" + cd1 + " -- " + cd2, !cd1.equals(cd2) );
    }

    @Test
    public void carpetasAnidadasVaciasSonEquals(){
        CarpetaDatos r = FabricaDeDatos.creaCarpetaDatos("r");
        CarpetaDatos cd1 = r.addCarpetaDatos("nombre");
        CarpetaDatos cd2 = r.addCarpetaDatos("nombre");
        assertTrue( "Dos carpetas deberían ser iguales:" + cd1 + " -- " + cd2, cd1.equals(cd2) );
    }

    @Test
    public void datosNoSonEqualsPorNombre(){
        CarpetaDatos cd = FabricaDeDatos.creaCarpetaDatos("nombre");
        DatoTexto dt1 = cd.addDatoTexto("1", "1");
        DatoTexto dt2 = cd.addDatoTexto("2", "1");
        assertTrue( "Dos datos de texto no deberían ser iguales:" + dt1 + " -- " + dt2, !dt1.equals(dt2) );
    }

    @Test
    public void datosNoSonEqualsPorValor(){
        CarpetaDatos cd = FabricaDeDatos.creaCarpetaDatos("nombre");
        DatoTexto dt1 = cd.addDatoTexto("1", "1");
        DatoTexto dt2 = cd.addDatoTexto("1", "2");
        assertTrue( "Dos datos de texto no deberían ser iguales:" + dt1 + " -- " + dt2, !dt1.equals(dt2) );
    }

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
    
    @Test
    public void meterDosCamposDeTexto(){
        CarpetaDatos cd = FabricaDeDatos.creaCarpetaDatos("a");
        cd.addDatoTexto("1", "1");
        cd.addDatoTexto("2", "2");
            
        CarpetaDatos mcd = MiFabricaDeDatos.creaCarpetaDatos("a");
        mcd.addDatoTexto("1", "1");
        mcd.addDatoTexto("2", "2");
        
        assertTrue( "He intentado crear " + mcd + ", pero se ha creado:" + cd, mcd.equals(cd) );
    }


    public void ejecutaTodosLosTest() {
        carpetasAnidadasConDosTextosNoSonEqualsPorSize();
        carpetasAnidadasConDosTextosNoSonEqualsPorValores();
        carpetasAnidadasConDosTextosSonEquals();
        carpetasAnidadasConDosTextosYCarpetaNoSonEqualsPorNombre();
        carpetasAnidadasConDosTextosYCarpetaNoSonEqualsPorValores();
        carpetasAnidadasConDosTextosYCarpetaSonEquals();
        carpetasAnidadasConDosTextosYCarpetaVaciaNoSonEqualsPorNombreCarpeta();
        carpetasAnidadasConDosTextosYCarpetaVaciaSonEquals();
        carpetasAnidadasConUnTextoNoSonEqualsPorValores();
        carpetasAnidadasConUnTextoSonEquals();
        carpetasAnidadasVaciasSonEquals();
        creaCarpetaDatos();
        datosNoSonEqualsPorNombre();
        datosNoSonEqualsPorValor();
        datosSonEquals();
    }

}
