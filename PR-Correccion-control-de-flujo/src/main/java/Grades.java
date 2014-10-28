import java.util.HashMap;
import java.util.Map;



public class Grades {
	


	public static void main(String[] args) throws Exception {
		String[] students = Students.students();
		StudentTester[] testers = {
			new TablaDeMultiplicarStudentTester(students),
			new MediaStudentTester(students),
			new DespertadorStudentTester(students),
			new ClasificaTrianguloStudentTester(students) 
		};

		
		Map<String,Map<String,StudentTester.Result>> results = new HashMap<String,Map<String,StudentTester.Result>>();
		
		
		for( StudentTester t : testers ){
			Map<String, StudentTester.Result> r = t.call();
			
			for( String student : r.keySet() ){
				if( results.get(student) == null ){
					results.put( student, new HashMap<String,StudentTester.Result>() );
				}
				
				results.get( student ).put( t.classNameToExecute(), r.get(student) );
			}
		}
		
		
		dumpResults_CSV(results);
		
		System.exit(0);
	}

	private static void dumpResults(Map<String, Map<String, StudentTester.Result>> results) {
		for( String student: results.keySet() ){
			Map<String,StudentTester.Result> r = results.get(student );
			System.out.print( student + "\t" );
			for(String t: r.keySet() ){
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
			System.out.print( student + "\t" );
			for(String c: classes ){
				System.out.print( r.get(c).good() + "\t" + r.get(c).bad() + "\t" );
			}
			System.out.println();
		}
	}
	
	
}
