package banner;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import common.InputOutputTest;

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
		invocaMain("Banner", params );
		String out = getOut();
		String[] lines = out.split("\n");
		String lastLine = lines[lines.length - 1];
		assertTrue( "Se esperaba " + expected + ":" + lastLine, lastLine.matches(expected) );
	}
	
	

}
