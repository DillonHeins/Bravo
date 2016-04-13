/**
*	Author: Charl Jansen van Vuuren
*	Student number: 13054903
*	Bravo-People
*	Person Interface
*   This File defines the Person Interface to be implemented.
*/

package bravo.people.interfaces;
import java.util.LinkedList;
import bravo.people.implementations.ResearchGroupAssociation;
import bravo.people.implementations.ResearchCategory;
import bravo.people.implementations.Organisation;

public interface PersonInterface
{
    public enum UserRight {
        RESEARCHER, RESEARCHGROUPLEADER, ADMIN
    }
    /**
     * Sets the person's name
     * @param firstName Name of the person to be set to.
     */
    public void setFirstName(String firstName);

    /**
     * Sets the person's surname
     * @param surname Surname to be set to.
     */
    public void setSurname(String surname);
    
    /**
     * Sets the person's Staff Number
     * @param staffNumber Staff Number to be set to.
     */
    public void setStaffNumber(String staffNumber);
    
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
    public String getFirstName();
    
    /**
     * 
     * @return Surname of the Person
     */
    public String getSurname();
    
    /**
     * 
     * @return staffNumber of the Person
     */
    public String getStaffNumber();
    
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
    public String getUserRights();
    
    /**
     * 
     * @return string of the object, to be defined in concrete classes
     */
    @Override
    public String toString();
}