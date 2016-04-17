package bravopeople;

import junit.framework.TestCase;

public class GroupTest extends TestCase
{
    public GroupTest(String testName) { super(testName); }

    /**
     *
     * TODO: Add proper tests once code is in place.
     * Tests
     *  - Contructor name is same as getName
     */
    public void testGroup()
    {
        Group test = new Group();
        test.setName("testName");
        assertEquals("testName", test.getName());
    }
}
