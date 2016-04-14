package bravo.people.implementations;

import java.util.ArrayList;
import bravo.people.interfaces.UserInterface;
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

    public void addResearcherCategory(ResearcherCategory rc)
    {

    }

    public void modifyResearcherCategory(ResearcherCategory rc)
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
