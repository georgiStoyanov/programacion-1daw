package serialize;


import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.io.StreamCorruptedException;
import java.util.zip.ZipException;

import org.junit.Test;

public class SerializacionConGZIPTest {

    private void ejecutaTestDeDatos(){
        new DatosTest().ejecutaTodosLosTest();
    }
    
    private String ficheroTemporal() throws IOException{
        File file = File.createTempFile("serializar", "", new File(".") );
        file.deleteOnExit();
        return file.getAbsolutePath();
    }

    
    private void testDeGZIPCambiado( Dato src, boolean gzip ) throws IOException{
        ejecutaTestDeDatos();
        String file = ficheroTemporal(); 
        if( gzip ){
            try{
                FabricaDeDatos.escribeDatoEnFichero(file, src, gzip );
                FabricaDeDatos.leeDatoDeFichero(file, !gzip );
            }
            catch( StreamCorruptedException e ){
                return;
            }
            fail("No parece que se utilice el flat de gzip al serializar");
        }
        else{
            try{
                FabricaDeDatos.escribeDatoEnFichero(file, src, gzip );
                FabricaDeDatos.leeDatoDeFichero(file, !gzip );
            }
            catch( ZipException e ){
                return;
            }
            fail("No parece que se utilice el flat de gzip al serializar");
        }
    }

    
    private void testDeComparacionCorrecto( Dato src, boolean gzip ) throws IOException{
        ejecutaTestDeDatos();
        String file = ficheroTemporal(); 
        FabricaDeDatos.escribeDatoEnFichero(file, src, gzip );
        Dato d = FabricaDeDatos.leeDatoDeFichero(file, gzip );
        assertTrue( "he serializado " + src + " y al deserializarlo no es igual:" + d, src.equals(d) );
    }
    
    @Test
    public void serializaUnaCarpeta() throws IOException{
        CarpetaDatos cd = FabricaDeDatos.creaCarpetaDatos("a");
        testDeComparacionCorrecto(cd,true);
        testDeComparacionCorrecto(cd,false);
        testDeGZIPCambiado(cd,true);
        testDeGZIPCambiado(cd,false);
    }

    @Test
    public void serializaUnaCarpetaConUnDato() throws IOException{
        CarpetaDatos cd = FabricaDeDatos.creaCarpetaDatos("a");
        cd.addDatoTexto("1", "1");
        testDeComparacionCorrecto(cd,true);
        testDeComparacionCorrecto(cd,false);
        testDeGZIPCambiado(cd,true);
        testDeGZIPCambiado(cd,false);
    }

    @Test
    public void serializaUnaCarpetaConDosDatos() throws IOException{
        CarpetaDatos cd = FabricaDeDatos.creaCarpetaDatos("a");
        cd.addDatoTexto("1", "1");
        cd.addDatoTexto("2", "2");
        testDeComparacionCorrecto(cd,true);
        testDeComparacionCorrecto(cd,false);
        testDeGZIPCambiado(cd,true);
        testDeGZIPCambiado(cd,false);
    }

    @Test
    public void serializaUnaCarpetaConDosDatosYUnaCarpeta() throws IOException{
        CarpetaDatos cd = FabricaDeDatos.creaCarpetaDatos("a");
        cd.addDatoTexto("1", "1");
        cd.addDatoTexto("2", "2");
        CarpetaDatos cd1 = cd.addCarpetaDatos("Una carpeta");
        cd1.addDatoTexto("11", "a");
        cd1.addDatoTexto("12", "b");
        
        testDeComparacionCorrecto(cd,true);
        testDeComparacionCorrecto(cd,false);
        testDeGZIPCambiado(cd,true);
        testDeGZIPCambiado(cd,false);
    }

}