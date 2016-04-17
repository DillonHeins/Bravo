package ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.*;
import entity.*;

@LocalBean
@Stateless(mappedName="ResearchGroupServiceBean")
public class ResearchGroupServiceBean {
	//Pass persistence unit to entity manager
	@PersistenceContext(unitName = "reporting")
	private EntityManager entityManager;
	
	public ResearchGroup getResearchGroupByID(int id) {
		return entityManager.find(ResearchGroup.class, id);
	}
}
