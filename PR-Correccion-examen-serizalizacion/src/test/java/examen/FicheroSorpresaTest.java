package examen;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.zip.GZIPOutputStream;

import org.junit.Test;

public class FicheroSorpresaTest {

    private static final String[] UTF8 = {
            "En un lugar de la Mancha, de cuyo nombre no quiero acordarme, no ha mucho tiempo que vivía un hidalgo de los de lanza en astillero, adarga antigua, rocín flaco y galgo corredor. Una olla de algo más vaca que carnero, salpicón las más noches, duelos y quebrantos los sábados, lentejas los viernes, algún palomino de añadidura los domingos, consumían las tres partes de su hacienda. El resto della concluían sayo de velarte, calzas de velludo para las fiestas con sus pantuflos de lo mismo, los días de entre semana se honraba con su vellori de lo más fino. Tenía en su casa una ama que pasaba de los cuarenta, y una sobrina que no llegaba a los veinte, y un mozo de campo y plaza, que así ensillaba el rocín como tomaba la podadera. Frisaba la edad de nuestro hidalgo con los cincuenta años, era de complexión recia, seco de carnes, enjuto de rostro; gran madrugador y amigo de la caza. Quieren decir que tenía el sobrenombre de Quijada o Quesada (que en esto hay alguna diferencia en los autores que deste caso escriben), aunque por conjeturas verosímiles se deja entender que se llama Quijana; pero esto importa poco a nuestro cuento; basta que en la narración dél no se salga un punto de la verdad.\n"
                    +
                    "Es, pues, de saber, que este sobredicho hidalgo, los ratos que estaba ocioso (que eran los más del año) se daba a leer libros de caballerías con tanta afición y gusto, que olvidó casi de todo punto el ejercicio de la caza, y aun la administración de su hacienda; y llegó a tanto su curiosidad y desatino en esto, que vendió muchas hanegas de tierra de sembradura, para comprar libros de caballerías en que leer; y así llevó a su casa todos cuantos pudo haber dellos; y de todos ningunos le parecían tan bien como los que compuso el famoso Feliciano de Silva: porque la claridad de su prosa, y aquellas intrincadas razones suyas, le parecían de perlas; y más cuando llegaba a leer aquellos requiebros y cartas de desafío, donde en muchas partes hallaba escrito: la razón de la sinrazón que a mi razón se hace, de tal manera mi razón enflaquece, que con razón me quejo de la vuestra fermosura, y también cuando leía: los altos cielos que de vuestra divinidad divinamente con las estrellas se fortifican, y os hacen merecedora del merecimiento que merece la vuestra grandeza. Con estas y semejantes razones perdía el pobre caballero el juicio, y desvelábase por entenderlas, y desentrañarles el sentido, que no se lo sacara, ni las entendiera el mismo Aristóteles, si resucitara para sólo ello. No estaba muy bien con las heridas que don Belianis daba y recibía, porque se imaginaba que por grandes maestros que le hubiesen curado, no dejaría de tener el rostro y todo el cuerpo lleno de cicatrices y señales; pero con todo alababa en su autor aquel acabar su libro con la promesa de aquella inacabable aventura, y muchas veces le vino deseo de tomar la pluma, y darle fin al pie de la letra como allí se promete; y sin duda alguna lo hiciera, y aun saliera con ello, si otros mayores y continuos pensamientos no se lo estorbaran.",
                    "hola que tal",
                    "hola\nque\ntal\n",

    };
    
    private static final Object[] objetos = {
        UTF8[0],
        Arrays.asList( UTF8 ),
        new Date(0),
        new HashMap<String,String>(),
    };

    private void pruebaSerializado(Object o, boolean gzip) throws IOException {
        
        FicheroSorpresa fs = new FicheroSorpresa();
        File destino = new File("" + System.currentTimeMillis() + "-" + System.identityHashCode(fs));
        OutputStream out = new FileOutputStream(destino);
        if( gzip ){
            out = new GZIPOutputStream(out);
        }
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(o);
        oos.close();
        
        try {
            String leido = fs.ficheroSorpresa(destino.getPath());
            assertTrue("No coincide el fichero con lo leido:" + leido, String.valueOf(o).equals(leido));
        }
        finally {
            destino.delete();
        }
    }

    
    private void pruebaUTF8(String s, boolean gzip) throws IOException {
        
        FicheroSorpresa fs = new FicheroSorpresa();
        File destino = new File("" + System.currentTimeMillis() + "-" + System.identityHashCode(fs));
        OutputStream out = new FileOutputStream(destino);
        if( gzip ){
            out = new GZIPOutputStream(out);
        }
        Writer w = new OutputStreamWriter(out);
        w.write(s);
        w.close();
        
        try {
            String leido = fs.ficheroSorpresa(destino.getPath());
            assertTrue("No coincide el fichero con lo leido:" + leido, s.equals(leido));
        }
        finally {
            destino.delete();
        }
    }

    @Test
    public void pruebaUTF8() throws IOException {
        for (String s : UTF8) {
            pruebaUTF8(s,false);
        }
    }

    @Test
    public void pruebaUTF8GZIP() throws IOException {
        for (String s : UTF8) {
            pruebaUTF8(s,true);
        }
    }

    @Test
    public void pruebaSerializadoZIP() throws IOException {
        for (Object o : objetos ) {
            pruebaSerializado(o,true);
        }
    }

    @Test
    public void pruebaSerializado() throws IOException {
        for (Object o : objetos ) {
            pruebaSerializado(o,false);
        }
    }

}
