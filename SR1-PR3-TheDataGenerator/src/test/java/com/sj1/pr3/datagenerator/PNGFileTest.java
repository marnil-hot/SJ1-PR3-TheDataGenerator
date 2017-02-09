package com.sj1.pr3.datagenerator;

import org.junit.Test;

import javafx.scene.paint.Color;
import junit.framework.TestCase;

public class PNGFileTest extends TestCase {
	
	public PNGFileTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	@Test
	public void testFileName() {
		String fileName = "snapshot1.png";
	    assertEquals(fileName, PNGFile.createPNG(500,500,Color.RED).getName());
	}


}
