package bravo.people.ejb;

import bravo.people.implementations.Person;
import bravo.people.entity.*;
import bravo.people.implementations.Group;
import bravo.people.implementations.Organisation;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Dillon
 */
@Stateless
@LocalBean
public class PeopleBean {
    public void addPerson(String firstName, String surname, String staffNumber, String email, String groupName, String organisationName) {
        Person person = new Person(firstName, surname, staffNumber, email);
        Group group = new Group(groupName);
        Organisation organisation = new Organisation(organisationName);
        PersonEntity personEntity = new PersonEntity(person, group, organisation);
        em.persist(personEntity);
    }

    public String getID() {
        Query query = em.createNamedQuery("getID");
        query.setParameter("emailAddress", "kenny@gmail.com");
        Long ID = (Long) query.getSingleResult();
        return "xx" + ID;
    }
    
    public String getPerson() {
        PersonEntity personEntity = em.find(PersonEntity.class, 1051L);
        return personEntity.getPerson().getFirstName() + " " + personEntity.getPerson().getSurname() + " "
                + personEntity.getPerson().getStaffNumber() + " " + personEntity.getPerson().getEmail() + " "
                + personEntity.getGroup().getName();
    }
    
    @PersistenceContext
    private EntityManager em;
}
