/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestEntities;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Entities.Publicationtype;
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
public class TestPublicationType {

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
        PublicationType f=manager.find(PublicationType.class, new Integer(2));
        System.out.println(f.getName());
        */
        String ng="";
        TypedQuery<Publicationtype> query= manager.createNamedQuery("Publicationtype.findById",Publicationtype.class);
        query.setParameter("id", 2);     //name is what I am searching by, 'red meat' is the search
        List results=query.getResultList();
        
        Publicationtype f1=(Publicationtype) results.get(0);    
        System.out.println(f1.getName());
        Date mydate;
        
        
        //CriteriaBuilder cb=manager.getCriteriaBuilder();
        //CriteriaQuery<ConfigurationEntry> cq=cb.createQuery(ConfigurationEntry.class);
        /*
        //To add a row
        PublicationType f=new PublicationType();
        f.setName("Blue meat");
        f.setPrice((float) 25.5);
        
        manager.getTransaction().begin();
        manager.persist(f);
        manager.getTransaction().commit();
        */
        
        /*
        //change a characteristic
        PublicationType f=manager.find(PublicationType.class, new Integer(2));
        f.setPrice((float)15.0);
        manager.getTransaction().begin();
        manager.persist(f);
        manager.getTransaction().commit();
        */
        
        /*
        //To remove a row
        PublicationType f=manager.find(PublicationType.class, new Integer(3));
        manager.getTransaction().begin();
        manager.remove(f);
        manager.getTransaction().commit();
        */
        
    }
    
}

