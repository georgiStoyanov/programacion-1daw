import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;


public class MediaExecutorTester implements Callable<Map<String,MediaExecutorTester.Result>>{

	private String[] _students;
	
	
	private static void log(String s) {
		System.err.println("MediaExecutorTester:" + s);
	}		
	public static class Result{
		public int bad;
		public int good;

		public Result( int good, int bad ){
			this.good = good;
			this.bad = bad;
		}
		
		@Override
		public String toString() {
			return "good:" + good + "  bad:" + bad;
		}
	}

	public MediaExecutorTester( String ... students ){
		_students = students;
	}
	
	private String[] executeCommand(String student){
		return new String[]{
				"/usr/bin/java",
				"-cp ./students/" + student,
				"Media"
		};
	}
	
	private String[] compileCommand(String student){
		return new String[]{
				"/usr/bin/javac",
				/*"-sourcepath",
				"./students/" + student,
				"-d",
				"./students/" + student,
				"*.java"*/
		};
	}
	
	private boolean compile(String student) throws Exception{
		ExecutorTester e = new ExecutorTester(compileCommand(student),"","\\s*error\\s");
		boolean notCompiled = e.call();
		return !notCompiled;
	}

	public Result testStudent( String student ) throws Exception{
		int good = 0, bad = 0;

		String[][] testData = MediaTestData.data();
		
		if( !compile(student) ){
			return new Result(0,testData.length);
		}

		for( String[] data: testData ){
			ExecutorTester et = new ExecutorTester(executeCommand(student), data[0], data[1] );
			if( et.call() ){
				good += 1;
			}
			else{
				bad += 1;
			}
		}
		return new Result(good,bad);
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
	

	public static void main(String[] args) throws Exception {
		String[] students = { "profesor" };
		MediaExecutorTester met = new MediaExecutorTester(students);
		
		Map<String, Result> ret = met.call();
		
		for( String s: ret.keySet() ){
			System.out.println( s + ":" + ret.get(s) );
		}
		
		System.exit(0);
		
	}
	
}
