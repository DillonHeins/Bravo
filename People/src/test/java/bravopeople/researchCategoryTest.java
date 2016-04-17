package bravopeople;

import junit.framework.TestCase;

import java.util.Date;

public class researchCategoryTest extends TestCase
{
    public researchCategoryTest(String testName) { super(testName); }

    /**
     *
     * TODO: Add proper tests once code is in place.
     * Tests
     *  - Contructor params is same as gets
     */
    public void testResearchCategory()
    {
        researchCategory test = new researchCategory("ID", "name", new Date(1451606400000L));
        assertEquals("ID", test.getID());
        assertEquals("name", test.getName());
        assertEquals(new Date(1451606400000L), test.getDate());
    }
}
