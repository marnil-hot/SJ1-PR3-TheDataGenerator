package testaplication;

import org.junit.Assert;
import org.junit.Test;

import aplicationTeam2.SNumbers;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
/**
 * @author mariusilie
 *
 */
public class testSN1 extends TestCase {

	private int mynum = 4;

	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public testSN1(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static TestSuite suite() {
		return new TestSuite(testSN1.class);
	}

	/**
	 * Rigourous Test 
	 */
	public void testApp() {
		assertTrue(true);
	}

	@Test
	public void testSBC() {
		SNumbers Generator = new SNumbers();

		Assert.assertEquals(Generator.equals(mynum), true);

	}
}