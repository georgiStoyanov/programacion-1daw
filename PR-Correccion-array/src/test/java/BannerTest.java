import static org.junit.Assert.*;

import org.junit.Test;

public class BannerTest extends InputOutputTest {

	/**
 #    #   ####   #         ##
 #    #  #    #  #        #  #
 ######  #    #  #       #    #
 #    #  #    #  #       ######
 #    #  #    #  #       #    #
 #    #   ####   ######  #    #
	 */
	@Test
	public void testHola() {
		String[] params = { "hola " };
		String expected = "\\s+#\\s+#\\s+####\\s+######\\s+#\\s+#\\s+";
		
		testBanner(expected, params);
	}
	
	/**
	 
   ##     ####   #####   ######
  #  #   #       #    #  #
 #    #   ####   #    #  #####
 ######       #  #    #  #
 #    #  #    #  #    #  #
 #    #   ####   #####   #

	 */
	
	@Test
	public void testAsdf() {
		String[] params = { "asdf " };
		String expected = "\\s+#\\s+#\\s+####\\s+#####\\s+#\\s+";
		
		testBanner(expected, params );
	}
	

	private void testBanner(String expected, String ... params ) {
		Banner.main( params );
		String out = getOut();
		String[] lines = out.split("\n");
		String lastLine = lines[lines.length - 1];
		assertTrue( "Se esperaba " + expected + ":" + lastLine, lastLine.matches(expected) );
	}
	
	

}
