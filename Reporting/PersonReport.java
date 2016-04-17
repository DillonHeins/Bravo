public class PersonReport //implements Reports
{
	public void viewPersonReport(String pName, String pSurname/*Date Date*/)
	{
		System.out.println("Name: "+pName);
		System.out.println("Surname: "+pSurname);
		System.out.println("Number of publications: 6");
	}
	
	public static void main(String[] args)
	{
		Person thisGuy= new Person("Stan","Marsh","Person");
		PersonReport hisReport = new PersonReport();
		
		hisReport.viewPersonReport(thisGuy.getName(), thisGuy.getSName());
	}
}