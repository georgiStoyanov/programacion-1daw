import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;




public class Grades {

	public static void main(String[] args) throws Exception {
		String[] students = Students.students();
		StudentTester[] testers = {
			new TablaDeMultiplicarStudentTester(students),
			new MediaStudentTester(students),
			new DespertadorStudentTester(students),
			new ClasificaTrianguloStudentTester(students) 
		};

		final ExecutorService pool = Executors.newFixedThreadPool(1);

		List<Future<Map<String,StudentTester.Result>>> listOfFutures = new ArrayList<Future<Map<String,StudentTester.Result>>>();
		for( StudentTester t : testers ){
			listOfFutures.add( pool.submit( t ) );
		}
		
		Map<String,Map<String,StudentTester.Result>> results = new HashMap<String,Map<String,StudentTester.Result>>();
		
		for( Future<Map<String,StudentTester.Result>> f : listOfFutures ){
			Map<String, StudentTester.Result> r = f.get();
			
			for( String student : r.keySet() ){
				if( results.get(student) == null ){
					results.put( student, new HashMap<String,StudentTester.Result>() );
				}
				
				results.get( student ).put( r.get(student).name(), r.get(student) );
			}
		}
		
		
		for( String student: results.keySet() ){
			Map<String,StudentTester.Result> r = results.get(student );
			System.out.print( student + "\t" );
			for(String t: r.keySet() ){
				System.out.print( t + "\tgood:\t" + r.get(t).good() + "\tbad:\t" + r.get(t).bad() + "\t" );
			}
			System.out.println();
		}
		
		System.exit(0);
	}
}
