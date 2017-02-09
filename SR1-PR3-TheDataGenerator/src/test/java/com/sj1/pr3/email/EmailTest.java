package com.sj1.pr3.email;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sj1.pr3.controller.Email;

import junit.framework.Assert;

public class EmailTest {

	@Test
	public void testEmail() {
		Email test = new Email();
		//Tests if the method parmeter plus the randomized mail is between 10 and 18 characters
		assertTrue(10 <= test.emailRandom(5).length() && test.emailRandom(5).length() <= 18);
		System.out.println(test.emailRandom(5) + "\n length: " + test.emailRandom(5).length());
	}

}
