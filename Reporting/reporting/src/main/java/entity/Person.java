package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the person database table.
 * 
 */
@Entity
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int personID;

	private String emails;

	private String firstNames;

	private int organizationID;

	private int researchCategoryID;

	private int researchGroupID;

	private String surname;

	public Person() {
	}

	public int getPersonID() {
		return this.personID;
	}

	public void setPersonID(int personID) {
		this.personID = personID;
	}

	public String getEmails() {
		return this.emails;
	}

	public void setEmails(String emails) {
		this.emails = emails;
	}

	public String getFirstNames() {
		return this.firstNames;
	}

	public void setFirstNames(String firstNames) {
		this.firstNames = firstNames;
	}

	public int getOrganizationID() {
		return this.organizationID;
	}

	public void setOrganizationID(int organizationID) {
		this.organizationID = organizationID;
	}

	public int getResearchCategoryID() {
		return this.researchCategoryID;
	}

	public void setResearchCategoryID(int researchCategoryID) {
		this.researchCategoryID = researchCategoryID;
	}

	public int getResearchGroupID() {
		return this.researchGroupID;
	}

	public void setResearchGroupID(int researchGroupID) {
		this.researchGroupID = researchGroupID;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}