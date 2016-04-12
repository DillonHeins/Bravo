package sam;

import java.util.Date;

public class PersonReport extends Report 
{	
	private static Date d = new Date();
	private Person thisGuy = null;
	
	public PersonReport(String name,String sName,String type)throws NullPersonException{
		if(name == null || sName == null || type == null){	
			throw new NullPersonException();
		}
		thisGuy= new Person(name,sName,type);
	}
	
	public void viewPersonReport()
	{
		System.out.println("Name: "+thisGuy.getPName());
		System.out.println("Surname: "+thisGuy.getSName());
		System.out.println("Number of publications: 6");
	}
	
	public static void main(String[] args)
	{
		
	}
}