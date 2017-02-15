package com.sj1.pr3.datagenerator;

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
	
	public void testRandomData() {
		//assert.assertTrue(DataGenerator.randomData().equals("4") == true);
		Assert.assertEquals("4", DataGenerator.randomData());
	}

}
