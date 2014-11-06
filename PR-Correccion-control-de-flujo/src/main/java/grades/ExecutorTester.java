package grades;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.Arrays;
import java.util.concurrent.Callable;


public class ExecutorTester implements Callable<ExecutorTester.ExecutorTesterResult>{

	private String[] _cmd;
	private long _millis = 10000;
	private File _directory;
	private TestDefinition _input;
	
	private static void log(String s) {
		//System.err.println("ExecutorTester:" + s);
	}
	
	public static class TestDefinition{
		public String[] _validRegExpAtEnd;
		public String _input;
		
		public TestDefinition( String input, String ... validRegExpAtEnd ){
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
		
		public static TestDefinition[] fromStrings( String[][] strings ){
			TestDefinition[] ret = new TestDefinition[strings.length];
			
			for( int i = 0 ; i < ret.length ; i++ ){
				String regex[] = new String[strings[i].length-1];
				System.arraycopy(strings[i], 1, regex, 0, regex.length );
				ret[i] = new TestDefinition( strings[i][0], regex );
			}
			return ret;
		}
		
		public boolean testOutput(String[] lines) {
			if( lines.length < size() ){
				log( "No hay suficientes lineas");
				return false;
			}

			
			boolean ret = true;

			for( int l = 0 ; l < size() && ret ; l++ ){
				String line = lines[lines.length - size() + l];
				line = removeDiacriticalMarks(line);
				String regex = get(l);
				boolean matches = line.matches(regex);
				log( line + " -- " + regex + ":" + matches );
				ret = ret && matches;
			}
			
			
			log( "ret:" + ret );
			
			return ret;
		}
		
		public String[] expected() {
			return _validRegExpAtEnd.clone();
		}
		
	}

	public class ExecutorTesterResult{
		private String[] _output;
		private Boolean _successfull;

		public ExecutorTesterResult( String[] output ){
			_output = output;
		}
		
		public TestDefinition definition(){
			return _input;
		}
		
		public String[] output(){
			return _output;
		}
		
		public boolean successfull(){
			if( _successfull != null ){
				return _successfull;
			}
			_successfull = _input.testOutput(_output);
			return _successfull;
		}

		public void dumpResult(Writer osw) throws IOException {
			osw.write( "*********************************\n");
			osw.write( "**** COMMAND:\n" );
			for( String s: _cmd ){
				osw.write( s + " " );
			}
			osw.write("\n");
			osw.write( "**** INPUT:\n");
			osw.write( definition().input() );
			osw.write( "**** OUTPUT:\n");
			for( String s: output() ){
				osw.write( s + "\n" );
			}
			osw.write( "**** EXPECTED:\n");
			for( String s: definition().expected() ){
				osw.write( s + "\n" );
			}
			osw.write( "**** SUCCESSFUL:" + successfull() + "\n" );
			osw.write( "*********************************\n\n");
			
		}
	}
	
	public ExecutorTester( File dir, String[] cmd, TestDefinition expectedRegExp ){
		_cmd = cmd;
		_input = expectedRegExp;
		_directory = dir;
	}
	
	public static String removeDiacriticalMarks(String string) {
		return Normalizer.normalize(string, Form.NFD).replaceAll(
				"\\p{InCombiningDiacriticalMarks}+", "");
	}


	@Override
	public ExecutorTesterResult call() throws Exception {
		
		
		log( "_cmd:" + Arrays.asList(_cmd) );
		log( "_directory:" + _directory );
		log( "input:-->\n" + _input.input() );
		log( "input:<--");
		
		Executor exec = new Executor( _directory, _cmd, _input.input() ){
		@Override
			protected void adjustEnvironment(ProcessBuilder procB) {
				super.adjustEnvironment(procB);
				ExecutorTester.this.adjustEnvironment(procB);
			}	
		};
		
		String output = exec.call(_millis );
		
		log( "output:" + output );
		
		String[] lines = output.split( "\n" );

		return new ExecutorTesterResult( lines );
	}

	
	protected void adjustEnvironment(ProcessBuilder procB) {
	}

	public static void main(String[] args) throws Exception {
		TestDefinition ere = new TestDefinition("4+9\nquit\n", "\\s*13\\s*");
		ExecutorTester t = new ExecutorTester(new File("."), new String[]{"/usr/bin/bc"},ere );
		
		System.out.println( t.call() );
		System.exit(0);
	}
}
