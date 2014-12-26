package geometria.mock;


public class ICirculo{


	public static ICirculo createCirculo(IPunto centro, double radio) {
	    return new ICirculo(centro, radio);
	}

	public ICirculo(IPunto centro, double radio){
	}

	public IPunto getCentro(){
		return null;
	}

	public void setCentro(IPunto p){
	}
	
	public double getRadio(){
		return 0;
	}

	public void setRadio(double radio){
	}
	
	public double getArea(){
		return 0;
	}

}