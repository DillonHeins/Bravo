/**
 * @author Bravo Team
 *	@version 1.0
 *	This file defines the Interface for the Research Category Class.
 *	The class defines the attributes of the user of the system.
 */
package bravo.people.interfaces;
import java.util.Date;

public interface ResearchCategoryInterface
{
	
	/**
	*  Gets the name of the research category 
	*  @return The name of the research category 
	*/
	public String getName();
			
	/**
	*  Sets the name of the research category 
	*  @param The name of the research category 
	*/
	public void setName(String Name);
	
	/**
	* Gets the Research Category ID
	* @return The ID of the research Category
	*/
	public String getID();
	
	/**
	* Sets the Research Category ID
	* @param The ID of the research Category
	*/
	public void setID(String ID);
	
	
	/**
	*  Gets the effective date of the research category 
	*  @return The effective date of the research category 
	*/
	public Date getDate();
	
	
	/**
	* Sets the Research Category effective date
	* @param The ID of the research Category
	*/
	public void setDate(Date date);
	
}

