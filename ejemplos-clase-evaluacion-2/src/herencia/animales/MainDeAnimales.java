package herencia.animales;

public class MainDeAnimales {

	public static void main(String[] args) {
		Pelicano pelicano = new Pelicano("lolo");
		//Animal pinguino = new Pelicano("lolo");
		String pinguino = "hola";
		//System.out.println( pelicano );
		//System.out.println( pinguino );
		
		//System.out.println( "==:" + (pinguino==pelicano) );
		System.out.println( "equals:" + pelicano.equals(pinguino) );
	}
}
