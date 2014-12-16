package examen;

/**
 * @author PON AQUI TU NOMBRE
 */
public class Reloj{
	
	/**
	 * Crea un reloj en la hora 00:00:00
	 */
	public Reloj(){
		throw new UnsupportedOperationException("Por hacer");
	}

	/**
 	 * Crea un reloj con horas, minutos y segundos especificados
	 */
	public Reloj( int horas, int minutos, int segundos ){
		throw new UnsupportedOperationException("Por hacer");
	}

	/**
	 * @return 0 a 23
	 */
	public int getHoras(){
		throw new UnsupportedOperationException("Por hacer");
	}

	/**
	 * @return 0 a 59
	 */
	public int getMinutos(){
		throw new UnsupportedOperationException("Por hacer");
	}

	/**
	 * @return 0 a 59
	 */
	public int getSegundos(){
		throw new UnsupportedOperationException("Por hacer");
	}

	/**
	 * @param horas 0 a 23
	 * @throws InvalidArgumentException
	 */
	public void setHoras(int horas){
		throw new UnsupportedOperationException("Por hacer");
	}

	/**
	 * @param minutos 0 a 59
	 * @throws InvalidArgumentException
	 */
	public void setMinutos(int minutos){
		throw new UnsupportedOperationException("Por hacer");
	}

	/**
	 * @param segundos 0 a 59
	 * @throws InvalidArgumentException
	 */
	public void setSegundos(int segundos){
		throw new UnsupportedOperationException("Por hacer");
	}

	/**
	 * Avanza un segundo
	 */
	public void tick(){
		throw new UnsupportedOperationException("Por hacer");
	}

	/**
	 * Avanza las horas, minutos y segundos especificados (cada uno no debe superar las 100 unidades, y no deben ser negativos)
	 */
	public void tick(int horas, int minutos, int segundos){
		throw new UnsupportedOperationException("Por hacer");
	}


	/**
	 * @returns La hora en formato HH:MM:SS
	 */
	@Override
	public String toString(){
		throw new UnsupportedOperationException("Por hacer");
	}	
}