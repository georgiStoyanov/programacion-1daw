package serialize;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.junit.Test;

public class SerializacionTest {

    private void ejecutaTestDeDatos(){
        new DatosTest().ejecutaTodosLosTest();
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
        compruebaQueElFicheroExisteYTieneAlgoSerializado(file);
        Dato d = FabricaDeDatos.leeDatoDeFichero(file);
        assertTrue( "he serializado " + src + " y al deserializarlo no es igual:" + d, src.equals(d) );
    }
    
    private void compruebaQueElFicheroExisteYTieneAlgoSerializado(String file) throws IOException{
        ObjectInputStream ois = new ObjectInputStream( new FileInputStream(file) );
        try{
            ois.readObject();
        }
        catch(Exception e ){
            ois.close();
            fail( "Parece que no se ha escrito correctamente el fichero serizalizado");
        }
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
    public void serializaUnaCarpetaConDosDatos() throws IOException{
        CarpetaDatos cd = FabricaDeDatos.creaCarpetaDatos("a");
        cd.addDatoTexto("1", "1");
        cd.addDatoTexto("2", "2");
        testDeComparacion(cd);
    }

    @Test
    public void serializaUnaCarpetaConDosDatosYUnaCarpeta() throws IOException{
        CarpetaDatos cd = FabricaDeDatos.creaCarpetaDatos("a");
        cd.addDatoTexto("1", "1");
        cd.addDatoTexto("2", "2");
        CarpetaDatos cd1 = cd.addCarpetaDatos("Una carpeta");
        cd1.addDatoTexto("11", "a");
        cd1.addDatoTexto("12", "b");
        
        testDeComparacion(cd);
    }

}
