import java.io.File;
import java.util.Arrays;
import java.util.concurrent.Callable;


public class ExecutorTester implements Callable<Boolean>{

	private String[] _cmd;
	private String[] _validRegExpAtEnd;
	private String _input;
	private long _millis = 2000;
	private File _directory;
	
	private static void log(String s) {
		System.err.println("ExecutorTester:" + s);
	}	

	public ExecutorTester( File dir, String[] cmd, String input, String ... validRegExpAtEnd ){
		_cmd = cmd;
		_validRegExpAtEnd = validRegExpAtEnd;
		_input = input;
		_directory = dir;
	}

	@Override
	public Boolean call() throws Exception {
		
		
		log( "_cmd:" + Arrays.asList(_cmd) );
		
		Executor exec = new Executor( _directory, _cmd, _input );
		String output = exec.call(_millis );
		
		log( "output:" + output );
		
		String[] lines = output.split( "\n" );

		if( lines.length < _validRegExpAtEnd.length ){
			log( "No hay suficientes lineas");
			return false;
		}

		
		boolean ret = true;

		for( int l = 0 ; l < _validRegExpAtEnd.length && ret ; l++ ){
			String line = lines[lines.length - _validRegExpAtEnd.length + l];
			String regex = _validRegExpAtEnd[l];
			boolean matches = line.matches(regex);
			log( line + " -- " + regex + ":" + matches );
			ret = ret && matches;
		}
		
		
		
		log( "ret:" + ret );
		
		return ret;
	}
	
	public static void main(String[] args) throws Exception {
		ExecutorTester t = new ExecutorTester(new File("."), new String[]{"/usr/bin/bc"}, "4+9\nquit\n", "\\s*9\\s*" );
		
		System.out.println( t.call() );
	}
}
