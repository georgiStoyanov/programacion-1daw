package geometria;

public class Punto {

    private double _x;
    private double _y;

    public Punto() {
    }

    public Punto(double x, double y) {
        _x = x;
        _y = y;

    }

    public double getX() {
        return _x;

    }

    public double getY() {
        return _y;

    }

    public double distanciaHasta(Punto p) {
        double dx = getX() - p.getX();
        double dy = getY() - p.getY();
        return Math.sqrt(dx * dx + dy * dy);

    }

    public Punto suma(Punto p) {
        return new Punto(p.getX() + getX(), p.getY() + getY());
    }

    @Override
    public String toString() {
        return "(" + getX() + " , " + getY() + ")";
    }
}
