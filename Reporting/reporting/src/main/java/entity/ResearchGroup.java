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
 * The Research Group that the Person falls under.
 * The third table in the People database
 */

@Entity
@Table(name = "researchgroup")
@NamedQueries
({
    @NamedQuery(name = "Researchgroup.findAll", query = "SELECT r FROM ResearchGroup r"),
    @NamedQuery(name = "Researchgroup.findByRgroupid", query = "SELECT r FROM ResearchGroup r WHERE r.rGroupID = :rgroupid"),
    @NamedQuery(name = "Researchgroup.findByEnddate", query = "SELECT r FROM ResearchGroup r WHERE r.endDate = :enddate"),
    @NamedQuery(name = "Researchgroup.findByGroupname", query = "SELECT r FROM ResearchGroup r WHERE r.groupName = :groupname"),
    @NamedQuery(name = "Researchgroup.findByStartdate", query = "SELECT r FROM ResearchGroup r WHERE r.startDate = :startdate")
})

public class ResearchGroup implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int rGroupID;
	private String groupName;
	private Date startDate;
	private Date endDate;
	
	public ResearchGroup()
	{
		super();
	}
	
	public ResearchGroup(int id, String name, Date sDate, Date eDate)
	{
		super();
		this.rGroupID = id;
		this.groupName = name;
		this.startDate = sDate;
		this.endDate = eDate;
	}
	
	int getGroupID()
	{
		return rGroupID;
	}
	
	String getGroupName()
	{
		return groupName;
	}
	
	Date getStartDate()
	{
		return startDate;
	}
	
	Date getEndDate()
	{
		return endDate;
	}
	
	void setGroupID(int inID)
	{
		this.rGroupID = inID;
	}
	
	void setGroupName(String inName)
	{
		this.groupName = inName;
	}
	
	void setStartDate(Date inDate)
	{
		this.startDate = inDate;
	}

	void setEndDate(Date inDate)
	{
		this.endDate = inDate;
	}
}
