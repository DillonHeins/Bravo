package reporting;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ejb.*;
import entity.*;

public class LifeCycleStateTest {
	@Autowired
	private PersonServiceBean person;
	@Autowired
	private PublicationServiceBean publication;
	@Autowired
	private ResearchGroupServiceBean group;
	@Autowired
	private ResearcherCategoryServiceBean category;
	
	@Test
	public void testPersonGet() {
		Person p = person.getPersonByID(1);
		Assert.assertNotNull(p);
	}
	
	@Test
	public void testPublicationsGet() {
		Person p = person.getPersonByID(1);
		List<Publication> pubs = publication.getPublcationsByPerson(p);
		Assert.assertNotNull(pubs);
	}
	
	@Test
	public void testLifeCycleGet() {
		Person p = person.getPersonByID(1);
		List<Publication> pubs = publication.getPublcationsByPerson(p);
		Publication thisPub = pubs.get(0);
		Assert.assertNotNull(thisPub);
	}
	
	@Test
	public void testResearchGroupGet() {
		Person p = person.getPersonByID(1);
		ResearchGroup thisGroup = group.getResearchGroupByID(p.getResearchGroupID());
		Assert.assertNotNull(thisGroup);
	}
	
	@Test
	public void testResearcherCategoryGet() {
		Person p = person.getPersonByID(1);
		ResearcherCategory thisCategory = category.getResearcherCategoryByID(p.getResearchCategoryID());
		Assert.assertNotNull(thisCategory);
	}
	
}
