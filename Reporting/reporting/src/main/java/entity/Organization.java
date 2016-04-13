package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The Organization that the Person belongs to.
 * The second table in the People database
 */
@Entity
@Table(name = "organization")
@NamedQueries
({
    @NamedQuery(name = "Organization.findAll", query = "SELECT o FROM Organization o"),
    @NamedQuery(name = "Organization.findByOrgid", query = "SELECT o FROM Organization o WHERE o.orgID = :orgid"),
    @NamedQuery(name = "Organization.findByOrgname", query = "SELECT o FROM Organization o WHERE o.orgName = :orgname")
})

public class Organization implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orgID;
	private String orgName;
	
	public Organization()
	{
		super();
	}
	
	public Organization(int id, String name)
	{
		super();
		this.orgID = id;
		this.orgName = name;
	}
	
	int getOrganizationID()
	{
		return orgID;
	}
	
	String getOrganizationName()
	{
		return orgName;
	}
	
	void setOrganizationID(int inID)
	{
		this.orgID = inID;
	}
	
	void setOrganizationName(String inName)
	{
		this.orgName = inName;
	}
}
