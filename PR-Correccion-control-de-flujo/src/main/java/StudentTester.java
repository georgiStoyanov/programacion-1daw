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
		private String _name;
		private InputOutput[] _inputOutputs;

		public InputOutput[] inputOutputs() {
			return _inputOutputs;
		}


	
		public Result( String name, int good, int bad ){
			_name = name;
			_good = good;
			_bad = bad;
		}
		
		@Override
		public String toString() {
			return name() + "  good:" + good() + "  bad:" + bad();
		}
		
		public String name(){
			return _name;
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
		return new Compiler( studentDir(student) ).compile();
	}

	public Result testStudent(String student) throws Exception {
		int good = 0, bad = 0;
	
		ExecutorTester.ExpectedRegExp[] testData = generateTestData();
		
		if( !compile(student) ){
			return new Result( classNameToExecute(), 0,testData.length);
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
		return new Result(classNameToExecute(), good, bad);
	}

	abstract protected ExecutorTester.ExpectedRegExp[] generateTestData();

}
