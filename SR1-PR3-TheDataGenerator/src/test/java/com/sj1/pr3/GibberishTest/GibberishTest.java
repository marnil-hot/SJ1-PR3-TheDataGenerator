package com.sj1.pr3.GibberishTest;

import org.junit.Test;

import aplicationTeam2.GibberishGenerator;
import junit.framework.Assert;
import junit.framework.TestCase;

/*
 * Made by Namir Wesaf.
 * Gibberish generator creates word depends on how many the user want to generate.
 * For this test did so i counted the (spaces) between the words to count how many words where generated.
 * The size should always be the same as the space counter.
 * I use the spaceDetector as a char contain a space inside it then loop the string to count how many words they are.
 * */
public class GibberishTest extends TestCase {

	private static int size = 10;
	private char spaceDetector = ' ';
	private int spaceCounter = 1;

	public GibberishTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testGibberishTest() {
		GibberishGenerator gibberishGenerator = new GibberishGenerator();
		String result = gibberishGenerator.generateRandomWords(size);

		for (int i = 0; i <= result.length() - 1; i++) {

			if (result.charAt(i) == spaceDetector) {
				spaceCounter += 1;

			}

		}

		Assert.assertEquals(spaceCounter, size);
		System.out.println("Sucess!");

	}

}
