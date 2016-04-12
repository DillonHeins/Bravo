package ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.*;
import entity.*;

@LocalBean
@Stateless(mappedName="PersonServiceBean")
public class PersonServiceBean {
	//Pass persistence unit to entity manager
	@PersistenceContext(unitName = "reporting")
	private EntityManager entityManager;
	
	public Person getPersonByID(int id) {
		return entityManager.find(Person.class, id);
	}
}
