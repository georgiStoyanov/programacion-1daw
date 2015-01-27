package banco;

import org.junit.Test;
import static org.junit.Assert.*;



public class ListaTest {
    
    @Test
    public void laListaSeCreaVacia(){
        Lista l = new Lista();
        assertTrue( "La lista debe crearse vacia", l.getNumero() == 0 );
    }
    
    @Test
    public void elNumeroCreceAlAgregar(){
        Lista l = new Lista();
        for( int i = 1 ; i < 100 ; i++ ){
            Object o = new Object();
            l.agrega(o);
            assertTrue( String.format( "Tras insertar %d objetos, getNumero da:", i, l.getNumero()), i == l.getNumero() );
        }
    }

}
