import java.util.Map;


public class MediaStudentTester extends StudentTester{

	private static void log(String s) {
		System.err.println("MediaStudentTester:" + s);
	}		
	
	public MediaStudentTester( String ... students ){
		super(students);
	}
	
	@Override
	protected String classNameToExecute() {
		return "Media";
	}
	
	@Override 
	protected String[][] generateTestData() {
		double[][] inputs = {
				{ 1, 2, 3, 4 },
				{12345678,987654321,123456789},
				{5.2, 8.2, 95, 100},
				{-56},
				{-0.01,0.01},
				{1324,1234123,51234512,13523,45546634,75,4325452,23463456,134,125342,56345,756,4567}
		};
		
		String[][] ret = new String[inputs.length][];
		for( int i = 0 ; i < ret.length ; i++ ){
			ret[i] = formatData( inputs[i]);
		}
		return ret;
	}
	
	
	private String[] formatData( double  ... input ){
		double total = 0;
		String sInput = "" + input.length + "\n";
		for( double d: input ){
			total += d;
			sInput += d + "\n";
		}
		
		double media = total/input.length;
		
		return new String[]{
				sInput, ".*" + String.valueOf(media) + ".*"
		};
	}
	
	
	public static void main(String[] args) throws Exception {
		String[] students = { "profesor" };
		StudentTester met = new MediaStudentTester(students);
		
		Map<String, Result> ret = met.call();
		
		for( String s: ret.keySet() ){
			System.out.println( s + ":" + ret.get(s) );
		}
		
		System.exit(0);
		
	}
	
}
