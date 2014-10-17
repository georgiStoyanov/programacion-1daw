import java.io.File;
import java.util.Arrays;
import java.util.concurrent.Callable;


public class ExecutorTester implements Callable<Boolean>{

	private String[] _cmd;
	private long _millis = 2000;
	private File _directory;
	private ExpectedRegExp _expectedRegExp;
	
	private static void log(String s) {
		System.err.println("ExecutorTester:" + s);
	}
	
	public static class ExpectedRegExp{
		public String[] _validRegExpAtEnd;
		public String _input;
		
		public ExpectedRegExp( String input, String ... validRegExpAtEnd ){
			_input = input;
			_validRegExpAtEnd = validRegExpAtEnd;
		}
		public int size(){
			return _validRegExpAtEnd.length;
		}
		public String get(int i){
			return _validRegExpAtEnd[i];
		}
		public String input(){
			return _input;
		}
		
		public static ExpectedRegExp[] fromStrings( String[][] strings ){
			ExpectedRegExp[] ret = new ExpectedRegExp[strings.length];
			
			for( int i = 0 ; i < ret.length ; i++ ){
				String regex[] = new String[strings[i].length-1];
				System.arraycopy(strings[i], 1, regex, 0, regex.length );
				ret[i] = new ExpectedRegExp( strings[i][0], regex );
			}
			return ret;
		}
	}

	public ExecutorTester( File dir, String[] cmd, ExpectedRegExp expectedRegExp ){
		_cmd = cmd;
		_expectedRegExp = expectedRegExp;
		_directory = dir;
	}

	@Override
	public Boolean call() throws Exception {
		
		
		log( "_cmd:" + Arrays.asList(_cmd) );
		
		Executor exec = new Executor( _directory, _cmd, _expectedRegExp.input() );
		String output = exec.call(_millis );
		
		log( "output:" + output );
		
		String[] lines = output.split( "\n" );

		if( lines.length < _expectedRegExp.size() ){
			log( "No hay suficientes lineas");
			return false;
		}

		
		boolean ret = true;

		for( int l = 0 ; l < _expectedRegExp.size() && ret ; l++ ){
			String line = lines[lines.length - _expectedRegExp.size() + l];
			String regex = _expectedRegExp.get(l);
			boolean matches = line.matches(regex);
			log( line + " -- " + regex + ":" + matches );
			ret = ret && matches;
		}
		
		
		
		log( "ret:" + ret );
		
		return ret;
	}
	
	public static void main(String[] args) throws Exception {
		ExpectedRegExp ere = new ExpectedRegExp("4+9\nquit\n", "\\s*13\\s*");
		ExecutorTester t = new ExecutorTester(new File("."), new String[]{"/usr/bin/bc"},ere );
		
		System.out.println( t.call() );
		System.exit(0);
	}
}
