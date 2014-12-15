package geometria;

import static org.junit.Assert.*;

import org.junit.Test;

public class RectanguloTest {

	
	private static boolean equals( double d1, double d2 ){
		return Math.abs(d1-d2) < 0.00001;
	}

	private static boolean equals( Punto d1, Punto d2 ){
		return equals(d1.getX(),d2.getX()) && equals(d1.getY(),d2.getY());
	}

	private static double random(){
		return (int)(Math.random()*100)/10-5;
	}

	private static double random(double distinto,boolean positivo){
		while( true ){
			double ret = random();
			if( positivo ){
				ret = Math.abs(ret);
			}
			if( !equals(ret,distinto) ){
				return ret;
			}
		}
	}
	
	private static double random(double distinto){
		return random(distinto,false);
	}
	private static Punto puntoRandom(){
		return new Punto(random(),random());
	}

	private static Punto puntoRandom(Punto distinto){
		while( true ){
			Punto ret = puntoRandom();
			if( !equals( ret.getX(), distinto.getX() ) ){
				return ret;
			}
			if( !equals( ret.getY(), distinto.getY() ) ){
				return ret;
			}
		}
	}
	
	@Test(expected = Exception.class)
	public void noDeberiaHaberAltosNegativos(){
		double alto = -Math.abs(random());
		double ancho = 1;
		new Rectangulo( new Punto(0,0), alto, ancho );
	}
	
	@Test(expected = Exception.class)
	public void noDeberiaHaberAnchosNegativos(){
		double alto = 1;
		double ancho = -Math.abs(random());
		new Rectangulo( new Punto(0,0), alto, ancho );
	}
	
	@Test
	public void creacionDeRectanguloCentro(){
		double alto = Math.abs(random());
		double ancho = Math.abs(random());
		Punto p = puntoRandom();
		Rectangulo r = new Rectangulo(p,alto,ancho);
		assertTrue( "El rectangulo se creo con el centro en " + p + ":" + r.getCentro(), equals(p,r.getCentro()));
	}
	
	@Test
	public void creacionDeRectanguloAlto(){
		double alto = Math.abs(random());
		double ancho = Math.abs(random());
		Punto p = puntoRandom();
		Rectangulo r = new Rectangulo(p,alto,ancho);
		assertTrue( "El rectangulo se creo con alto " + alto + ":" + r.getAlto(), equals(alto,r.getAlto()));
	}

	@Test
	public void creacionDeRectanguloAncho(){
		double alto = Math.abs(random());
		double ancho = Math.abs(random());
		Punto p = puntoRandom();
		Rectangulo r = new Rectangulo(p,alto,ancho);
		assertTrue( "El rectangulo se creo con ancho " + ancho + ":" + r.getAncho(), equals(ancho,r.getAncho()));
	}
	
}
