package bravopeople;
import java.util.Date;
/**
*
* @author Aiden Malan
* 12265731
* Bravo-People
*/
public class ResearchCategory  implements ResearchCategoryInterface
{
	
	String ID;
	String name;
	Date effectiveDate;
	
	public ResearchCategory()
	{
		ID = "dummy12345";
		name = "dummy";
		effectiveDate = new Date();
	}
	
	public ResearchCategory(String _ID, String _name, Date _date)
	{
		ID = _ID;
		name = _name;
		effectiveDate = _date;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String _name)
	{
		name = _name;
	}
	
	public String getID()
	{
		return ID;
	}
	
	public void setID(String _ID)
	{
		ID = _ID;
	}
	
	public Date getDate()
	{
		return effectiveDate;
	}
	
	public void setDate(Date _date)
	{
		effectiveDate = _date;
	}
}