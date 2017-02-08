package com.sj1.pr3.controller;

import org.junit.Test;

import com.sj1.pr3.model.GenerateRandomEmail;

import junit.framework.Assert;
import junit.framework.TestCase;

public class RandomEmailTest extends TestCase{
	private static String GeneratedRandomString = "w@mivmnvff.rnv";
	private static final String at = "@";
	private static final String dot = ".";
	
	/** Test Developed by Hampus bohlin.
	 *  Test if the string contains an @
	 */
	@Test
    public void testIfMailContainsAtSign(){
        Assert.assertTrue(at, GeneratedRandomString.contains(at));
    }
	/** Test Developed by Hampus bohlin.
	 *  Test if the string contains an "."
	 */
	@Test
	public void testIfMailCointainsDot(){
		Assert.assertTrue(dot, GeneratedRandomString.contains(dot));
	}
	/** Test Developed by Hampus bohlin.
	 *  Test if the string is the right amount of characters
	 */
	@Test
	public void testIfMailIsLongEnough(){
		Assert.assertEquals(GeneratedRandomString, GeneratedRandomString.equals(14) == true);
	}


}