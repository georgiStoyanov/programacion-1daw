

public class MediaTestData{

	public static String[] generateData( double  ... input ){
		double total = 0;
		String sInput = "" + input.length + "\n";
		for( double d: input ){
			total += d;
			sInput += d + "\n";
		}
		
		return new String[]{
				sInput, String.format( "\\s*%.3f\\s*", total )
		};
	}
	public static String[][] data(){
		double[][] inputs = {
				{ 1, 2, 3, 4 },
				{},
				{5.2, 8.2, 95, 100},
				{-56},
				{-0.01,0.01},
		};
		
		String[][] ret = new String[inputs.length][];
		for( int i = 0 ; i < ret.length ; i++ ){
			ret[i] = generateData( inputs[i]);
		}
		return ret;
				
	}
	
	public static void main(String[] args) {
		for( String[] d : data() ){
			System.out.println( d[0] + d[1] );
		}
	}
}



