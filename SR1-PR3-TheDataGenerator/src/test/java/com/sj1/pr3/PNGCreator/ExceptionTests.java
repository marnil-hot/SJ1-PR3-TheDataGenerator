package com.sj1.pr3.PNGCreator;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.sj1.pr3.model.PNGCreator;

import junit.framework.TestCase;

public class ExceptionTests extends TestCase {
	private static final String filePath = "L:/asd.png";
	
	@Before
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	@After
	public void tearDown() throws Exception {
		super.tearDown();
		System.out.println("Test Completed");
	}
	
	/**
	 * Test to on purpose generate an exception if a file doesn't exist.
	 * @throws IOException
	 */
	@Test(expected = IOException.class)
	public void testFileNotFound() throws IOException {
		new File(filePath);
	}
}
