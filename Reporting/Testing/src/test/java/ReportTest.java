package test.java;
import sam.*;
import org.junit.Test;

//import NullPersonException;
//import PersonReport;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
 

public class ReportTest
{
	
	@Test
	public void constructor_notNullPerson()
	{
		try{
			PersonReport newP = new PersonReport("Stan","Morris","Person");
			newP.viewPersonReport();
		}
		catch (NullPersonException e){
			fail("Person contained null values");
		}
	}
	
	@Test(expected = NullPersonException.class)
	public void constructor_nullPerson() throws NullPersonException
	{
			PersonReport newP = new PersonReport("Stan",null,"Person");
			newP.viewPersonReport();
	}

  
  /*private static class ReportTest 
  {
	  
	  public ReportTest(String identifier, Parabola parabola, double[] roots) {
		super();
		this.identifier = identifier;
		this.parabola = parabola;
		this.roots = roots;
	}
  }*/
}
