public class Entity
{
	protected String name;
	protected String entityType;
	protected String date;
	protected int involvements;
	
	Entity()
	{
		
	}
	
	Entity(String eName, String eType)
	{
		this.name = eName;
		this.entityType = eType;
		this.date = "2016/01/01";
	}
	
	String getName()
	{
		return name;
	}
	
	String getEntityType()
	{
		return entityType;
	}
}	