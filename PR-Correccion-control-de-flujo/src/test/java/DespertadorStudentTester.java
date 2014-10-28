import java.util.Map;

public class DespertadorStudentTester extends StudentTester {

	private static void log(String s) {
		System.err.println("DespertadorStudentTester:" + s);
	}

	public DespertadorStudentTester(String... students) {
		super(students);
	}

	@Override
	protected String classNameToExecute() {
		return "Despertador";
	}

	@Override
	protected ExecutorTester.ExpectedRegExp[] generateTestData() {

		
		return ExecutorTester.ExpectedRegExp.fromStrings( new String[][]{
				{ "1\n1\n", ".*7:30.*" },
				{ "6\n1\n", ".*OFF.*" },
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
