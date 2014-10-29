package common;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.Timeout;

public class InputOutputTest {

	private static final String DEFAULT_IN = "Sin entrada definida para el test";

	@Rule
	public Timeout globalTimeout = new Timeout(10 * 1000);

	private PrintStream _outContent;
	private ByteArrayOutputStream _outByteArray;
	private PrintStream _originalOut;
	private InputStream _originalIn;

	@Before
	public void setUp() throws Exception {
		_originalOut = System.out;
		_originalIn = System.in;
		_outByteArray = new ByteArrayOutputStream();
		_outContent = new PrintStream(_outByteArray);
		System.setOut(_outContent);
		System.setIn(new ByteArrayInputStream(DEFAULT_IN.getBytes()));
	}

	@After
	public void tearDown() throws Exception {
		System.setOut(_originalOut);
		System.setIn(_originalIn);
	}

	protected void setInputStream(String in) {
		System.setIn(new ByteArrayInputStream(in.getBytes()));
	}

	protected String getOut() {
		_outContent.flush();
		return _outByteArray.toString();
	}

	protected void invocaMain( String clase, String[] args ){
    	try{
	    	Class c = Class.forName(clase);
	    	Method m = c.getMethod( "main", new Class[]{ String[].class } );
	    	m.invoke(null, new Object[]{ args } );
    	}
    	catch( Exception e ){
    		throw new IllegalStateException(e);
    	}
    }

}
