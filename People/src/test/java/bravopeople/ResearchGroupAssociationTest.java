package bravopeople;

import java.util.Date;
import junit.framework.TestCase;
public class ResearchGroupAssociationTest extends TestCase
{
    public ResearchGroupAssociationTest(String testName){ super(testName); }

    /**
     *
     * TODO: Add proper tests once code is in place.
     * Tests
     *  - None as of yet
     */
    public void testResearchGroupAssociation()
    {
        Date d = new Date();
        ResearchGroupAssociation test = new ResearchGroupAssociation();
        test.setStartDate(d);
        assertEquals(d, test.getStartDate());
        assertEquals(null, test.getEndDate());
    }
}
