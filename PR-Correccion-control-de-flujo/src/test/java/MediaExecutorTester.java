import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;


public class MediaExecutorTester implements Callable<Map<String,MediaExecutorTester.Result>>{

	private String[] _students;
	
	public static class Result{
		public int bad;
		public int good;

		public Result( int good, int bad ){
			this.good = good;
			this.bad = bad;
		}
	}

	public MediaExecutorTester( String[] students ){
		_students = students;
	}

	public Result testStudent( String student ){
		int good = 0, bad = 0;
		for( String[] data: MediaTestData.data() ){
			ExecutorTester et = new ExecutorTester(cmd, data[0], data[1] );
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
		
		Map<String,Result> ret = new HashMap<>();
		
		for( String s: _students ){
			int good = 0;
			int bad = 0;
		}
		
	}
	

	
}
