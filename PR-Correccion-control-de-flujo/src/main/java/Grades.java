import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
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

		Map<String, Map<String, StudentTester.Result>> results = collectResults(testers);
		dumpResults_CSV(results);
		
		System.exit(0);
	}

	
	/**
	 * 
	 * @param testers
	 * @return Un Map con clave "nombre de estudiante". El valor es un Map con clave "nombre de ejercicio",
	 *         y con valor el resultado del ejercicio 
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	private static Map<String, Map<String, StudentTester.Result>> collectResults(
			StudentTester[] testers) throws InterruptedException,
			ExecutionException {
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
		return results;
	}

	private static void dumpResults(Map<String, Map<String, StudentTester.Result>> results) {
		for( String student: results.keySet() ){
			Map<String,StudentTester.Result> r = results.get(student );
			System.out.print( student.trim() + "\t" );
			for(String t: r.keySet() ){
				t = t.trim();
				System.out.print( t + "\tgood:\t" + r.get(t).good() + "\tbad:\t" + r.get(t).bad() + "\t" );
			}
			System.out.println();
		}
	}
	
	private static void dumpResults_CSV(Map<String, Map<String, StudentTester.Result>> results) {
		String[] classes = results.values().iterator().next().keySet().toArray( new String[0] );
		
		System.out.print( "student\t");
		for( String c: classes ){
			System.out.print( c + " good\t" + c + " bad\t");
		}
		System.out.println();
		
		for( String student: results.keySet() ){
			Map<String,StudentTester.Result> r = results.get(student );
			System.out.print( student.trim() + "\t" );
			for(String c: classes ){
				System.out.print( r.get(c).good() + "\t" + r.get(c).bad() + "\t" );
			}
			System.out.println();
		}
	}
	
	
}
