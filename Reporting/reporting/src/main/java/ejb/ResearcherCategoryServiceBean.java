package ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.*;
import entity.*;

@LocalBean
@Stateless(mappedName="ResearcherCategoryServiceBean")
public class ResearcherCategoryServiceBean {
	//Pass persistence unit to entity manager
	@PersistenceContext(unitName = "reporting")
	private EntityManager entityManager;
	
	public ResearcherCategory getResearcherCategoryByID(int id) {
		return entityManager.find(ResearcherCategory.class, id);
	}
}
