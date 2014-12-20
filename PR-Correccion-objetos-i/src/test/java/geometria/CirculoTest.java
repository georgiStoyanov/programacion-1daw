package geometria;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class CirculoTest {

    @Rule
    public Timeout globalTimeout = new Timeout(10000); 

    private static boolean equals(double d1, double d2) {
	return Math.abs(d1 - d2) < 0.00001;
    }

    private static boolean equals(Punto d1, Punto d2) {
	return equals(d1.getX(), d2.getX()) && equals(d1.getY(), d2.getY());
    }

    private static double random() {
	return (int) (Math.random() * 100) / 10 - 5;
    }

    private static double random(double distinto, boolean positivo) {
	while (true) {
	    double ret = random();
	    if (positivo) {
		ret = Math.abs(ret);
	    }
	    if (!equals(ret, distinto)) {
		return ret;
	    }
	}
    }

    private static double random(double distinto) {
	return random(distinto, false);
    }

    private static Punto puntoRandom() {
	return new Punto(random(), random());
    }

    private static Punto puntoRandom(Punto distinto) {
	while (true) {
	    Punto ret = puntoRandom();
	    if (!equals(ret.getX(), distinto.getX())) {
		return ret;
	    }
	    if (!equals(ret.getY(), distinto.getY())) {
		return ret;
	    }
	}
    }

    @Test(expected = Exception.class)
    public void noDeberiaHaberRadiosNegativos() {
	double r = -Math.abs(random());
	new Circulo(new Punto(0, 0), r);
    }

    @Test
    public void creacionDeCirculoCentro() {
	double r = Math.abs(random());
	Punto p = puntoRandom();
	Circulo c = new Circulo(p, r);
	assertTrue("El circulo se creo con el centro en " + p + ":" + c.getCentro(), equals(p, c.getCentro()));
    }

    @Test
    public void cambioDeCentro() {
	double r = Math.abs(random());
	Punto p = puntoRandom();
	Circulo c = new Circulo(p, r);
	Punto cambiado = puntoRandom(p);
	c.setCentro(cambiado);
	assertTrue("El circulo se cambio a centro " + cambiado + ":" + c.getCentro(), equals(cambiado, c.getCentro()));
    }

    @Test
    public void creacionDeCirculoRadio() {
	double r = Math.abs(random());
	Punto p = puntoRandom();
	Circulo c = new Circulo(p, r);
	assertTrue("El circulo se creo con radio " + r + ":" + c.getRadio(), equals(r, c.getRadio()));
    }

    @Test
    public void cambioDeRadio() {
	double r = Math.abs(random());
	Punto p = puntoRandom();
	Circulo c = new Circulo(p, r);
	double cambiado = random(r, true);
	c.setRadio(cambiado);
	assertTrue("El circulo se cambio a radio " + cambiado + ":" + c.getRadio(), equals(cambiado, c.getRadio()));
    }

    private String expresion(double x, double y, double r) {
	String regex = "(?i).*Centro.*:.*" +
		".*\\(.*" + x + ".*,.*" + y + ".*\\).*" +
		".*Radio.*:.*" + r;
	return regex;
    }

    @Test
    public void conversionACadena() {
	double x = random();
	double y = random();
	double r = Math.abs(random());

	Circulo c = new Circulo(new Punto(x, y), r);

	String regex = expresion(x, y, r);

	assertTrue("La conversion a cadena no es correcta para " + x + "," + y + "," + r + ":" + c, c.toString()
		.matches(regex));
    }

    @Test
    public void conversionACadenaTrasCambioDeRadio() {
	double x = random();
	double y = random();
	double r = Math.abs(random());

	Circulo c = new Circulo(new Punto(x, y), r);
	double cambiado = random(r, true);
	c.setRadio(cambiado);

	String regex = expresion(x, y, cambiado);

	assertTrue("La conversion a cadena no es correcta tras cambiar radio para " + x + "," + y + "," + cambiado
		+ ":" + c, c.toString().matches(regex));
    }

    @Test
    public void conversionACadenaTrasCambioDeCentro() {
	double x = random();
	double y = random();
	double r = random();

	Punto p = new Punto(x, y);
	Circulo c = new Circulo(p, r);
	Punto cambiado = puntoRandom(p);
	c.setCentro(cambiado);

	String regex = expresion(p.getX(), p.getY(), r);

	assertTrue("La conversion a cadena no es correcta tras cambiar centro para " + x + "," + y + "," + cambiado
		+ ":" + c, c.toString().matches(regex));
    }

    @Test
    public void area() {
	double r = random();
	Circulo c = new Circulo(puntoRandom(), r);
	double a = Math.PI * r * r;
	double aAlumno = c.getArea();

	assertTrue("El area con radio " + r + " deberia ser " + a + ":" + aAlumno, equals(a, aAlumno));
    }

    @Test
    public void areaTrasCambioDeRadio() {
	double r = random();
	Circulo c = new Circulo(puntoRandom(), r);
	double cambiado = random(r, true);
	c.setRadio(cambiado);
	double a = Math.PI * cambiado * cambiado;
	double aAlumno = c.getArea();

	assertTrue("El area tras cambiar radio radio a " + cambiado + " deberia ser " + a + ":" + aAlumno,
		equals(a, aAlumno));
    }

}
