package grades;

public class InputOutput {
	public String input() {
		return _input;
	}

	private String _output;
	
	public String output() {
		return _output;
	}


	private String _input;
	private boolean _good;

	public InputOutput( String input, String output, boolean good ){
		_input = input;
		_output = output;
		_good = good;
	}
	
	public boolean good(){
		return _good;
	}
}
