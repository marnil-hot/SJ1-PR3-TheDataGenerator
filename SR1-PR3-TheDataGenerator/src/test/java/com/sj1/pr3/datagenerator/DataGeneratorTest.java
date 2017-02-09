package com.sj1.pr3.datagenerator;

import org.junit.Test;

import junit.framework.Assert;
import junit.framework.TestCase;

public class DataGeneratorTest extends TestCase {

	public DataGeneratorTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	@Test
	public void testRandomMail() {
		Assert.assertTrue(RandomMailGenerator.randomMail(15).contains("@") == true);
		Assert.assertEquals(true , RandomMailGenerator.randomMail(15).contains("@"));
	
	}

}
