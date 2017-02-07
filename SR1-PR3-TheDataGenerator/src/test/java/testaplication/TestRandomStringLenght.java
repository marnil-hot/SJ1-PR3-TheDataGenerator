package testaplication;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestRandomStringLenght 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TestRandomStringLenght( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static TestSuite suite()
    {
        return new TestSuite( TestRandomStringLenght.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testTestRandomStringLenght ()
    {
        assertTrue( true );
    }
}