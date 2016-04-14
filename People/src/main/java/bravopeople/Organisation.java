/**
  * @author Bravo Team
  *	@version 1.0
  *	This file defines the Organization Class for the Researcher Support System (RSS).
  */
	
package bravo.people.implementations;

import bravo.people.interfaces.OrganisationInterface;

class Organisation implements OrganisationInterface
{
	String Name;
	String ID;
	
	/**
	* Default Constructor with dummy data
	*/
	Organisation()
	{
		Name="Organisation";
		ID="00000000000";
	}
	
	/**
	* 	Constructor creates a Organisation object
	* 	@param  organisation_name Name of the organisation
	*/
	Organisation(String organisation_name)
	{
		Name = organisation_name;
	}
	
	/**
	* 	Constructor creates a Organisation object with ID parameter. added incase object requires ID upon creation
	* 	@param  organisation_name Name of the organisation
	* 	@param id ID of the person
	*/
	Organisation(String organisation_name, String id)
	{
		Name = organisation_name;
		ID = id;
	}
	
	/**
	* Setter 	
	* @param name Name of the Orgnisation
	*/
	public void setName(String name)
	{
		Name=name;
		
	}
	
	/**
	* Setter
	* @param ID of the person
	*/
	public void setID(String id)
	{
		ID=id;
		
	}
		
	/**
	* Getter
	* @return name of the Organisation
	*/	
	public  String getName()
	{
		return Name;
	}
}


