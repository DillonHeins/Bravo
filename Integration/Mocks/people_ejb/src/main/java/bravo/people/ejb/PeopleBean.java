package bravo.people.ejb;

import bravo.people.implementations.Person;
import bravo.people.entity.*;
import bravo.people.exceptions.AddPersonException;
import bravo.people.implementations.Group;
import bravo.people.implementations.Organisation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Dillon
 */
@Stateless
@LocalBean
public class PeopleBean {
    public boolean addPerson(String firstName, String surname, String staffNumber, String email, String groupName, String organisationName) {
        try {
            Person person = new Person(firstName, surname, staffNumber, email);
            Group group = new Group(groupName);
            Organisation organisation = new Organisation(organisationName);
            PersonEntity personEntity = new PersonEntity(person, group, organisation);
            em.persist(personEntity);
        } catch (PersistenceException pe) {
            return false;
        }
        
        return true;
    }
    
    @PermitAll
    public boolean updatePerson(String firstName, String surname, String staffNumber, String email, String group, String organisation) {
        try {
            Long ID = getID(email);
            PersonEntity personEntity = em.find(PersonEntity.class, ID);
            personEntity.getPerson().setFirstName(firstName);
            personEntity.getPerson().setSurname(surname);
            personEntity.getPerson().setStaffNumber(staffNumber);
            personEntity.getGroup().setName(group);
            personEntity.getOrganisation().setName(organisation);
        } catch(PersistenceException pe) {
            return false;
        }
        
        return true;
    }

    public Long getID(String email) {
        Query query = em.createNamedQuery("getID");
        query.setParameter("emailAddress", email);
        Long ID = (Long) query.getSingleResult();
        return ID;
    }
    
    public PersonEntity getPerson(String email) {
        Long ID = getID(email);
        PersonEntity personEntity = em.find(PersonEntity.class, ID);
        return personEntity;
    }
    
    public Map<String, String> getPeopleList() {
        Query query = em.createQuery("SELECT p.person.emailAddress, p.person.firstName FROM PersonEntity p");
        List<Object[]> resultList = query.getResultList();
        Map<String, String> resultMap = new HashMap<>(resultList.size());
        for (Object[] result : resultList) {
            resultMap.put((String) result[0], (String) result[1]);
        }
        
        return resultMap;
    }
    
    public void deleteAll() {
        Query query = em.createQuery("DELETE FROM PersonEntity");
        query.executeUpdate();
    }
    
    @PersistenceContext
    private EntityManager em;
}
