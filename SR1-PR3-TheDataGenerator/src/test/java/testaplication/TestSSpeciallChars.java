package testaplication;

import org.junit.Test;

import aplicationTeam2.SSpeciallChars;
import junit.framework.Assert;
import junit.framework.TestCase;

/* Made by Marius Ilie.
* SBigChars generator creates Speciall Chars depends on how many the user want to generate.
* The size should always be the same as imput field.
*/
public class TestSSpeciallChars extends TestCase {

	private int size = 10;

	public TestSSpeciallChars(String name) {
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
		SSpeciallChars Generator = new SSpeciallChars();
		
		try{
			Assert.assertEquals(Generator.gSpeciallChars(10).length(), size);
			System.out.println("Sucess!");	
		}catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		

	}

}