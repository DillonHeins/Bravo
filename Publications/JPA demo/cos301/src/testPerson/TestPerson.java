/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testPerson;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Entities.Person;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author moses
 */
public class TestPerson {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) 
    {
        // TODO code application logic here
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("cos301PU"); //"JPA1" is the project name and the "PU" is added by the system
        EntityManager manager=factory.createEntityManager();
        
        /*
        //To search by ID
        Person f=manager.find(Person.class, new Integer(2));
        System.out.println(f.getName());
        */
        String ng="";
        TypedQuery<Person> query= manager.createNamedQuery("Person.findByFirstname",Person.class);
        query.setParameter("firstname", "Hlengekile");     //name is what I am searching by, 'red meat' is the search
        List results=query.getResultList();
        
        Person f1=(Person) results.get(0);    
        System.out.println(f1.getSurname());
        Date mydate;
        
        
        //CriteriaBuilder cb=manager.getCriteriaBuilder();
        //CriteriaQuery<ConfigurationEntry> cq=cb.createQuery(ConfigurationEntry.class);
        /*
        //To add a row
        Person f=new Person();
        f.setName("Blue meat");
        f.setPrice((float) 25.5);
        
        manager.getTransaction().begin();
        manager.persist(f);
        manager.getTransaction().commit();
        */
        
        /*
        //change a characteristic
        Person f=manager.find(Person.class, new Integer(2));
        f.setPrice((float)15.0);
        manager.getTransaction().begin();
        manager.persist(f);
        manager.getTransaction().commit();
        */
        
        /*
        //To remove a row
        Person f=manager.find(Person.class, new Integer(3));
        manager.getTransaction().begin();
        manager.remove(f);
        manager.getTransaction().commit();
        */
        
    }
    
}

