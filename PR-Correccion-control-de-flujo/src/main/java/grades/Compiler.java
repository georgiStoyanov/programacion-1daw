package grades;
import java.io.File;


public class Compiler extends ExecutorTester{

	
	private ExecutorTesterResult _result;

	public Compiler(File dir, String files ) {
		super(dir, new String[]{ "sh", "-c", "javac " + files }, new ExecutorTester.TestDefinition("", "\\s*error\\s") );
	}

	protected void adjustEnvironment(ProcessBuilder procB) {
		procB.environment().put("LC_ALL", "es_ES.UTF-8" );
	}
	
	public ExecutorTesterResult getCompileResult() throws Exception{
		if( _result == null ){
			_result = call();
		}
		return _result;
		
	}
	
	public boolean compile() throws Exception{
		// IF THERE IS "error", THEN IS NOT SUCCESSFUL
		ExecutorTesterResult r = getCompileResult();
		return !r.successfull();
	}
}
