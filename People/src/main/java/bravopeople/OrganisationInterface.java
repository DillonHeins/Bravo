
/**
 * <h1>Organisation Interface</h1>
 * This File defines the Organisation Interface to be implemented.
 * @author Bravo Team
 * @version 1.0
*/

package bravopeople;


public interface OrganisationInterface
{        	
	/**
	* Sets the Organisation's name	
	* @param name Name of the Organisation to be set to.
	*/
	public void setName(String name);
	
	/**
	* Sets the Persons ID
	* @param id ID of the Person to be set to.
	*/
	public void setID(String id);
		
	/**
	* @return name of the Organisation
	*/	
	public String getName();
}
