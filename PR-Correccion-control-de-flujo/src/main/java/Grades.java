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
