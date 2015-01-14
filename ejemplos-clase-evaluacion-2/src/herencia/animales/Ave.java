package herencia.animales;

abstract class Ave extends Animal {
	public Ave(String nombre) {
		super(nombre);
	}

	@Override
	public boolean vuela() {
		return true;
	}
	
	@Override
	public boolean sangreCaliente() {
		return true;
	}

	@Override
	public boolean oviparo() {
		return true;
	}

	public abstract String colorDePlumas();
	
	@Override
	public String toString() {
		return super.toString() + ", plumas:" + colorDePlumas();
	}
}
