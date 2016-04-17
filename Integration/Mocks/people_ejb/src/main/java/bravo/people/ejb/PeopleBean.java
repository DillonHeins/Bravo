package bravo.people.ejb;

import bravo.people.entity.*;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Dillon
 */
@Stateless
@LocalBean
public class PeopleBean {
    public void addPerson(String firstName, String surname, String staffNumber) {
        PersonEntity person = new PersonEntity(firstName, surname, staffNumber);
        em.persist(person);
    }

    public List<String> getPerson() {
        List<String> firstNames = (List<String>) em.createNamedQuery("getPerson").getResultList();
        return firstNames;
    }
    
    @PersistenceContext
    private EntityManager em;
}
