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
}
