package com.sj1.pr3.model;

import com.sj1.pr3.controller.AppTest;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class GenerateGibberishTest extends TestCase {
	
	private GenerateGibberish gg;
    private static final int EXPECTED_STRING_LENGTH = 20;
	
	public GenerateGibberishTest( String name )
    {
        super( name );
    }
	
	public void setUp() throws Exception {
		super.setUp();
		gg = new GenerateGibberish();
	}
	
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
    @SuppressWarnings("deprecation")
	@org.junit.Test
    public void testGenerateGibberish()
    {
        assertTrue( true );
        String gibberish = gg.generateGibberish(20);
        Assert.assertEquals(EXPECTED_STRING_LENGTH, gg.generateGibberish(20));

    }
}
