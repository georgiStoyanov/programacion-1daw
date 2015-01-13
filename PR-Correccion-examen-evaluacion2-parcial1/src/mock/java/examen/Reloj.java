package examen;

/**
 * @author PON AQUI TU NOMBRE
 */
public class Reloj{
	
    private int t = 0;
    
	/**
	 * Crea un reloj en la hora 00:00:00
	 */
	public Reloj(){
	}

	/**
 	 * Crea un reloj con horas, minutos y segundos especificados
	 */
	public Reloj( int horas, int minutos, int segundos ){
	    if( horas <0 || horas > 23 ) throw new IllegalArgumentException();
        if( minutos <0 || minutos > 59 ) throw new IllegalArgumentException();
        if( segundos <0 || segundos > 59 ) throw new IllegalArgumentException();
        t = horas*60*60 + minutos*60 + segundos;
	}

	/**
	 * @return 0 a 23
	 */
	public int getHoras(){
	    return t/(60*60);
	}

	/**
	 * @return 0 a 59
	 */
	public int getMinutos(){
	    return (t/60) % 60;
	}

	/**
	 * @return 0 a 59
	 */
	public int getSegundos(){
	    return t%60;
	}

	/**
	 * Avanza un segundo
	 */
	public void tick(){
	    t += 1;
	    t %= 60*60*24;
	}

	/**
	 * Avanza las horas, minutos y segundos especificados (cada uno no debe superar las 100 unidades, y no deben ser negativos)
	 */
	public void tick(int horas, int minutos, int segundos){
        if( horas <0 || horas > 100 ) throw new IllegalArgumentException();
        if( minutos <0 || minutos > 100 ) throw new IllegalArgumentException();
        if( segundos <0 || minutos > 100 ) throw new IllegalArgumentException();
        
        for( int s = 0 ; s < horas*60*60 + minutos*60 + segundos ; s++ ){
            tick();
        }
	}


	/**
	 * @returns La hora en formato HH:MM:SS
	 */
	@Override
	public String toString(){
		return String.format( "%02d:%02d:%02d", getHoras(), getMinutos(), getSegundos() );
	}	
}