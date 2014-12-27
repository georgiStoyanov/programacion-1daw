package geometria;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class RectanguloTest {

    private static final int[] VECES = new int[100];
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

    private static Punto createPunto() {
        return new Punto();
    }

    private static Punto createPunto(double x, double y) {
        return new Punto(x, y);
    }

    private Rectangulo createRectangulo(Punto p, double alto, double ancho) {
        return new Rectangulo(p, alto, ancho);
    }

    private static double random(double distinto) {
        return random(distinto, false);
    }

    private static Punto puntoRandom() {
        return createPunto(random(), random());
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
    public void noDeberiaHaberAltosNegativos() {
        double alto = -Math.abs(random()) - 1;
        double ancho = 1;
        createRectangulo(createPunto(0, 0), alto, ancho);
    }

    @Test(expected = Exception.class)
    public void noDeberiaHaberAnchosNegativos() {
        double alto = 1;
        double ancho = -Math.abs(random()) - 1;
        createRectangulo(createPunto(0, 0), alto, ancho);
    }

    @Test
    public void creacionDeRectanguloCentro() {
        for (int i : VECES) {
            double alto = Math.abs(random());
            double ancho = Math.abs(random());
            Punto p = puntoRandom();
            Rectangulo r = createRectangulo(p, alto, ancho);
            assertTrue("El rectangulo se creo con el centro en " + p + ":" + r.getCentro(), equals(p, r.getCentro()));
        }
    }

    @Test
    public void creacionDeRectanguloAlto() {
        for (int i : VECES) {
            double alto = Math.abs(random());
            double ancho = Math.abs(random());
            Punto p = puntoRandom();
            Rectangulo r = createRectangulo(p, alto, ancho);
            assertTrue("El rectangulo se creo con alto " + alto + ":" + r.getAlto(), equals(alto, r.getAlto()));
        }
    }

    @Test
    public void creacionDeRectanguloAncho() {
        for (int i : VECES) {
            double alto = Math.abs(random());
            double ancho = Math.abs(random());
            Punto p = puntoRandom();
            Rectangulo r = createRectangulo(p, alto, ancho);
            assertTrue("El rectangulo se creo con ancho " + ancho + ":" + r.getAncho(), equals(ancho, r.getAncho()));
        }
    }

    @Test
    public void cambioDeCentro() {
        for (int i : VECES) {
            double alto = Math.abs(random());
            double ancho = Math.abs(random());
            Punto p = puntoRandom();
            Rectangulo r = createRectangulo(p, alto, ancho);

            Punto cambiado = puntoRandom(p);
            r.setCentro(cambiado);

            assertTrue("Se cambio el centro a " + cambiado + ":" + r.getCentro(), equals(cambiado, r.getCentro()));
        }
    }

    @Test
    public void cambioDeAlto() {
        for (int i : VECES) {
            double alto = Math.abs(random());
            double ancho = Math.abs(random());
            Punto p = puntoRandom();
            Rectangulo r = createRectangulo(p, alto, ancho);

            double cambiado = Math.abs(random(alto));
            r.setAlto(cambiado);

            assertTrue("Se cambio el alto a " + cambiado + ":" + r.getAlto(), equals(cambiado, r.getAlto()));
        }
    }

    @Test
    public void cambioDeAncho() {
        for (int i : VECES) {
            double alto = Math.abs(random());
            double ancho = Math.abs(random());
            Punto p = puntoRandom();
            Rectangulo r = createRectangulo(p, alto, ancho);

            double cambiado = Math.abs(random(ancho));
            r.setAncho(cambiado);

            assertTrue("Se cambio el ancho a " + cambiado + ":" + r.getAncho(), equals(cambiado, r.getAncho()));
        }
    }

    @Test
    public void lasEsquinasSonCuatro() {
        for (int i : VECES) {
            double alto = Math.abs(random());
            double ancho = Math.abs(random());
            Punto p = puntoRandom();
            Rectangulo r = createRectangulo(p, alto, ancho);

            Punto[] esquinas = r.getEsquinas();

            assertTrue("Se esperan cuatro esquinas:" + esquinas.length, esquinas.length == 4);
        }
    }

    @Test
    public void esquinaTopLeft() {
        for (int i : VECES) {
            double alto = Math.abs(random());
            double ancho = Math.abs(random());
            Punto p = puntoRandom();
            Rectangulo r = createRectangulo(p, alto, ancho);

            Punto[] esquinas = r.getEsquinas();
            Punto expected = createPunto(p.getX() - ancho / 2, p.getY() + alto / 2);

            assertTrue("La primera esquina (topleft) deberia ser " + expected + ":" + esquinas[0],
                    equals(expected, esquinas[0]));
        }
    }

    @Test
    public void esquinaTopRigth() {
        for (int i : VECES) {
            double alto = Math.abs(random());
            double ancho = Math.abs(random());
            Punto p = puntoRandom();
            Rectangulo r = createRectangulo(p, alto, ancho);

            Punto[] esquinas = r.getEsquinas();
            Punto expected = createPunto(p.getX() + ancho / 2, p.getY() + alto / 2);

            assertTrue("La segunda esquina (toprigth) deberia ser " + expected + ":" + esquinas[1],
                    equals(expected, esquinas[1]));
        }
    }

    @Test
    public void esquinaBottomLeft() {
        for (int i : VECES) {
            double alto = Math.abs(random());
            double ancho = Math.abs(random());
            Punto p = puntoRandom();
            Rectangulo r = createRectangulo(p, alto, ancho);

            Punto[] esquinas = r.getEsquinas();
            Punto expected = createPunto(p.getX() - ancho / 2, p.getY() - alto / 2);

            assertTrue("La tercera esquina (bottomleft) deberia ser " + expected + ":" + esquinas[2],
                    equals(expected, esquinas[2]));
        }
    }

    @Test
    public void esquinaBottomRigth() {
        for (int i : VECES) {
            double alto = Math.abs(random());
            double ancho = Math.abs(random());
            Punto p = puntoRandom();
            Rectangulo r = createRectangulo(p, alto, ancho);

            Punto[] esquinas = r.getEsquinas();
            Punto expected = createPunto(p.getX() + ancho / 2, p.getY() - alto / 2);

            assertTrue("La cuarta esquina (bottomrigth) deberia ser " + expected + ":" + esquinas[3],
                    equals(expected, esquinas[3]));
        }
    }

}
