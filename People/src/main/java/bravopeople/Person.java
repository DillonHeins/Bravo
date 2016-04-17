/**
  *    @author Bravo Team
  *	@version 1.0
  *	This file defines the Person Class for the Researcher Support System (RSS).
  *	The class defines the attributes of the user of the system.
  */

package bravopeople;
import java.util.LinkedList;

public class Person
{
	private String Name;
	private String Surname;
	private String ID;
	private String email_address;
	
	private LinkedList<Organisation> organisations;  	///Person can belong to 0 or more organisations
	private LinkedList<ResearchGroupAssociation> research_groups; 	///Person can have multiple associations with research groups
	private LinkedList<researchCategory> research_category;  ///Person may be associated with a research Category
	
	/**
		Default contructor with dummy data
	*/
	
	Person()
	{
		Name ="Name";
		Surname = "Surname";
		ID= "00000000000";
		email_address = "email@domain.com";
		
		organisations = new LinkedList<Organisation>();
		research_groups = new LinkedList<ResearchGroupAssociation>();
		research_category = new LinkedList<researchCategory>();
	}
	
	/**
	* 	Constructor creates a person object
	* 	@param  name Name of the person
	*	@param surname Surmane of the person
	*	@param id Identity number of the person
	*	@param email Email Address of the person
	*/
	Person(String name,String surname,String id,String email)
	{
		setName(name);
		setSurname(surname);
		setEmail(email);
		setID(id);
	}
	
	/**
	* Setter 	
	* @param name Name of the person
	*/
	public void setName(String name)
	{
		Name = name;
	}
	
	/**
	* Setter 	
	* @param surname Surname of the person
	*/
	public void setSurname(String surname)
	{
		Surname = surname;
	}
	
	/**
	* Setter 	
	* @param name The name of the person
	*/
	public void setID(String id)
	{
		ID = id;
	}
	
	/**
	* Setter 	
	* @param email primary Email Address of the person
	*/
	public void setEmail(String email)
	{
		email_address = email;
	}
	
	/**
	* Setter 	
	* @param organisation Name of the organisation the person belongs to.
	*/
	public void setOrganisation(String organisation)
	{
		organisations.add(new Organisation(organisation));
	}
	
	/**
	* Setter 	
	* @param group Research group that the of the person is associated with
	*/
	public void setResearchGroupAssociation(ResearchGroupAssociation group)
	{
		research_groups.add(group);
	}
	
	/**
	* Setter 	
	* @param category Research category that the of the person is associated with
	*/
	public void setResearchCategory(researchCategory category)
	{
		research_category.add(category);
	}
	
	
	/**
	* Getter
	* @return name of the person
	*/
	public String getName()
	{
		return Name;
	}
	
	/**
	* Getter
	* @return Surname of the person
	*/
	public String getSurname()
	{
		return Surname;
	}
	
	/**
	* Getter
	* @return Identity number of the person
	*/
	public String getID()
	{
		return ID;
	}
	
	/**
	* Getter
	* @return The  primary of the person
	*/
	String getEmail()
	{
		return email_address;
	}
	
	/**
	* Getter
	* @return the list of organisations this person belongs to or may return null if they do not belong to any organisations.
	*/
	
	public LinkedList<Organisation> getOrganisation()
	{
		if(this.organisations.isEmpty())
			return null;
		return organisations;
	}
	
	/**
	* Getter
	* @return the list of research categories this person is associated with or may return null if they if they are not associated with any.
	*/
	
	public LinkedList<researchCategory> getResearchCategory()
	{
		if(research_category.isEmpty())
			return null;
		else
			return research_category;
	}
	
	/**
	* Getter
	* @return the list of research groups this person is associated with or may return null if they if they are not associated with any.
	*/
	public LinkedList<ResearchGroupAssociation> getResearchGroupAssociation()
	{
		if(research_groups.isEmpty())
			return null;
		else
			return research_groups;
	}
}

  

