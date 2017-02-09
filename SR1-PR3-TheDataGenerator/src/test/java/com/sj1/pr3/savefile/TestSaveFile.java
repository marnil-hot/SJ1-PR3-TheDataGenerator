package com.sj1.pr3.savefile;

import java.io.File;

import org.junit.Test;

import junit.framework.Assert;
import junit.framework.TestCase;

public class TestSaveFile extends TestCase {

	public TestSaveFile(String name) {
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
		File file = new File("/Users/slim/git/SJ1-PR3-TheDataGenerator/SR1-PR3-TheDataGenerator/generatedText.txt");
		Assert.assertTrue(file.exists());
	}

}
