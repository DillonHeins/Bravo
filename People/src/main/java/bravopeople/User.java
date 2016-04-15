package bravopeople;

import java.util.ArrayList;
/**
 * @author Bravo Team
 *	@version 1.0
 *	This file defines the User Class for the management of user rights.
 *	The class defines the attributes of the user of the system.
 */
public class User implements UserInterface
{
    private Person _person;
    private String hashedPass;

    public User(Person p)
    {
        _person = p;
    }

    private boolean hasAuth(String auth)
    {
        return false;
    }

    public void addPerson(Person person)
    {

    }

    public void editPersonDetails(Person person)
    {

    }

    public void endResearchGroupAssociation(ResearchGroupAssociation rga)
    {

    }

    public void addResearchGroupAssociation(ResearchGroupAssociation rga)
    {

    }

    public void addResearcherCategory(ResearchCategory rc)
    {

    }

    public void modifyResearcherCategory(ResearchCategory rc)
    {

    }

    public void addResearchGroup(Group group)
    {

    }

    public void suspendResearchGroup(Group group)
    {

    }

    public void reactivateResearchGroup(Group group)
    {

    }
}
