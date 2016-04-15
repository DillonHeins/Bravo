package bravopeople;

import junit.framework.TestCase;

import java.util.Date;

public class ResearchCategoryTest extends TestCase
{
    public ResearchCategoryTest(String testName) { super(testName); }

    /**
     *
     * TODO: Add proper tests once code is in place.
     * Tests
     *  - Contructor params is same as gets
     */
    public void testResearchCategory()
    {
        ResearchCategory test = new ResearchCategory("ID", "name", new Date(1451606400000L));
        assertEquals("ID", test.getID());
        assertEquals("name", test.getName());
        assertEquals(new Date(1451606400000L), test.getDate());
    }
}
