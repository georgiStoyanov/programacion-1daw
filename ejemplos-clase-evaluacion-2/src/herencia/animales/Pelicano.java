package herencia.animales;

class Pelicano extends Ave {
	public Pelicano(String nombre) {
		super(nombre);
	}

	@Override
	public String getEspecie() {
		return " pelicano ";
	}

	public String colorDePlumas() {
		return " blanco ";
	}
}
