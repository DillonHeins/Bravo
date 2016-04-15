package ejb;

import java.util.List;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.*;

@Local
@Stateless(mappedName="LifeCycleStateBean")
public class LifeCycleStateBean {
	@PersistenceContext(unitName = "reporting")
	private EntityManager entityManager;

	public List<Lifecyclestate> getLifecycleStateByPublicationState(Publicationstate inState) {
		//getPublicationByPerson
		Query query = entityManager.createQuery("SELECT p.Lifecyclestate WHERE p.lifeCycleStateID = :lifecyclestateID");
		query.setParameter("lifecyclestateID", inState.getPublicationStateID());
		return (List<Lifecyclestate>) query.getResultList();
	}
	
	public String getLifecycleStateStatus(Lifecyclestate inLifecycle) {
		if(inLifecycle.getAccepted()) return "Accepted";
		else if(inLifecycle.getInRevision()) return "In Rivision";
		else if(inLifecycle.getSubmitted()) return "Submitted";
		else if(inLifecycle.getInprogressstate() != null) return "In Progress";
		else return "";
	}
}
