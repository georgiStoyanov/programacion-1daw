import java.util.Map;

public class TablaDeMultiplicarStudentTester extends StudentTester {

	private static void log(String s) {
		System.err.println("TablaDeMultiplicarStudentTester:" + s);
	}

	public TablaDeMultiplicarStudentTester(String... students) {
		super(students);
	}

	@Override
	protected String classNameToExecute() {
		return "TablaDeMultiplicar";
	}

	@Override
	protected ExecutorTester.ExpectedRegExp[] generateTestData() {

		String ret[][] = new String[12][];

		for (int i = 0; i < ret.length; i++) {
			if (i < 1 || i > 10) {
				ret[i] = new String[] { 
						"" + i, 
						"fuera de rango" 
				};
			} 
			else {
				ret[i] = new String[] {
						"" + i, " " + i + " x 1 = " + (i * 1),
						" " + i + " x 2 = " + (i * 2),
						" " + i + " x 3 = " + (i * 3),
						" " + i + " x 4 = " + (i * 4),
						" " + i + " x 5 = " + (i * 5),
						" " + i + " x 6 = " + (i * 6),
						" " + i + " x 7 = " + (i * 7),
						" " + i + " x 8 = " + (i * 8),
						" " + i + " x 9 = " + (i * 9),
						" " + i + " x 10 = " + (i * 10) 
				};
			}

			for( int j = 1 ; j < ret[i].length ; j++ ){
				ret[i][j] = "(?i)" + ret[i][j].replaceAll(" ", ".*");
			}
		}

		return ExecutorTester.ExpectedRegExp.fromStrings(ret);
	}

	public static void main(String[] args) throws Exception {
		String[] students = { "profesor" };
		StudentTester met = new TablaDeMultiplicarStudentTester(students);

		Map<String, Result> ret = met.call();

		for (String s : ret.keySet()) {
			System.out.println(s + ":" + ret.get(s));
		}

		System.exit(0);

	}

}
