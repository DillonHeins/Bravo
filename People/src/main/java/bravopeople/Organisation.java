/**
  *    @author Bravo Team
  *	@version 1.0
  *	This file defines the Organization Class for the Researcher Support System (RSS).
  */
	
package bravopeople;

class Organisation
{
	String name;
	//String ID;
	
	/**
	* Default Constructor with dummy data
	*/
	Organisation()
	{
		name="Organisation";
	}
	
	/**
	* 	Constructor creates a Organisation object
	* 	@param  organisation_name Name of the organisation
	*/
	Organisation(String organisation_name)
	{
		name = organisation_name;
	}
	
	/**
	* Setter 	
	* @param name Name of the Orgnisation
	*/
	public void setName(String name)
	{}
		
	/**
	* Getter
	* @return name of the Organisation
	*/	
	public  String getName()
	{
		return name;
	}
}


