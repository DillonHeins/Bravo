package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the publicationstate database table.
 * 
 */
@Entity
@Table(name="publicationstate")
@NamedQuery(name="Publicationstate.findAll", query="SELECT p FROM Publicationstate p")
public class Publicationstate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int publicationStateID;

	@Temporal(TemporalType.DATE)
	private Date changeDate;

	private String changeReason;

	//bi-directional many-to-one association to Publication
	@OneToMany(mappedBy="publicationstate")
	private List<Publication> publications;

	//bi-directional many-to-one association to Lifecyclestate
	@ManyToOne
	@JoinColumn(name="LifeCycleStateID")
	private Lifecyclestate lifecyclestate;

	public Publicationstate() {
	}

	public int getPublicationStateID() {
		return this.publicationStateID;
	}

	public void setPublicationStateID(int publicationStateID) {
		this.publicationStateID = publicationStateID;
	}

	public Date getChangeDate() {
		return this.changeDate;
	}

	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}

	public String getChangeReason() {
		return this.changeReason;
	}

	public void setChangeReason(String changeReason) {
		this.changeReason = changeReason;
	}

	public List<Publication> getPublications() {
		return this.publications;
	}

	public void setPublications(List<Publication> publications) {
		this.publications = publications;
	}

	public Publication addPublication(Publication publication) {
		getPublications().add(publication);
		publication.setPublicationstate(this);

		return publication;
	}

	public Publication removePublication(Publication publication) {
		getPublications().remove(publication);
		publication.setPublicationstate(null);

		return publication;
	}

	public Lifecyclestate getLifecyclestate() {
		return this.lifecyclestate;
	}

	public void setLifecyclestate(Lifecyclestate lifecyclestate) {
		this.lifecyclestate = lifecyclestate;
	}

}