package geometria;

public class Circulo {

    private double _radio;
    private Punto _centro;

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
        if (radio < 0) {
            throw new IllegalArgumentException("El radio es negativo:" + radio);
        }

        _radio = radio;
    }

    public double getArea() {
        return getRadio() * Math.PI * getRadio();
    }

    @Override
    public String toString() {
        return "Centro: " + getCentro() + "  radio : " + getRadio();
    }
}