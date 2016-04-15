package bravopeople;

import junit.framework.TestCase;

public class OrganisationTest extends TestCase
{
    public OrganisationTest(String testName){ super(testName); }

    /**
     *
     * TODO: Add proper tests once code is in place.
     * Tests
     *  - Contructor name is same as getName
     */
    public void testOrganisation()
    {
        Organisation test = new Organisation();
        assertEquals("Organisation", test.getName());
    }
}
