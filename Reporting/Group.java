public class Group extends Entity
{
	protected String progress;
	protected String[] members;
	
	
	Group()
	{
		//Group("Team Bravo", "Group");
		this.progress = new String("80%");
		this.members = new String[] {"Memeber1", "Memeber 2", "Memeber 3"};
	}
	
	Group(String eName, String eType)
	{
		super(eName, eType);
	}
}