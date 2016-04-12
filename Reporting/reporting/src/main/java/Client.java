import javax.naming.InitialContext;
import javax.naming.NamingException;

import ejb.*;

public class Client {
	public void doStuff() throws NamingException {
		InitialContext ic = new InitialContext();
	    PersonServiceBean service = (PersonServiceBean)ic.lookup("PersonServiceBean");
	    entity.Person p = service.getPersonByID(1);
	    System.out.println(p.getFirstNames());
	}
}
