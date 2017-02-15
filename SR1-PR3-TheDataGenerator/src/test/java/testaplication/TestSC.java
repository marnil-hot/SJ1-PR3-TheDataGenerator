package testaplication;

import org.junit.Assert;
import org.junit.Test;

import aplicationTeam2.SSmallChars;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
/**
 * @author mariusilie
 *
 */
public class TestSC extends TestCase {

	private String mystring = "siri";

	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public TestSC(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static TestSuite suite() {
		return new TestSuite(TestSC.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		assertTrue(true);
	}

	@Test
	public void testSBC() {
		SSmallChars Generator = new SSmallChars();

		Assert.assertEquals(Generator.equals(mystring), false);

	}
}