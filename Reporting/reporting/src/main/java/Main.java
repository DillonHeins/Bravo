import java.util.List;

import javax.persistence.*;
import entity.*;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("reporting");
		EntityManager em = emf.createEntityManager();
		
		Lifecyclestate life = em.find(Lifecyclestate.class, 3);
		System.out.println("Accepted: " + life.getAccepted() + " Submitted: " + life.getSubmitted() + " In Rivision: " + life.getInRevision());
		
		entity.Person p = em.find(entity.Person.class, 2);
		System.out.println(p.getFirstNames());
		Query query = em.createQuery("SELECT p.publication FROM Publicationauthor AS p WHERE p.personID = :personID");
		query.setParameter("personID", p.getPersonID());
		List<Publication> list = (List<Publication>) query.getResultList();
		for(Publication pub: list) 
			System.out.println(pub.getPublicationTypeID());
		
		/*Publicationauthor p = em.find(Publicationauthor.class, 2);
		System.out.println(p.getPersonID());*/
		//System.out.println("Success");
	}
}
