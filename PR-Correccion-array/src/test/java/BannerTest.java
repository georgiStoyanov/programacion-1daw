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
		String expected = " #    #   ####   ######  #    # ";
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
		String expected = " #    #   ####   #####   #     ";
		testBanner(expected, params );
	}
	

	private void testBanner(String expected, String ... params ) {
		Banner.main( params );
		String out = getOut();
		String[] lines = out.split("\n");
		String lastLine = lines[lines.length - 1];
		
		String expectedRegex = expected.replaceAll( "\\s+", "\\\\s+" );
		
		assertTrue( "Se esperaba que la ultima linea fuera >" + expected + "<: " + lastLine, lastLine.matches(expectedRegex) );
	}
	
	

}
