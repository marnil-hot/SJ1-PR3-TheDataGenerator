package com.sj1.pr3.datagenerator;

import org.junit.Test;

import com.sj1.pr3.ApplicationUtils.NumberParser;

import junit.framework.Assert;
import junit.framework.TestCase;

/*
 *Developed by Rrahman Rexhepi - User Story 2.
 *Junit test: NumberParser.java
 * NumberParser takes a string , then will parse it to what ever it got told to parse.
 * If it fails it returns false, if it succeeded it returns true.
 * */

public class NumberParserTest extends TestCase {

	private static String integerValue = "250";
	private static String longValue = "500";
	private static String doubleValue = "500.00";
	private static String charResult = "23yes";
	private static boolean isInteger;
	private static boolean isLong;
	private static boolean isDouble;

	public NumberParserTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/*
	 * Parse string to integer.
	 * if it fails , log message.
	 * */
	@Test
	public void testIntegerParser() {
		if (NumberParser.parseInteger(integerValue)) {
			isInteger = true;
		} else {
			isInteger = false;
			System.out.println("Value is not a integer.");
		}

		Assert.assertEquals(true, isInteger);
	}

	/* Parse string to integer, where the string is not a integer.
	 * If it fails,  then the string is a integer. */
	@Test
	public void testIntegerParserFail() {
		if (NumberParser.parseInteger(charResult)) {
			isInteger = true;
			System.out.println("TestIntegerParserFail : Value is Integer!");
		} else {
			isInteger = false;
		}

		Assert.assertEquals(false, isInteger);
	}

	/*
	 * Parse string to long..
	 * if it fails , log message.
	 * */
	@Test
	public void testLongParser() {
		if (NumberParser.parseLong(longValue)) {
			isLong = true;
		} else {
			isLong = false;
			System.out.println("Value is not a long.");
		}

		Assert.assertEquals(true, isLong);
	}

	/* Parse string to long, where the string is not a long.
	 * If it fails,  then the string is a long. */
	@Test
	public void testLongParserFail() {
		if (NumberParser.parseLong(charResult)) {
			isLong = true;
			System.out.println("TestLongParserFail : Value is Long!");
		} else {
			isLong = false;
		}

		Assert.assertEquals(false, isLong);
	}
	
	
	/*
	 * Parse string to double.
	 * if it fails , log message.
	 * */
	@Test
	public void testDoubleParser() {
		if (NumberParser.parseDouble(doubleValue)) {
			isDouble = true;
		} else {
			isDouble = false;
			System.out.println("Value is not a integer.");
		}

		Assert.assertEquals(true, isDouble);
	}

	/* Parse string to double, where the string is not a double.
	 * If it fails,  then the string is a double. */
	@Test
	public void testDoubleParserFail() {
		if (NumberParser.parseDouble(charResult)) {
			isDouble = true;
			System.out.println("testDoubleParserFail: Value is a integer!");
		} else {
			isDouble = false;
			System.out.println("Value is not a integer.");
		}

		Assert.assertEquals(false, isDouble);
	}

}
