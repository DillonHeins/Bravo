/**
 * @author Bravo Team
 * @version 1.0
 * Person Interface
 * This File defines the Person Interface to be implemented.
 */

package bravo.people.interfaces;
import java.util.LinkedList;
import bravo.people.implementation;


public interface PersonInterface
{
    /**
     * Sets the person's name
     * @param name Name of the person to be set to.
     */
    public void setName(String name);

    /**
     * Sets the person's surname
     * @param surname Surname to be set to.
     */
    public void setSurname(String surname);
    
    /**
     * Sets the person's ID
     * @param id ID to be set to.
     */
    public void setID(String id);
    
    /**
     * Sets the person's Primary email address 
     * @param email Primary email to be set to.
     */
    public void setEmail(String email);
    
    /**
	* Sets the organisation the person belongs to.
	* @param organisation Organisation to be set to.
    */
    public void setOrganisation(String organisation);
    
    /**
     * Sets the Research Group associated with that Person.
     * @param group Group to be set to.
     */
    public void setResearchGroupAssociation(ResearchGroupAssociation group);
    
    /**
     * Sets the Person's Research Category
     * @param category Category to be set.
     */
    public void setResearchCategory(ResearchCategory category);
    
    /**
     * 
     * @return Name of the Person
     */
    public String getName();
    
    /**
     * 
     * @return Surname of the Person
     */
    public String getSurname();
    
    /**
     * 
     * @return ID of the Person
     */
    public String getID();
    
    /**
     * 
     * @return Primary email of the Person
     */
    public String getEmail();
    
    /**
     * 
     * @return List of Organisations the Person belongs to.
     */
    public LinkedList<Organisation> getOrganisation();
    
    /**
     * 
     * @return List of research categories this person is associated with.
     */
    public LinkedList<ResearchCategory> getResearchCategory();
    
    /**
     * 
     * @return List of research groups this person is associated with.
     */
    public LinkedList<ResearchGroupAssociation> getResearchGroupAssociation();



    /**
     *  Setter
     *  Set the user rights.
     * @param right Can be:
     *              ADMIN
     *              RESEARCHER
     *              RESEARCHGROUPLEADER
     */
    public void setUserRights(String right);

    /**
     * Getter
     * @return The user rights for the person. Returns:
     *                                          ADMIN
     *                                          RESEARCHER
     *                                          RESEARCHGROUPLEADER
     */
    public UserRight getUserRights();
    
    /**
     * 
     * @return string of the object, to be defined in concrete classes
     */
    @Override
    public String toString();
    
    
}