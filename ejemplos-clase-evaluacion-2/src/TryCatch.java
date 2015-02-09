import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeoutException;


public class TryCatch {

	private static class MiExcepcion extends Error{
		public MiExcepcion( Throwable t ){
			super( "Algo se ha roto", t );
		}
	}
	
	
	public static void metodo1(){
		throw new IllegalStateException();
	}
	
	public static void metodo2() throws IOException, TimeoutException{
		throw new FileNotFoundException();
	}

	public static void metodo3() throws MiExcepcion{
		try{
			metodo2();
		}
		catch( IOException e ){
			throw new MiExcepcion(e);
		}
		catch( TimeoutException e ){
			throw new RuntimeException( "Pues se ha roto algo", e );
		}
		catch( Exception e ){
			
		}
	}
	
	public static void main(String[] args) throws MiExcepcion {
		metodo3();
	}
}
