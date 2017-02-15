package testaplication;

import org.junit.Assert;
import org.junit.Test;

import aplicationTeam2.SSpeciallChars;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
/**
 * @author mariusilie
 *
 */
public class TestSSC extends TestCase {

	private double mydub = 85400.33;

	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public TestSSC(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static TestSuite suite() {
		return new TestSuite(TestSSC.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		assertTrue(true);
	}

	@Test
	public void testSBC() {
		SSpeciallChars Generator = new SSpeciallChars();

		Assert.assertEquals(Generator.equals(mydub), false);

	}
}