package geometria.mock;

public class IPunto {

    public static IPunto createPunto() {
	return new IPunto();
    }

    public static IPunto createPunto(double x, double y) {
	return new IPunto(x, y);
    }

    public IPunto() {
    }

    private IPunto(double x, double y) {

    }

    public double getX() {
	return 0;

    }

    public double getY() {
	return 0;

    }

    public double distanciaHasta(IPunto p) {
	return 0;

    }

    public IPunto suma(IPunto p) {
	return null;

    }
}
