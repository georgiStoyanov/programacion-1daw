package fecha;

public class Calendario {
	
	private int _dia, _mes, _año;
	
	public Calendario(){
		_dia = 1;
		_mes = 1;
		_año = 2000;
		
	}
	public void avanzaDia(){
		int rotarElDiaCuando = diasDelMes(_mes);
		
		_dia += 1;
		if( _dia > rotarElDiaCuando ){
			_dia = 1;
			_mes += 1;
		}
		
		if( _mes == 13 ){
			_mes = 1;
			_año += 1;
		}
	}
	
	static private final int DIAS_DEL_MES[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	private int diasDelMes(int mes) {
		return DIAS_DEL_MES[mes-1];
	}
	
	
	
	@Override
	public String toString() {
		return String.format("%02d/%02d/%d", _dia, _mes, _año );
	}
	
	public static void main(String[] args) {
		Calendario c = new Calendario();
		
		for( int i = 0 ; i < 365*2 ; i += 1 ){
			System.out.println( c );
			c.avanzaDia();
		}
		
	}
}
