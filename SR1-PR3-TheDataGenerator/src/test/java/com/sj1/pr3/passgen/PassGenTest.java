package com.sj1.pr3.passgen;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PassGenTest {
	
	 /** 
	 * Test the Password generator by changing the variable values.
	 * 
	 * Error 1: If the minLength is larger than maxLength, there will be an error.
	 * Error 2: If the sum of desired chars are larger than the generated password length
	 * there will be another error.
	 * 
	 * The unit test tests if the length of the randomized password is between the desired min & max
	 * */
	
	@SuppressWarnings("static-access")
	@Test
	public void test() {
		int minLength = 10;
		int maxLength = 20;
		int nbrOfUPR = 3;
		int nbrOfLWR = 0;
		int nbrOfNBR = 3;
		int nbrOfSYM = 3;

		PassGen passgen = new PassGen();

		char[] test = passgen.genPwd(minLength, maxLength, nbrOfUPR, nbrOfLWR, nbrOfNBR, nbrOfSYM);
		
		assertTrue(10 <= test.length && test.length <= 20);
		System.out.println(test + "\n" + "Length: " + test.length);
	}

}
