package bravopeople;

import java.util.ArrayList;

/**
 * @author Bravo Team
 *	@version 1.0
 *	This file defines the Interface for the User Class.
 *	The class defines the attributes of the user of the system.
 */
public interface UserInterface
{
    public void addPerson(Person person);

    public void editPersonDetails();

    public void endResearchGroupAssociation();

    public void addResearchGroupAssociation();

    public void addResearcherCategory();

    public void modifyResearcherCategory();

    public void addResearchGroup();

    public void suspendResearchGroup();

    public void reactivateResearchGroup();
}
