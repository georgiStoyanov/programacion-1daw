package geometria;




public class Rectangulo {


	private Punto centro;
	private double alto, ancho;
	
	public Punto getCentro() {
		return centro;
	}

	public Rectangulo(Punto centro, double alto, double ancho) {
		this.setCentro(centro);
		this.setAlto(alto);
		this.setAncho(ancho);
	}

	public void setCentro(Punto centro) {
		this.centro = centro;
	}

	public double getAlto() {
		return alto;
	}

	public void setAlto(double alto) {
		if( alto < 0 ){
			throw new IllegalArgumentException();
		}
		this.alto = alto;
	}

	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		if( ancho < 0 ){
			throw new IllegalArgumentException();
		}
		this.ancho = ancho;
	}

    public Punto[] getEsquinas() {
    	double x = getCentro().getX();
    	double y = getCentro().getY();
    	double dx = getAncho()/2;
    	double dy = getAlto()/2;
    	return new Punto[]{
    		new Punto( x - dx, y + dy ),
    		new Punto( x + dx, y + dy ),
    		new Punto( x - dx, y - dy ),
    		new Punto( x + dx, y - dy )
    	};
    }

    public double getArea() {
    	return getAlto() * getAncho();
    }
    
    @Override
    public String toString() {
    	Punto[] esquinas = getEsquinas();
		return "arribaizquierda: " + esquinas[0] +" abajoderecha: " + esquinas[3];
    }
    
}