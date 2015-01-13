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

    @Test
    public void noDeberiaHaberAltosNegativos() {
        for (int i : VECES) {

            boolean exception = false;
            try {
                double alto = -Math.abs(random()) - 1;
                double ancho = 1;
                createRectangulo(createPunto(0, 0), alto, ancho);
            }
            catch (Exception e) {
                exception = true;
            }
            assertTrue("No deberia haber altos negativos", exception);
        }
    }

    @Test
    public void noDeberiaHaberAnchosNegativos() {
        for (int i : VECES) {
            boolean exception = false;
            try {
                double alto = 1;
                double ancho = -Math.abs(random()) - 1;
                createRectangulo(createPunto(0, 0), alto, ancho);
            }
            catch (Exception e) {
                exception = true;
            }
            assertTrue("No deberia haber anchos negativos", exception);
        }
    }

    @Test
    public void noSePueceCambiarAAnchosNegativos() {
        for (int i : VECES) {
            boolean exception = false;
            try {
                double alto = Math.abs(random());
                double ancho = Math.abs(random());
                Punto p = puntoRandom();
                Rectangulo r = createRectangulo(p, alto, ancho);
                double cambiado = -Math.abs(random()) - 1;
                r.setAncho(cambiado);
            }
            catch (Exception e) {
                exception = true;
            }
            assertTrue("No se deberia cambiar a anchos negativos", exception);
        }
    }

    @Test
    public void noSePueceCambiarAAltosNegativos() {
        for (int i : VECES) {
            boolean exception = false;
            try {
                double alto = Math.abs(random());
                double ancho = Math.abs(random());
                Punto p = puntoRandom();
                Rectangulo r = createRectangulo(p, alto, ancho);
                double cambiado = -Math.abs(random()) - 1;
                r.setAlto(cambiado);
            }
            catch (Exception e) {
                exception = true;
            }
            assertTrue("No se deberia cambiar a altos negativos", exception);
        }
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

            assertTrue("La primera esquina (topleft) de " + r + " deberia ser " + expected + ":" + esquinas[0],
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

            assertTrue("La segunda esquina (toprigth)  de " + r + " deberia ser " + expected + ":" + esquinas[1],
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

            assertTrue("La tercera esquina (bottomleft)  de " + r + " deberia ser " + expected + ":" + esquinas[2],
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

            assertTrue("La cuarta esquina (bottomrigth)  de " + r + " deberia ser " + expected + ":" + esquinas[3],
                    equals(expected, esquinas[3]));
        }
    }

    @Test
    public void conversionACadena() {
        for (int i : VECES) {
            double alto = Math.abs(random());
            double ancho = Math.abs(random());
            Punto p = puntoRandom();
            Rectangulo r = createRectangulo(p, alto, ancho);

            String regex = expresion(alto, ancho, p);

            assertTrue("La conversion a cadena no es correcta para " + alto + "," + ancho + "," + p + ":" + r, r
                    .toString()
                    .matches(regex));
        }
    }

    @Test
    public void conversionACadenaTrasCambioDeCentro() {
        for (int i : VECES) {
            double alto = Math.abs(random());
            double ancho = Math.abs(random());
            Punto p = puntoRandom();
            Rectangulo r = createRectangulo(p, alto, ancho);
            Punto cambiado = puntoRandom(p);
            r.setCentro(cambiado);

            String regex = expresion(alto, ancho, cambiado);

            assertTrue("La conversion a cadena no es correcta tras cambiar centro para " + alto + "," + ancho + ","
                    + cambiado + ":" + r, r
                    .toString()
                    .matches(regex));
        }
    }

    @Test
    public void conversionACadenaTrasCambioDeAlto() {
        for (int i : VECES) {
            double alto = Math.abs(random());
            double ancho = Math.abs(random());
            Punto p = puntoRandom();
            Rectangulo r = createRectangulo(p, alto, ancho);
            double cambiado = random(alto, true);
            r.setAlto(cambiado);

            String regex = expresion(cambiado, ancho, p);

            assertTrue("La conversion a cadena no es correcta tras cambiar alto para " + cambiado + "," + ancho + ","
                    + p + ":" + r, r
                    .toString()
                    .matches(regex));
        }
    }

    @Test
    public void conversionACadenaTrasCambioDeAncho() {
        for (int i : VECES) {
            double alto = Math.abs(random());
            double ancho = Math.abs(random());
            Punto p = puntoRandom();
            Rectangulo r = createRectangulo(p, alto, ancho);
            double cambiado = random(ancho, true);
            r.setAncho(cambiado);

            String regex = expresion(alto, cambiado, p);

            assertTrue("La conversion a cadena no es correcta tras cambiar ancho para " + alto + "," + cambiado + ","
                    + p + ":" + r, r
                    .toString()
                    .matches(regex));
        }
    }

    @Test
    public void area() {
        for (int i : VECES) {
            double alto = Math.abs(random());
            double ancho = Math.abs(random());
            Punto p = puntoRandom();
            Rectangulo r = createRectangulo(p, alto, ancho);
            double a = alto * ancho;
            double aAlumno = r.getArea();

            assertTrue("El area con " + alto + "," + ancho + " deberia ser " + a + ":" + aAlumno, equals(a, aAlumno));
        }
    }

    @Test
    public void areaTrasCambioAlto() {
        for (int i : VECES) {
            double alto = Math.abs(random());
            double ancho = Math.abs(random());
            Punto p = puntoRandom();
            Rectangulo r = createRectangulo(p, alto, ancho);
            double cambiado = random(alto, true);
            r.setAlto(cambiado);

            double a = cambiado * ancho;
            double aAlumno = r.getArea();

            assertTrue("El area con " + cambiado + "," + ancho + " deberia ser " + a + ":" + aAlumno,
                    equals(a, aAlumno));
        }
    }

    @Test
    public void areaTrasCambioAncho() {
        for (int i : VECES) {
            double alto = Math.abs(random());
            double ancho = Math.abs(random());
            Punto p = puntoRandom();
            Rectangulo r = createRectangulo(p, alto, ancho);
            double cambiado = random(ancho, true);
            r.setAncho(cambiado);

            double a = alto * cambiado;
            double aAlumno = r.getArea();

            assertTrue("El area con " + alto + "," + cambiado + " deberia ser " + a + ":" + aAlumno,
                    equals(a, aAlumno));
        }
    }

    private String expresion(double alto, double ancho, Punto p) {
        double x1 = p.getX() - ancho / 2;
        double y1 = p.getY() + alto / 2;
        double x2 = p.getX() + ancho / 2;
        double y2 = p.getY() - alto / 2;
        String regex = "(?i)" +
                ".*arriba.*izquierda.*:.*" +
                ".*\\(.*" + x1 + ".*,.*" + y1 + ".*\\).*" +
                ".*abajo.*derecha.*:.*" +
                ".*\\(.*" + x2 + ".*,.*" + y2 + ".*\\).*";
        return regex;
    }

}
