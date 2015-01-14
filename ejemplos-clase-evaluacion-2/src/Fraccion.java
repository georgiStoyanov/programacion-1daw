import static java.lang.Math.*;

public class Fraccion {

	private static int mcd( int a, int b ){
		while( true ){
			int minimo = min(a,b);
			int maximo = max(a,b);
			if( minimo == 0 ){
				return maximo;
			}
			a = maximo - minimo;
			b = minimo;
		}
	}
	
	public Fraccion irreducible(){
		int mcd = mcd(getNumerador(),getDenominador());
		return new Fraccion( getNumerador()/mcd, getDenominador()/mcd );
	}
	
	public Fraccion suma( Fraccion f ){
		int n = getDenominador()*f.getNumerador() + getNumerador()*f.getDenominador();
		int d = getDenominador()*f.getDenominador();
		return new Fraccion( n, d ).irreducible();
	}

	public Fraccion mul( Fraccion f ){
		int n = getNumerador()*f.getNumerador();
		int d = getDenominador()*f.getDenominador();
		return new Fraccion( n, d ).irreducible();
	}
	
	
	public int getNumerador() {
		return _numerador;
	}

	public int getDenominador() {
		return _denominador;
	}

	private int _numerador;
	private int _denominador;

	public Fraccion(int numerador, int denominador) {
		_numerador = numerador;
		_denominador = denominador;
	}

	@Override
	public String toString() {
		return String.format("%d/%d", getNumerador(), getDenominador());
	}
	
	@Override
	public boolean equals(Object obj) {
		
		boolean elObjEsUnaFraccion = obj instanceof Fraccion;
		if( elObjEsUnaFraccion ){
			Fraccion f1 = this;
			Fraccion f2 = (Fraccion)obj;
			
			return f1.getDenominador()*f2.getNumerador() == 
					f1.getNumerador() * f2.getDenominador();
		}
		
		if( obj instanceof Integer ){
			Integer i = (Integer)obj;
			Fraccion f1 = this;
			Fraccion f2 = new Fraccion(i.intValue(),1);
			return f1.equals(f2);
		}
		
		return false;
	}

	public static void main(String[] args) {
		Fraccion f1 = new Fraccion(3, 4);
		Fraccion f2 = new Fraccion(6, 8);
		Fraccion f3 = new Fraccion(9, 4);
		System.out.printf(" %s = %s?: %b \n", f1, f2, 
				f1.equals(f2));
		System.out.printf(" %s = %s?: %b \n", f2, f1, 
				f2.equals(f1));
		System.out.printf(" %s = %s?: %b \n", f3, f1, 
				f3.equals(f1));
		System.out.printf(" %s = %s?: %b \n", f1, f3, 
				f1.equals(f3));

		System.out.printf(" %s = %s?: %b \n", f1, "hola", 
				f1.equals("hola"));
		
		Integer siete = new Integer(7);
		Fraccion fsiete = new Fraccion(21, 3);
		System.out.printf(" %s = %s?: %b \n", fsiete, siete, 
				fsiete.equals(siete));
		
		
		
		System.out.printf(" %s+%s = %s \n", f1, f3, f1.suma(f3) );
		System.out.printf(" %s+%s = %s \n", f2, f3, f2.suma(f3) );
		System.out.printf(" %s*%s = %s \n", f1, f3, f1.mul(f3) );
		System.out.printf(" %s*%s = %s \n", f2, f3, f2.mul(f3) );
	}
}
