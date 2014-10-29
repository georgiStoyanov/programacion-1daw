import junit.framework.Assert;

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
	

	@Test
	public void testHolaAsdf() {
		String[] params = { "hola", "asdf " };
		String expected = " #    #   ####   ######  #    #        #    #   ####   #####   #     ";
		testBanner(expected, params );
	}
	
	
	private void testBanner(String expected, String ... params ) {
		String all = "";
		for( String s : params ){
			all += s;
		}
		invocaMain("Banner", params );
		String out = getOut();
		System.err.println( out );
		String[] lines = out.split("\n");
		String lastLine = lines[lines.length - 1];
		
		String expectedRegex = expected.replaceAll( "\\s+", "\\\\s+" );
		
		Assert.assertTrue( "(" + all + ") Se esperaba " + expected + ":" + lastLine, lastLine.matches(expectedRegex) );
	}
	
	

}
