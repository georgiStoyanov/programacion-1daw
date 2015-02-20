package banco;

import java.util.Iterator;




/**
 * Objeto capaz de almacenar hasta 1000 objetos
 */
public class Lista<T> implements Iterable<T>{

    private Object[] array = new Object[1000];
    private int ultimo = -1;

    
    public Iterator<T> iterator(){
    	return new Iterator<T>(){
    		private int _porDondeVoy = 0;
			@Override
			public boolean hasNext() {
				return _porDondeVoy < getNumero();
			}

			@Override
			public T next() {
				_porDondeVoy += 1;
				return getObjeto(_porDondeVoy-1);
			}

			@Override
			public void remove() {
				throw new IllegalStateException();
			}
    		
    	};
    }
    
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
    public T getObjeto( int indice ) throws IndexOutOfBoundsException{
        compruebaIndice(indice);
        return (T)array[indice];
    }

    /**
     * Agrega un objeto al final de la lista. Si ya hay 1000 objetos almacenados, lanza una IndexOutOfBoundsException
     */
    public void agrega( T o ) throws IndexOutOfBoundsException{
        if( ultimo == array.length -1 ){
            throw new IndexOutOfBoundsException();
        }
        ultimo += 1;
        array[ultimo] = o;
    }
    
    /**
     * 
     * Busca con equals el objeto en la lista
     * @return El indice del objeto en la lista, o -1 si no esta contenido.
     */
    public int indiceDe( T o ){
        for (int index = 0; index < getNumero(); index+=1) {
            T elem = getObjeto(index);
            if( (o == null && elem == null) || o.equals(elem) ){
                return index;
            }
            
        }
        return -1;
    }

    /**
     * Borra un objeto de la lista. El hueco se rellena moviendo una unidad a la izquierda los objetos de indice mayor
     */
    public void borra( int indice ) throws IndexOutOfBoundsException{
        compruebaIndice(indice);
        for( int i = indice ; i < ultimo ; i+=1 ){
            array[i] = array[i+1];
        }
        ultimo -= 1;
    }

    /**
     * 
     * @param indice
     */
	private void compruebaIndice(int indice) {
		if( indice < 0 || indice >= getNumero() ){
            throw new IndexOutOfBoundsException();
        }
	}

    /**
     * Devuelve la conversion a cadena de objetos contenidos, separados por coma
     */
    @Override
    public String toString(){
        String ret = "";
        for( int i = 0 ; i < getNumero() ; i++ ){
            ret += String.valueOf( getObjeto(i) );
            if( i < getNumero() - 1 ){
                ret += " , ";
            }
        }
        return ret;
    }
    
    public static void main(String[] args) {
		Lista<String> lista = new Lista<String>();
		
		
		lista.agrega( "hola" );
		lista.agrega( "adios" );
		
		
		for( String s: lista ){
			System.out.println( s );
		}
	}
    
    
}




















