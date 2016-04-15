package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the publishedstate database table.
 * 
 */
@Entity
@Table(name="publishedstate")
@NamedQuery(name="Publishedstate.findAll", query="SELECT p FROM Publishedstate p")
public class Publishedstate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int publishedID;

	@Lob
	private byte[] bibTexReference;

	@Temporal(TemporalType.DATE)
	private Date publicationDate;

	//bi-directional many-to-one association to Lifecyclestate
	@OneToMany(mappedBy="publishedstate")
	private List<Lifecyclestate> lifecyclestates;

	public Publishedstate() {
	}

	public int getPublishedID() {
		return this.publishedID;
	}

	public void setPublishedID(int publishedID) {
		this.publishedID = publishedID;
	}

	public byte[] getBibTexReference() {
		return this.bibTexReference;
	}

	public void setBibTexReference(byte[] bibTexReference) {
		this.bibTexReference = bibTexReference;
	}

	public Date getPublicationDate() {
		return this.publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public List<Lifecyclestate> getLifecyclestates() {
		return this.lifecyclestates;
	}

	public void setLifecyclestates(List<Lifecyclestate> lifecyclestates) {
		this.lifecyclestates = lifecyclestates;
	}

	public Lifecyclestate addLifecyclestate(Lifecyclestate lifecyclestate) {
		getLifecyclestates().add(lifecyclestate);
		lifecyclestate.setPublishedstate(this);

		return lifecyclestate;
	}

	public Lifecyclestate removeLifecyclestate(Lifecyclestate lifecyclestate) {
		getLifecyclestates().remove(lifecyclestate);
		lifecyclestate.setPublishedstate(null);

		return lifecyclestate;
	}

}