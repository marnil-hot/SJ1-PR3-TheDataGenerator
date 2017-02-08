package com.sj1.pr3.datagenerator;

import org.junit.Test;

import com.sj1.pr3.controller.TestVerktygController;

import junit.framework.Assert;
import junit.framework.TestCase;

public class DataGeneratorTest extends TestCase {
	
	private static String CounterString_OUTPUT = "2*4*6*8*11*14*17*20*23*26*29*32*35*";

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
	public void testRandomData() {
		//assert.assertTrue(DataGenerator.randomData().equals("4") == true);
	//	Assert.assertEquals("4", DataGenerator.randomData());
	}
	
	@Test
	public void testCounterString() {
		Assert.assertTrue(TestVerktygController.generateCounterString(35, "*").equals(CounterString_OUTPUT) == true);
		Assert.assertEquals(CounterString_OUTPUT, TestVerktygController.generateCounterString(35, "*"));
	}

}
