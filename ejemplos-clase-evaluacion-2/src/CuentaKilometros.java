public class CuentaKilometros {

	public static void printf(String format, Object... args) {
		System.out.printf(format, args);
	}

	public static void main(String[] args) {
		CuentaKilometros ck = new CuentaKilometros();

		printf("hay que empezar por 0,0: %d,%d", 
				ck.getTotalKilometros(), ck.getTotalHectometros());

		ck.addKilometros(0.01);

		printf("hay que seguir con 0,0: %d,%d", 
				ck.getTotalKilometros(), ck.getTotalHectometros());

		for (int i = 0; i < 100; i++) {
			ck.addKilometros(0.01);
		}

		printf("hay que seguir con total 0,1: %d,%d", 
				ck.getTotalKilometros(), ck.getTotalHectometros());
		printf("hay que seguir con parcial 0,1: %d,%d",
				ck.getParcialKilometros(), ck.getParcialHectometros());

		ck.resetearParcial();

		printf("hay que seguir con total 0,1: %d,%d", 
				ck.getTotalKilometros(), ck.getTotalHectometros());
		printf("hay que seguir con parcial 0,0: %d,%d",
				ck.getParcialKilometros(), ck.getParcialHectometros());
	}
}
