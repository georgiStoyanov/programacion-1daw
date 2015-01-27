package banco;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;



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
            assertTrue( String.format( "Tras insertar %d objetos, getNumero da:%d", i, l.getNumero()), i == l.getNumero() );
        }
    }

    
    @Test
    public void elNumeroDecreceAlBorrar(){
        Lista l = new Lista();
        for( int i = 1 ; i <= 100 ; i++ ){
            Object o = new Object();
            l.agrega(o);
        }
        
        for( int i = 1 ; i <= 100 ; i++ ){
            l.borra(0);
            assertTrue( String.format( "Tras insertar 100 objetos y borrar %d objetos, getNumero da:%d", i, l.getNumero()), i + l.getNumero() == 100 );
        }
    }
    
    @Test
    public void seEncuentraUnObjetoConIgualIgual(){
        Lista l = new Lista();
        Object[] os = new Object[]{ "Hola", 2, "Adios", new Date() };
        for( Object o: os ){
            l.agrega(o);
        } 
        assertTrue( String.format("Hola se encuentra en la posicion 0, pero indiceDe da:%d  (%s)", l.indiceDe("Hola"), l ), l.indiceDe("Hola") == 0 );
    }

    @Test
    public void seEncuentraUnObjetoConIgualIgualAlFinal(){
        Lista l = new Lista();
        Object[] os = new Object[]{ "Hola", 2, "Adios", new Date(), "Fin" };
        for( Object o: os ){
            l.agrega(o);
        }
        assertTrue( String.format("Fin se encuentra en la posicion 4, pero indiceDe da:%d  (%s)", l.indiceDe("Fin"), l ), l.indiceDe("Fin") == 4 );
    }

    
    @Test
    public void seEncuentraUnObjetoConEquals(){
        Lista l = new Lista();
        Object[] os = new Object[]{ "Hola".toUpperCase(), 2, "Adios", new Date() };
        for( Object o: os ){
            l.agrega(o);
        }
        assertTrue( String.format("HOLA se encuentra en la posicion 0, pero indiceDe da:%d  (%s)", l.indiceDe("HOLA"), l ), l.indiceDe("HOLA") == 0 );
    }

    @Test
    public void seEncuentraUnObjetoConEqualsAlFinal(){
        Lista l = new Lista();
        Object[] os = new Object[]{ "Hola".toUpperCase(), 2, "Adios", new Date(), "Fin".toUpperCase() };
        for( Object o: os ){
            l.agrega(o);
        }
        assertTrue( String.format("FIN se encuentra en la posicion 4, pero indiceDe da:%d  (%s)", l.indiceDe("FIN"), l ), l.indiceDe("FIN") == 4 );
    }

    
    @Test
    public void seBorraUnObjetoAlPrincipio(){
        Lista l = new Lista();
        Object[] os = new Object[]{ "Hola", 2, "Adios", new Date(0), "Fin" };
        for( Object o: os ){
            l.agrega(o);
        }
        String antesDeBorrar = l.toString();
        l.borra(0);
        String despuesDeBorrar = l.toString();
        
        String msg = String.format("Al borrar la posicion 0 de (%s) queda (%s)", antesDeBorrar, despuesDeBorrar );
        assertTrue( msg, l.getObjeto(0).equals(2) );
        assertTrue( msg, l.getObjeto(1).equals("Adio"+"s") );
        assertTrue( msg, l.getObjeto(2).equals( new Date(0) ) );
        assertTrue( msg, l.getObjeto(3).equals("Fin") );
    }

    @Test
    public void seBorraUnObjetoAlFinal(){
        Lista l = new Lista();
        Object[] os = new Object[]{ "Hola", 2, "Adios", new Date(0), "Fin" };
        for( Object o: os ){
            l.agrega(o);
        }
        String antesDeBorrar = l.toString();
        l.borra(4);
        String despuesDeBorrar = l.toString();
        
        String msg = String.format("Al borrar la posicion 4 de (%s) queda (%s)", antesDeBorrar, despuesDeBorrar );
        assertTrue( msg, l.getObjeto(0).equals("Hol"+"A".toLowerCase()) );
        assertTrue( msg, l.getObjeto(1).equals(2) );
        assertTrue( msg, l.getObjeto(2).equals("Adio"+"s") );
        assertTrue( msg, l.getObjeto(3).equals( new Date(0) ) );
    }

    @Test
    public void seBorraUnObjetoIntermedio(){
        Lista l = new Lista();
        Object[] os = new Object[]{ "Hola", 2, "Adios", new Date(0), "Fin" };
        for( Object o: os ){
            l.agrega(o);
        }
        String antesDeBorrar = l.toString();
        l.borra(2);
        String despuesDeBorrar = l.toString();
        
        String msg = String.format("Al borrar la posicion 2 de (%s) queda (%s)", antesDeBorrar, despuesDeBorrar );
        assertTrue( msg, l.getObjeto(0).equals("Hol"+"A".toLowerCase()) );
        assertTrue( msg, l.getObjeto(1).equals(2) );
        assertTrue( msg, l.getObjeto(2).equals( new Date(0) ) );
        assertTrue( msg, l.getObjeto(3).equals("Fin") );
    }
    
    private boolean exactamenteIndexOutOfBounds(Exception e ){
        return e.getClass().equals( IndexOutOfBoundsException.class );
    }
    
    @Test
    public void accederPorDebajoDeCeroEnListaVacia(){
        String msg = "al acceder por debajo de cero en lista vacia";
        try{
            new Lista().getObjeto(-1);
            fail( "No se ha producido excepcion " + msg );
        }
        catch( IndexOutOfBoundsException e ){
            assertTrue( "La excepcion " + msg + " no deberia ser " + e, exactamenteIndexOutOfBounds(e) );
        }
    }

    @Test
    public void accederACeroEnListaVacia(){
        String msg = "al acceder a debajo de cero en lista vacia";
        try{
            new Lista().getObjeto(0);
            fail( "No se ha producido excepcion " + msg );
        }
        catch( IndexOutOfBoundsException e ){
            assertTrue( "La excepcion " + msg + " no deberia ser " + e, exactamenteIndexOutOfBounds(e) );
        }
    }

    @Test
    public void accederAUnoEnListaVacia(){
        String msg = "al acceder a 1 en lista vacia";
        try{
            new Lista().getObjeto(1);
            fail( "No se ha producido excepcion " + msg );
        }
        catch( IndexOutOfBoundsException e ){
            assertTrue( "La excepcion " + msg + " no deberia ser " + e, exactamenteIndexOutOfBounds(e) );
        }
    }
    
    @Test
    public void accederPorDebajoDeCero(){
        String msg = "al acceder a -1 en lista llena";
        try{
            Lista l = new Lista();
            l.agrega( new Object() );
            new Lista().getObjeto(-1);
            fail( "No se ha producido excepcion " + msg );
        }
        catch( IndexOutOfBoundsException e ){
            assertTrue( "La excepcion " + msg + " no deberia ser " + e, exactamenteIndexOutOfBounds(e) );
        }
    }

    @Test
    public void accederPorEncimaDeCeroEnListaConUnElemento(){
        String msg = "al acceder a 1 en lista con un elemento";
        try{
            Lista l = new Lista();
            l.agrega( new Object() );
            new Lista().getObjeto(1);
            fail( "No se ha producido excepcion " + msg );
        }
        catch( IndexOutOfBoundsException e ){
            assertTrue( "La excepcion " + msg + " no deberia ser " + e, exactamenteIndexOutOfBounds(e) );
        }
    }
    

    @Test
    public void caben1000Elementos(){
        Lista l = new Lista();
        for( int i = 0 ; i < 1000; i++ ){
            l.agrega( new Object() );
        }
    }

    @Test
    public void noCaben1001Elementos(){
        String msg = " al insertar 1001 elementos ";
        try{
            Lista l = new Lista();
            for( int i = 0 ; i < 1001; i++ ){
                l.agrega( new Object() );
            }
            fail( "No se ha producido excepcion " + msg );
        }
        catch( IndexOutOfBoundsException e ){
            assertTrue( "La excepcion " + msg + " no deberia ser " + e, exactamenteIndexOutOfBounds(e) );
        }
    }
    
    @Test
    public void toStringDeListaVacia(){
        Lista l = new Lista();
        assertTrue( "toString de una lista vacia debe ser \"\" ", l.toString().trim().equals("") );
    }

    @Test
    public void toStringDeListaConUnElemento(){
        Lista l = new Lista();
        l.agrega( "Hola" );
        assertTrue( "toString de una lista con Hola debe ser Hola ", l.toString().trim().equals("Hola") );
    }

    @Test
    public void toStringDeListaConTresElementos(){
        Lista l = new Lista();
        l.agrega( "Hola" );
        l.agrega( "Que" );
        l.agrega( "Tal" );
        String regexp = " *Hola *, *Que *, *Tal *";
        assertTrue( "toString de una lista con Hola,Que,Tal debe ser Hola,Que,Tal", l.toString().matches(regexp) );
    }

}
