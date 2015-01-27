package banco;


/**
 * Objeto capaz de almacenar hasta 1000 objetos
 */
public class Lista{

    private Object[] array = new Object[1000];
    private int ultimo = -1;

    /**
     * Se crea inicialmente vacia
     */
    public Lista(){
    }

    /**
     * Numero de objetos actualmente almacenados
     */
    public int getNumero(){
        return ultimo + 1;
    }

    /**
     * Devuelve el objeto almacenado en la posicion indicada.
     * Si la posicion no es valida (entre 0 y numero()-1), lanza un IndexOutOfBoundsException
     */
    public Object getObjeto( int indice ) throws IndexOutOfBoundsException{
        if( indice < 0 || indice > ultimo ){
            throw new IndexOutOfBoundsException();
        }
        return array[indice];
    }

    /**
     * Agrega un objeto al final de la lista. Si ya hay 1000 objetos almacenados, lanza una IndexOutOfBoundsException
     */
    public void agrega( Object o ) throws IndexOutOfBoundsException{
        if( ultimo == array.length -1 ){
            throw new IndexOutOfBoundsException();
        }
        ultimo += 1;
        array[ultimo] = o;
    }

    /**
     * Borra un objeto de la lista. El hueco se rellena moviendo una unidad a la izquierda los objetos de indice mayor
     */
    public void borra( int indice ) throws IndexOutOfBoundsException{
        if( indice < 0 || indice > ultimo ){
            throw new IndexOutOfBoundsException();
        }
        for( int i = indice ; i < ultimo ; i++ ){
            array[i] = array[i+1];
        }
        ultimo -= 1;
    }

    /**
     * Devuelve la conversion a cadena de objetos contenidos, separados por coma
     */
    @Override
    public String toString(){
        String ret = "";
        for( int i = 0 ; i < getNumero() ; i++ ){
            ret += getObjeto(i).toString();
            if( i < getNumero() - 1 ){
                ret += " , ";
            }
        }
        return ret;
    }
}
