import java.util.Map;


public class TablaDeMultiplicarStudentTester extends StudentTester{

	private static void log(String s) {
		System.err.println("TablaDeMultiplicarStudentTester:" + s);
	}		
	
	public TablaDeMultiplicarStudentTester( String ... students ){
		super(students);
	}
	
	@Override
	protected String classNameToExecute() {
		return "TablaDeMultiplicar";
	}
	
	@Override 
	protected String[][] generateTestData() {
		
		String ret[][] = new String[12][];
		
		for( int i = 0 ; i < ret.length ; i++ ){
			ret[i] = new String[]{
					"" + i,
					" " + i + " x 10 = " + (i*10)
			};
			
			if( i < 1 || i > 10 ){
				ret[i][1] = "fuera de rango";
			}
			
			ret[i][1] = "(?i)" + ret[i][1].replaceAll(" ", ".*");
		}

		return ret;
	}
	
	
	
	public static void main(String[] args) throws Exception {
		String[] students = { "profesor" };
		StudentTester met = new TablaDeMultiplicarStudentTester(students);
		
		Map<String, Result> ret = met.call();
		
		for( String s: ret.keySet() ){
			System.out.println( s + ":" + ret.get(s) );
		}
		
		System.exit(0);
		
	}
	
}
