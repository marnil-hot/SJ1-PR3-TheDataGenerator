package com.sj1.pr3.model;

import com.sj1.pr3.controller.AppTest;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

// so this is a test to see if the generator prints out a string with the matching length of the input. In this case we test if 20 is the correct output.

public class GenerateGibberishTest extends TestCase {
	
	private GenerateGibberish gg;
    private static final int EXPECTED_STRING_LENGTH = 20;
	
	public GenerateGibberishTest( String name )
    {
        super( name );
    }
	
	public void setUp() throws Exception {   // the setup for my generate,I have declared my model as gg in this case
		super.setUp();
		gg = new GenerateGibberish();
	}
	
	public void tearDown() throws Exception {  
		super.tearDown();
	}
	
    @SuppressWarnings("deprecation")
	@org.junit.Test
    public void testGenerateGibberish()    // Testing my generator to see if the length of the gibberish string match what we seek "20" in this case
    {
        assertTrue( true );
        String gibberish = gg.generateGibberish(20);
        Assert.assertEquals(EXPECTED_STRING_LENGTH,gibberish.length());

    }
}
