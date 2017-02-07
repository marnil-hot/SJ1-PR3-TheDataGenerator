package com.sj1.pr3.datagenerator;

import org.junit.Test;
import com.sj1.pr3.model.GenerateTestData;
import junit.framework.Assert;
import junit.framework.TestCase;

/*
 * Developed by Rrahman Rexhepi - User Story 2.
 * Junit test: GenerateTestData.java
 * GenerateTestData takes a long value , how many times to generate random value.
 * I can not really compare if the value but i can compare if the length of the string is the same as what i put in.
 * In this test i just select to random generate numbers, that i will use to try to parse it, if it succeed then the output is doing its job ,
 * if it fails the generator does not generate exactly what i want it to do.
 * */

public class GenerateTestDataTest extends TestCase {

	private static int lengtOfRandom = 50;
	private static int lengtOfNumber = 5;
	private static String result;
	public boolean parseLong;
	public long longValue;

	public GenerateTestDataTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testRandomData() {
		// Create test data.
		GenerateTestData testData = new GenerateTestData();

		/*
		 * TestData takes: long size, boolean specialChars, boolean numbers,
		 * boolean, smallChars,boolean bigChar
		 */
		result = testData.generateTestData(50, true, true, true, true);
		// control if the length is the same as what we put in.
		Assert.assertEquals(lengtOfRandom, result.length());
	}

	@Test
	public void testNumbersOnly() {
		GenerateTestData testData = new GenerateTestData();

		/*
		 * TestData takes: long size, boolean specialChars, boolean numbers,
		 * boolean, smallChars,boolean bigChar
		 */
		result = testData.generateTestData(lengtOfNumber, false, true, false, false);

		/*
		 * Try to parse result as s long, this part will fail if something else
		 * then numbers is true, this part will fail.
		 */
		try {
			Long.parseLong(result);
			parseLong = true;

		} catch (final NumberFormatException ex) {
			parseLong = false;
			System.out.println("Faild to parse the value.");
		}

		Assert.assertEquals(true, parseLong);
	}

}
