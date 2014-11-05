package grades;
import java.io.File;


public class Compiler extends ExecutorTester{

	
	public Compiler(File dir ) {
		super(dir, new String[]{ "sh", "-c", "javac *.java" }, new ExecutorTester.TestDefinition("", "\\s*error\\s") );
	}

	protected void adjustEnvironment(ProcessBuilder procB) {
		procB.environment().put("LC_ALL", "es_ES.UTF-8" );
	}
	
	public boolean compile() throws Exception{
		return !call();
	}

}
