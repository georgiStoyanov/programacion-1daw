package herencia.animales;

public abstract class Animal {
	private String nombre;

	public Animal(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public abstract String getEspecie();

	public abstract boolean vuela();

	public abstract boolean sangreCaliente();

	public abstract boolean oviparo();

	public final boolean sangreFria() {
		return !sangreCaliente();
	}

	public final boolean viviparo() {
		return !oviparo();
	}

	@Override
	public String toString() {
		return String.format(" %s : vuela: %b , caliente: %b , oviparo: %b ",
				getNombre(), vuela(), sangreCaliente(), oviparo());
	}

	@Override
	public boolean equals(Object o) {

		
		if (!(o instanceof Animal)) {
			// Un animal no puede ser igual a un objeto que no sea animal
			return false;
		}
		
		Animal animal = (Animal) o; // Funciona porque nos hemos asegurado que
									// es un Animal
		boolean mismoNombre = animal.getNombre().equals(getNombre());
		boolean mismaEspecie = animal.getEspecie().equals(getEspecie());
		return mismoNombre && mismaEspecie;
	}
}
