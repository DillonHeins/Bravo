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
        Person person = new Person();
        PersonEntity personEntity = new PersonEntity(person);
        em.persist(personEntity);
    }

    public String getPerson() {
//        List<String> firstNames = (List<String>) em.createNamedQuery("getPerson").getResultList();
//        return firstNames;
        Person tempPerson = (Person) em.createNamedQuery("getPerson").getSingleResult();
        return tempPerson.getEmail() + " " + tempPerson.getName();
    }
    
    @PersistenceContext
    private EntityManager em;
}
