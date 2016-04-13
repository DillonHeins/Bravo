package entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The Category of research that the Person is doing.
 * The fourth table in the People database
 */

@Entity
@Table(name = "researchercategory")
@NamedQueries
({
    @NamedQuery(name = "Researchercategory.findAll", query = "SELECT r FROM ResearcherCategory r"),
    @NamedQuery(name = "Researchercategory.findByRcatid", query = "SELECT r FROM ResearcherCategory r WHERE r.rCatID = :rcatid"),
    @NamedQuery(name = "Researchercategory.findByCategoryname", query = "SELECT r FROM ResearcherCategory r WHERE r.categoryName = :categoryname"),
    @NamedQuery(name = "Researchercategory.findByEffectivedate", query = "SELECT r FROM ResearcherCategory r WHERE r.effectiveDate = :effectivedate")
})

public class ResearcherCategory implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int rCatID;
	private String categoryName;
	private Date effectiveDate;
	
	public ResearcherCategory()
	{
		super();
	}
	
	public ResearcherCategory(int id, String name, Date date)
	{
		super();
		this.rCatID = id;
		this.categoryName = name;
		this.effectiveDate = date;
	}
	
	int getCategoryID()
	{
		return rCatID;
	}
	
	String getcategoryName()
	{
		return categoryName;
	}
	
	Date geteffectiveDate()
	{
		return effectiveDate;
	}
	
	void setCategoryID(int inID)
	{
		this.rCatID = inID;
	}
	
	void setcategoryName(String inName)
	{
		this.categoryName = inName;
	}
	
	void seteffectiveDate(Date inDate)
	{
		this.effectiveDate = inDate;
	}
}
