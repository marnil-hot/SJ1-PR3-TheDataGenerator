package testaplication;

import org.junit.Test;

import aplicationTeam2.SBigChars;
import junit.framework.Assert;
import junit.framework.TestCase;

/*
 * Made by Marius Ilie.
 * SBigChars generator createsBig Chars depends on how many the user want to generate.
 * The size should always be the same as imput field.
*/
public class TestSBigChars extends TestCase {

	private int size = 10;

	public TestSBigChars(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testSBigChars() {
		SBigChars Generator = new SBigChars();
		
		
			Assert.assertEquals(Generator.gBigChars(10).length(), size);
			System.out.println("Sucess!");	
		
		

	}

}
