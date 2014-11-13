import org.junit.*;

import static org.junit.Assert.*;

import java.util.*;
  
public class EjemploTest {

	@Test
	public void testFunciona(){
		assert( 1 > 0 );
	}	

	@Test
	public void testFalla(){
		assert( 1 < 0 );
	}	

}
