package geometria;

import static org.junit.Assert.*;
import geometria.mock.IPunto;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class PuntoTest {

    @Rule
    public Timeout globalTimeout = new Timeout(10000);

    private static boolean equals(double d1, double d2) {
	return Math.abs(d1 - d2) < 0.00001;
    }

    private static double random() {
	return (int) (Math.random() * 100) / 10 - 5;
    }

    @Test
    public void porDefectoEnOrigenX() {
	IPunto p = IPunto.createPunto();
	assertTrue("Un punto por defecto tiene y=0:" + p.getY(), equals(p.getY(), 0));
    }

    @Test
    public void porDefectoEnOrigenY() {
	IPunto p = IPunto.createPunto();
	assertTrue("Un punto por defecto tiene y=0:" + p.getY(), equals(p.getY(), 0));
    }

    @Test
    public void construirConX() {
	double x = random();
	IPunto p = IPunto.createPunto(x, 0);
	assertTrue("Lo he construido con x=" + x + ":" + p.getX(), equals(p.getX(), x));
    }

    @Test
    public void construirConY() {
	double y = random();
	IPunto p = IPunto.createPunto(0, y);
	assertTrue("Lo he construido con y=" + y + ":" + p.getX(), equals(p.getY(), y));
    }

    @Test
    public void conversionACadena() {
	double x = random();
	double y = random();
	IPunto p = IPunto.createPunto(x, y);
	String regex = ".*\\(.*" + x + ".*,.*" + y + ".*\\).*";
	assertTrue("El punto en " + x + "," + y + " tiene representacion en cadena:" + p, p.toString().matches(regex));
    }

    @Test
    public void distanciaConOrigen() {
	double x = random();
	double y = random();
	IPunto p = IPunto.createPunto(x, y);
	double d = Math.sqrt(x * x + y * y);
	double dAlumno = IPunto.createPunto().distanciaHasta(p);
	assertTrue(p + " deberia distar del origen " + d + ":" + dAlumno, equals(d, dAlumno));
    }

    @Test
    public void distanciaConOtroPunto() {
	double x1 = random();
	double y1 = random();
	double x2 = random();
	double y2 = random();
	IPunto p1 = IPunto.createPunto(x1, y1);
	IPunto p2 = IPunto.createPunto(x2, y2);
	double x = x1 - x2;
	double y = y1 - y2;
	double d = Math.sqrt(x * x + y * y);
	double dAlumno = p1.distanciaHasta(p2);
	assertTrue(p1 + " deberia distar de " + p2 + " " + d + ":" + dAlumno, equals(d, dAlumno));
    }

    @Test
    public void sumarDosPuntosX() {
	double x1 = random();
	double y1 = random();
	double x2 = random();
	double y2 = random();
	IPunto p1 = IPunto.createPunto(x1, y1);
	IPunto p2 = IPunto.createPunto(x2, y2);
	IPunto suma = p1.suma(p2);
	assertTrue("La X de " + p1 + "+" + p2 + " deberia ser " + (x1 + x2) + ":" + suma.getX(),
		equals(suma.getX(), x1 + x2));
    }

    @Test
    public void sumarDosPuntosY() {
	double x1 = random();
	double y1 = random();
	double x2 = random();
	double y2 = random();
	IPunto p1 = IPunto.createPunto(x1, y1);
	IPunto p2 = IPunto.createPunto(x2, y2);
	IPunto suma = p1.suma(p2);
	assertTrue("La Y de " + p1 + "+" + p2 + " deberia ser " + (y1 + y2) + ":" + suma.getX(),
		equals(suma.getY(), y1 + y2));
    }

}
