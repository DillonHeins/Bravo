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
}
