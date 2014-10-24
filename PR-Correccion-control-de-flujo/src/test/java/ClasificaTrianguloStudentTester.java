import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.Map;

public class ClasificaTrianguloStudentTester extends StudentTester {

	private static void log(String s) {
		System.err.println("ClasificaTrianguloStudentTester:" + s);
	}

	public ClasificaTrianguloStudentTester(String... students) {
		super(students);
	}

	public static String removeDiacriticalMarks(String string) {
		return Normalizer.normalize(string, Form.NFD).replaceAll(
				"\\p{InCombiningDiacriticalMarks}+", "");
	}

	@Override
	protected String classNameToExecute() {
		return "ClasificaTriangulo";
	}

	@Override
	protected String[][] generateTestData() {
		return new String[][]{
				{ "1\n2\n3\n", "(?i).*escaleno.*" },

				{ "1\n2\n1\n", "(?i).*isosceles.*" },
				{ "2\n1\n1\n", "(?i).*isosceles.*" },
				{ "1\n1\n2\n", "(?i).*isosceles.*" },
				
				{ "1\n1\n1\n", "(?i).*equilatero.*" },
				
				{ "20\n21\n29\n", "(?i).*rectangulo.*" },
				{ "21\n20\n29\n", "(?i).*rectangulo.*" },
				{ "29\n21\n20\n", "(?i).*rectangulo.*" },
				{ "29\n20\n21\n", "(?i).*rectangulo.*" },
				{ "20\n29\n21\n", "(?i).*rectangulo.*" },
				{ "21\n29\n20\n", "(?i).*rectangulo.*" },
		};
	}

	public static void main(String[] args) throws Exception {
		String[] students = { "profesor" };
		StudentTester met = new ClasificaTrianguloStudentTester(students);

		Map<String, Result> ret = met.call();

		for (String s : ret.keySet()) {
			System.out.println(s + ":" + ret.get(s));
		}

		System.exit(0);

	}

}