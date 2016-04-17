public class Person extends Entity
{
	protected String surname;
	
	Person()
	{
		//Person("Stan","Marsh","Person");
	}
	
	Person (String eName, String sname, String eType)
	{
		super(eName, eType);
		this.surname= sname;
	}
	
	String getPName()
	{
		return getName();
	}
	
	String getSName()
	{
		return surname;
	}
}