package testaplication;

import org.junit.Test;

import aplicationTeam2.SSmallChars;
import junit.framework.Assert;
import junit.framework.TestCase;

/* Made by Marius Ilie.
* SBigChars generator creates Small Chars depends on how many the user want to generate.
* The size should always be the same as imput field.
 */
public class TestSSmallChars extends TestCase {

	private int size = 20;

	public TestSSmallChars(String name) {
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
		SSmallChars Generator = new SSmallChars();
		
		try{
			Assert.assertEquals(Generator.gSmallChars(20).length(), size);
			System.out.println("Sucess!");	
		}catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		

	}

}