package ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.*;
import entity.*;

@LocalBean
@Stateless(mappedName="LifecyclestateServiceBean")
public class LifecyclestateServiceBean {
	//Pass persistence unit to entity manager
	@PersistenceContext(unitName = "reporting")
	private EntityManager entityManager;
	
	public Lifecyclestate getLifecyclestateByID(int id) {
		return entityManager.find(Lifecyclestate.class, id);
	}
}
