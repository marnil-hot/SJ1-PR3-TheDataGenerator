package testaplication;

import org.junit.Assert;
import org.junit.Test;

import aplicationTeam2.SBigChars;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
/**
 * @author mariusilie
 *
 */
public class TestSBC extends TestCase {

	private char mychar = ('s');

	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public TestSBC(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static TestSuite suite() {
		return new TestSuite(TestSBC.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		assertTrue(true);
	}

	@Test
	public void testSBC() {
		SBigChars Generator = new SBigChars();

	
			Assert.assertEquals(Generator.equals(mychar), false);
		
	}
}
