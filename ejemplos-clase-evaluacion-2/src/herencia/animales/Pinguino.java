package herencia.animales;

class Pinguino extends Ave {
	public Pinguino(String nombre) {
		super(nombre);
	}

	@Override
	public boolean vuela() {
		return false;
	}

	@Override
	public String getEspecie() {
		return " pinguino ";
	}

	public String colorDePlumas() {
		return " negro y blanco ";
	}
}
