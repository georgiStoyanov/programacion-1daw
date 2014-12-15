public class CuentaKilometros {

	private double kilometrosTotales;
	private double kilometrosParciales;

	
	public CuentaKilometros(){
		kilometrosParciales = 0;
		kilometrosTotales = 0;
	}
	
	public static int comparar( CuentaKilometros ck1, CuentaKilometros ck2 ){
		
		double kilometraje1 = ck1.getTotalKilometros() + ck1.getTotalHectometros()/10;
		double kilometraje2 = ck2.getTotalKilometros() + ck2.getTotalHectometros()/10;
		
		if( kilometraje1 < kilometraje2 ){
			return -1;
		}
		else if( kilometraje1 == kilometraje2 ){
			return 0;
		}
		else{
			return 1;
		}
	}
	
	public boolean esMenorQue( CuentaKilometros ck ){
		return comparar(this,ck) == -1;
	}
	
	/**
	 * Se tiene en cuenta que los kilomentros no son negativos, y los hectometros
	 * estan entre 0 y 9
	 * @param kilometros
	 * @param hectometros
	 */
	public CuentaKilometros( int kilometros, int hectometros ){
		kilometrosParciales = 0;
		if( hectometros < 0 || hectometros > 9 ){
			throw new IllegalArgumentException("hectometros:" + hectometros );
		}
		if( kilometros < 0 ){
			throw new IllegalArgumentException("kilometros:" + kilometros );
		}
		kilometrosTotales = (double)kilometros + ((double)hectometros)/10;
	}
	
	public static void printf(String format, Object... args) {
		System.out.printf(format + "\n", args);
	}

	public static void main(String[] args) {
		CuentaKilometros ck = new CuentaKilometros(0,0);

		printf("hay que empezar por 0,0:" + ck );

		ck.addKilometros(0.01);

		printf("hay que seguir con 0,0:" + ck);

		for (int i = 0; i < 110; i++) {
			ck.addKilometros(0.01);
		}

		printf("hay que seguir con total 1,1" + ck);
		printf("hay que seguir con parcial 1,1:" + ck);

		ck.resetearParcial();

		printf("hay que seguir con total 1,1:" + ck);
		printf("hay que seguir con parcial 0,0:" + ck);
	}

	@Override
	public String toString() {
		return String.format("Total:%d,%d  Parcial:%d,%d",
				getTotalKilometros(), getTotalHectometros(),
				getParcialKilometros(), getParcialHectometros());
	}


	private void resetearParcial() {
		kilometrosParciales = 0;
	}

	private int getParcialHectometros() {
		return dameElPrimerDecimal(kilometrosParciales);
	}

	private int dameElPrimerDecimal(double d) {
		return ((int) (d * 10)) % 10;
	}

	private int getParcialKilometros() {
		return (int) Math.floor(kilometrosParciales);
	}

	private void addKilometros(double kilometros) {
		if( kilometros < 0 ){
			throw new IllegalArgumentException( "No se puede:" + kilometros );
		}
		kilometrosParciales += kilometros;
		kilometrosTotales += kilometros;
	}

	private int getTotalHectometros() {
		return dameElPrimerDecimal(kilometrosTotales);
	}

	private int getTotalKilometros() {
		return (int) Math.floor(kilometrosTotales);
	}
}
