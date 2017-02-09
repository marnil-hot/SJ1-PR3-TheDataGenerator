package com.sj1.pr3.model;

import junit.framework.Assert;
import junit.framework.TestCase;

/* Developed by Ibrahim Ibrahim User Story 8_GenerateGibberish
 * This is my GenerateGibberish Junit Test to check if a hard coded input is looped and returned in the right length (right amount of characters).
 * We have put the expected length to 20 characters in this case, it allsow counts the spaces. 
 * 2017-02-09 was last tested and green. 
 */

public class GenerateGibberishTest extends TestCase {
	
	private GenerateGibberish gg;
    private static final int EXPECTED_STRING_LENGTH = 20;
	
	public GenerateGibberishTest( String name )
    {
        super( name );
    }
	
	//I have declared my model as gg in this case
	public void setUp() throws Exception {  
		super.setUp();
		gg = new GenerateGibberish();
	}
	
	public void tearDown() throws Exception {  
		super.tearDown();
	}
	
	// Testing my generator to see if the length of the gibberish string match what we seek "20" in this case
    @SuppressWarnings("deprecation")
	@org.junit.Test
    public void testGenerateGibberish()   
    {
        assertTrue( true );
        String gibberish = gg.generateGibberish(20);
        Assert.assertEquals(EXPECTED_STRING_LENGTH,gibberish.length());

    }
}
