package examen;

public class Reloj {

	private int segundosDelDia;
	public Reloj(){
		segundosDelDia = 0;
	}
	
	public Reloj(int horas, int minutos, int segundos ) {
		if( horas < 0 || horas > 23 ){
			throw new IllegalArgumentException();
		}
		if( minutos < 0 || minutos > 59 ){
			throw new IllegalArgumentException();
		}
		if( segundos < 0 || segundos > 59 ){
			throw new IllegalArgumentException();
		}
		segundosDelDia = horas*60*60 + minutos*60 + segundos;
	}
	
	
	public int getHoras(){
		return segundosDelDia/(60*60);
	}
	
	public int getMinutos(){
		return (segundosDelDia/60) % 60;
	}
	
	public int getSegundos(){
		return segundosDelDia % 60;
	}
	
	public void tick() {
		segundosDelDia += 1;
		segundosDelDia %= 24*60*60;
	}
	
	public void tick(int horas, int minutos, int segundos ) {
		int totalSegundos = horas*60*60 + minutos*60 + segundos;
		for( int i = 0 ; i < totalSegundos ; i+= 1){
			tick();
		}
	}
	
	@Override
	public String toString() {
		return String.format( "%02d:%02d:%02d", getHoras(), getMinutos(),getSegundos() );
	}
	
}
