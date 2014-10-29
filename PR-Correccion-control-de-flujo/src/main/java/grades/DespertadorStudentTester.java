package grades;
import java.util.Map;

public class DespertadorStudentTester extends StudentTester {

	private static void log(String s) {
		//System.err.println("DespertadorStudentTester:" + s);
	}

	public DespertadorStudentTester(String... students) {
		super(students);
	}

	@Override
	protected String classNameToExecute() {
		return "Despertador";
	}

	@Override
	protected ExecutorTester.TestDefinition[] generateTestData() {

		
		return ExecutorTester.TestDefinition.fromStrings( new String[][]{
				{ "1\n1\n", "(?i).*7:30.*" },
				{ "6\n1\n", "(?i).*OFF.*" },
				{ "6\n7\n", "(?i).*OFF.*7:30.*7:30.*7:30.*7:30.*7:30.*10:30.*" },
				{ "4\n10\n", "(?i).*7:30.*10:30.*OFF.*7:30.*7:30.*7:30.*7:30.*7:30.*10:30.*OFF.*" },
		} );
	}

	public static void main(String[] args) throws Exception {
		String[] students = Students.students();
		StudentTester met = new DespertadorStudentTester(students);

		Map<String, Result> ret = met.call();

		for (String s : ret.keySet()) {
			System.out.println(s + ":" + ret.get(s));
		}

		System.exit(0);

	}

}
