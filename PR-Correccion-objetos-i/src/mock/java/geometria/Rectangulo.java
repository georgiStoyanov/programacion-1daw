package geometria;

public class Rectangulo {

    private Punto _centro;
    private double _alto;
    private double _ancho;

    public Rectangulo(Punto centro, double alto, double ancho) {
        setCentro(centro);
        setAlto(alto);
        setAncho(ancho);
    }

    public Punto getCentro() {
        return _centro;
    }

    public void setCentro(Punto p) {
        _centro = p;
    }

    public double getAlto() {
        return _alto;
    }

    public void setAlto(double alto) {
        if( alto < 0 ){
            throw new IllegalArgumentException( "alto negativo:" + alto );
        }
        _alto = alto;
    }

    public double getAncho() {
        return _ancho;
    }

    public void setAncho(double ancho) {
        if( ancho < 0 ){
            throw new IllegalArgumentException( "ancho negativo:" + ancho );
        }
        _ancho = ancho;
    }

    public Punto[] getEsquinas() {
        Punto c = getCentro();
        double x = c.getX();
        double y = c.getY();
        double al = getAlto()/2;
        double an = getAncho()/2;
        return new Punto[]{
                new Punto( x - an, y + al ),
                new Punto( x + an, y + al),
                new Punto( x - an, y - al),
                new Punto( x + an, y - al),
        };
    }

    public double getArea() {
        return getAlto() * getAncho();
    }
    
    @Override
    public String toString() {
        Punto[] esquinas = getEsquinas();
        Punto ari = esquinas[0];
        Punto abd = esquinas[3];
        return "arribaizquierda:" + ari + " abajoderecha:" + abd;
    }
}