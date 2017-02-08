package com.sj1.pr3.PNGCreator;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.sj1.pr3.model.PNGCreator;
import com.sun.prism.paint.Color;

import junit.framework.TestCase;

public class PNGCreatorTest extends TestCase {
	
	private static final int EXPECTED_IMAGE_WIDTH = 100;
	private static final int EXPECTED_IMAGE_HEIGHT = 100;
	private static final int UNEXPECTED_IMAGE_WIDTH = 10;
	private static final int UNEXPECTED_IMAGE_HEIGHT = 10;
	private static final String EXPECTED_FILE_ABSOLUTE_PATH = "generated.png";
	private PNGCreator creator;
	
	public PNGCreatorTest(String name){
		super(name);
	}
	
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		creator = new PNGCreator();
	}
	
	@After
	protected void tearDown() throws Exception {
		super.tearDown();
		creator = null;
		System.out.println("Completed");
	}
	
	/**
	 * Testing to create an image.
	 * @throws Exception will be thrown if something goes wrong while creating the image file.
	 */
	@Test
	public void testCreateImage() throws Exception {
		creator.createImage(40, 40, "GREEN");
	}
	
	/**
	 * Test to check if the file we created was actually created and exists.
	 * @throws Exception will be thrown if something goes wrong while creating the image file.
	 * @throws IOException will be throws if something goes wrong while creating the file.
	 */
	@Test
	public void testFileExists() throws Exception, IOException {
		creator.createImage(40, 40, "YELLOW");
		File file = new File(creator.getAbsoluteFilePath());
		Assert.assertTrue(file.exists());
	}
	
	/**
	 * Test to check if the expected size matches the generated image size or not.
	 * @throws Exception will be thrown if something goes wrong.
	 */
	@Test
	public void testImageBounds() throws Exception {
		creator.createImage(100, 100, "BLUE");
		BufferedImage image = creator.loadImageFromPath(creator.getAbsoluteFilePath());
		
		Assert.assertEquals(EXPECTED_IMAGE_WIDTH, image.getWidth());
		Assert.assertEquals(EXPECTED_IMAGE_HEIGHT, image.getHeight());
		
		Assert.assertNotEquals(UNEXPECTED_IMAGE_WIDTH, image.getWidth());
		Assert.assertNotEquals(UNEXPECTED_IMAGE_HEIGHT, image.getHeight());
	}
	
	@Test
	public void testGetAbsolutePath() throws Exception {
		creator.createImage(40, 40, "RED");
		File file = new File(creator.getAbsoluteFilePath());
		Assert.assertEquals(EXPECTED_FILE_ABSOLUTE_PATH, file.getName());
	}
	
	/**
	 * Need this method here to make use of our interface. Writing unit tests for the actual methods above.
	 */
	public void getFileName() {
		
	}
	
	/**
	 * Need this method here to make use of our interface. Writing unit tests for the actual methods above.
	 */
	public void getFilePath(){
		
	}
}