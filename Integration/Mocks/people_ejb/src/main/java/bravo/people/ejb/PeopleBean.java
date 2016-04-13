package bravo.people.ejb;

import bravo.people.implementations.Person;
import bravo.people.entity.*;
import bravo.people.implementations.Group;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import static org.mockito.Mockito.*;

/**
 *
 * @author Dillon
 */
@Stateless
@LocalBean
public class PeopleBean {
    public void addPerson(String firstName, String surname, String staffNumber, String email, String groupName) {
        Person person = new Person(firstName, surname, staffNumber, email);
        Group group = new Group(groupName);
        PersonEntity personEntity = new PersonEntity(person, group);
        em.persist(personEntity);
    }

    public String getID() {
        Long ID = (Long) em.createNamedQuery("getID").getSingleResult();
        return "" + ID;
    }
    
    public String getPerson() {
        PersonEntity personEntity = em.find(PersonEntity.class, 851L);
//        List<String> firstNames = (List<String>) em.createNamedQuery("getPerson").getResultList();
        return personEntity.getPerson().getFirstName() + " " + personEntity.getPerson().getSurname() + " "
                + personEntity.getPerson().getStaffNumber() + " " + personEntity.getPerson().getEmail() + " "
                + personEntity.getGroup().getName();
//        Person tempPerson = (Person) em.createNamedQuery("getPerson").getSingleResult();
//        return tempPerson.getEmail() + " " + tempPerson.getName();
    }
    
    @PersistenceContext
    private EntityManager em;
}
