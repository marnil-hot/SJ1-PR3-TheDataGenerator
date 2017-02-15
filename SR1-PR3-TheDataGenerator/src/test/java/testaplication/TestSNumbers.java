package testaplication;

import org.junit.Test;

import aplicationTeam2.SNumbers;
import junit.framework.Assert;
import junit.framework.TestCase;

/* Made by Marius Ilie.
* SBigChars generator creates Numbers Chars depends on how many the user want to generate.
* The size should always be the same as imput field.
*/
public class TestSNumbers extends TestCase {

	private int size = 30;

	public TestSNumbers(String name) {
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
		SNumbers Generator = new SNumbers();
		
	
			Assert.assertEquals(Generator.gNumbers(30).length(), size);
		
	}

}