package geometria.mock;


public class IRectangulo{


	public static IRectangulo createRectangulo(IPunto centro, double alto, double ancho) {
	return new IRectangulo(centro, alto, ancho);
    }

	private IRectangulo(IPunto centro, double alto, double ancho){
	}

	public IPunto getCentro(){
		return null;
	}

	public void setCentro( IPunto p ){
	}
	
	public double getAlto(){
		return 0;
	}

	public void setAlto( double alto ){
	}

	public double getAncho(){
		return 0;
	}

	public void setAncho( double ancho ){
	}

	public IPunto[] getEsquinas(){
		return null;
	}

	public double getArea(){
		return 0;
	}

}