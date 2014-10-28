import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;




public abstract class StudentTester  implements Callable<Map<String,StudentTester.Result>>{

	public static class Result{
		public int bad() {
			return _bad;
		}

		public int good() {
			return _good;
		}

		public int _bad;
		public int _good;
	
		public Result( int good, int bad ){
			_good = good;
			_bad = bad;
		}
		
		@Override
		public String toString() {
			return "good:" + good() + "  bad:" + bad();
		}
	}

	private String[] _students;

	public StudentTester(String ... students) {
		_students = students;
	}

	protected abstract String classNameToExecute();

	protected String[] executeCommand(String student) {
		return new String[]{
				"/usr/bin/java",
				"-cp", ".",
				classNameToExecute()
		};
	}

	protected String[] compileCommand(String student) {
		/*
		return new String[]{
				"/usr/bin/javac",
				"Media.java"
		};
		*/
		return new String[]{
			"/bin/sh",
			"-c",
			"/usr/bin/javac *.java"
		};
	}

	protected File studentDir(String student) {
		return new File("./students/" + student);
	}


	@Override
	public Map<String, Result> call() throws Exception {
		
		Map<String,Result> ret = new HashMap<String,Result>();
		
		for( String s: _students ){
			Result result = testStudent(s);
			ret.put( s, result );
		}
		
		return ret;
	}

	protected boolean compile(String student) throws Exception {
		ExecutorTester.ExpectedRegExp ere = new ExecutorTester.ExpectedRegExp("", "\\s*error\\s");
		ExecutorTester e = new ExecutorTester(studentDir(student), compileCommand(student),ere);
		boolean notCompiled = e.call();
		return !notCompiled;
	}

	public Result testStudent(String student) throws Exception {
		int good = 0, bad = 0;
	
		ExecutorTester.ExpectedRegExp[] testData = generateTestData();
		
		if( !compile(student) ){
			return new Result(0,testData.length);
		}
	
		for( ExecutorTester.ExpectedRegExp data: testData ){
			ExecutorTester et = new ExecutorTester(studentDir(student), executeCommand(student), data );
			if( et.call() ){
				good += 1;
			}
			else{
				bad += 1;
			}
		}
		return new Result(good,bad);
	}

	abstract protected ExecutorTester.ExpectedRegExp[] generateTestData();

}
