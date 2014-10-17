import java.util.Arrays;
import java.util.concurrent.Callable;


public class ExecutorTester implements Callable<Boolean>{

	private String[] _cmd;
	private String _validRegExpAtEnd;
	private String _input;
	private long _millis = 2000;
	
	private static void log(String s) {
		System.err.println("ExecutorTester:" + s);
	}	

	public ExecutorTester( String cmd, String input, String validRegExpAtEnd ){
		this( new String[]{cmd}, input, validRegExpAtEnd);
	}
	public ExecutorTester( String[] cmd, String input, String validRegExpAtEnd ){
		_cmd = cmd;
		_validRegExpAtEnd = validRegExpAtEnd;
		_input = input;
	}

	@Override
	public Boolean call() throws Exception {
		
		
		log( "_cmd:" + Arrays.asList(_cmd) );
		
		Executor exec = new Executor(_cmd, _input );
		String output = exec.call(_millis );
		
		log( "output:" + output );
		
		String[] lines = output.split( "\n" );
		String lastLine = lines[lines.length-1];
		
		log( "lastLine:" + lastLine );
		
		return lastLine.matches( _validRegExpAtEnd );
	}
	
	public static void main(String[] args) throws Exception {
		ExecutorTester t = new ExecutorTester("/usr/bin/bc", "4+9\nquit\n", "\\s*9\\s*" );
		
		System.out.println( t.call() );
	}
}
