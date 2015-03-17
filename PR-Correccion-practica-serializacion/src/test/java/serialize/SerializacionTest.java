package serialize;


import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class SerializacionTest {

    private void ejecutaTestDeDatos(){
        DatosTest test = new DatosTest();
        test.carpetasAnidadasConDosTextosNoSonEqualsPorSize();
        test.carpetasAnidadasConDosTextosNoSonEqualsPorValores();
        test.carpetasAnidadasConDosTextosSonEquals();
        test.carpetasAnidadasConDosTextosYCarpetaNoSonEqualsPorNombre();
        test.carpetasAnidadasConDosTextosYCarpetaNoSonEqualsPorValores();
        test.carpetasAnidadasConDosTextosYCarpetaSonEquals();
        test.carpetasAnidadasConDosTextosYCarpetaVaciaNoSonEqualsPorNombreCarpeta();
        test.carpetasAnidadasConDosTextosYCarpetaVaciaSonEquals();
        test.carpetasAnidadasConUnTextoNoSonEqualsPorValores();
        test.carpetasAnidadasConUnTextoSonEquals();
        test.carpetasAnidadasVaciasSonEquals();
        test.creaCarpetaDatos();
        test.datosNoSonEqualsPorNombre();
        test.datosNoSonEqualsPorValor();
        test.datosSonEquals();
    }
    
    private String ficheroTemporal() throws IOException{
        File file = File.createTempFile("serializar", "", new File(".") );
        file.deleteOnExit();
        return file.getAbsolutePath();
    }

    private void testDeComparacion( Dato src ) throws IOException{
        ejecutaTestDeDatos();
        String file = ficheroTemporal(); 
        FabricaDeDatos.escribeDatoEnFichero(file, src);
        Dato d = FabricaDeDatos.leeDatoDeFichero(file);
        assertTrue( "he serializado " + src + " y al deserializarlo no es igual:" + d, src.equals(d) );
    }
    
    @Test
    public void serializaUnaCarpeta() throws IOException{
        CarpetaDatos cd = FabricaDeDatos.creaCarpetaDatos("a");
        testDeComparacion(cd);
    }

    @Test
    public void serializaUnaCarpetaConUnDato() throws IOException{
        CarpetaDatos cd = FabricaDeDatos.creaCarpetaDatos("a");
        cd.addDatoTexto("1", "1");
        testDeComparacion(cd);
    }

    @Test
    public void serializaUnaCarpetaConDosDato() throws IOException{
        CarpetaDatos cd = FabricaDeDatos.creaCarpetaDatos("a");
        cd.addDatoTexto("1", "1");
        cd.addDatoTexto("2", "2");
        testDeComparacion(cd);
    }


}
