package com.sj1.pr3.PNGCreator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sj1.pr3.ApplicationUtils.AppUtils;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Implemented in User Story 11 by Kevin Nemec.
 * @author Nesho
 * Just a simple test class to test our Utils methods, I'm choosing not to test the creation of a Image because it will be too much
 * code to get the stage in here, it's connected straight to the GUI and should be done with another form of testing (User case testing).
 */
public class PNGCreatorTest extends TestCase {
	
	private static final String input = "12345";
	
	public PNGCreatorTest(String name){
		super(name);
	}
	
	@Before
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	@After
	protected void tearDown() throws Exception {
		super.tearDown();
		System.out.println("Test Completed");
	}
	
	@Test
	public void testIsStringNumber(){
		Assert.assertTrue(AppUtils.isNumber(input));
	}
	
	@Test
	public void testIsStringInteger(){
		Assert.assertTrue(AppUtils.isInteger(input));
	}
}
