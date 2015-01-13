package geometria;


public class Circulo {

	private Punto _centro;
	private double _radio;

    public Circulo(Punto centro, double radio) {
    	setCentro(centro);
    	setRadio(radio);
    }

    public Punto getCentro() {
    	return _centro;
    }

    public void setCentro(Punto p) {
    	_centro = p;
    }

    public double getRadio() {
    	return _radio;
    }

    public void setRadio(double radio) {
    	if( radio < 0 ){
    		throw new IllegalArgumentException();
    	}
    	_radio = radio;
    }

    public double getArea() {
    	return Math.PI * getRadio()*getRadio();
    }

    @Override
    public String toString() {
    	return "centro:" + getCentro() + " radio:" + getRadio();
    }
}