package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.*;

@LocalBean
@Stateless
public class PublicationServiceBean {
	//Pass persistence unit to entity manager
	@PersistenceContext(unitName = "reporting")
	private EntityManager entityManager;
		
	public List<Publication> getPublcationsByPerson(Person person) {
		Query query = entityManager.createQuery("SELECT p.Publication WHERE p.personID = :personID");
		query.setParameter("personID", person.getPersonID());
		return (List<Publication>) query.getResultList();
	}
}
