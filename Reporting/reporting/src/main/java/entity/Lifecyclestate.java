package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the lifecyclestate database table.
 * 
 */
@Entity
@NamedQuery(name="Lifecyclestate.findAll", query="SELECT l FROM Lifecyclestate l")
public class Lifecyclestate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int lifeCycleStateID;

	private byte accepted;

	private byte inRevision;

	private byte submitted;

	//bi-directional many-to-one association to Inprogressstate
	@ManyToOne
	@JoinColumn(name="InProgressID")
	private Inprogressstate inprogressstate;

	//bi-directional many-to-one association to Publishedstate
	@ManyToOne
	@JoinColumn(name="PublishedID")
	private Publishedstate publishedstate;

	//bi-directional many-to-one association to Publicationstate
	@OneToMany(mappedBy="lifecyclestate")
	private List<Publicationstate> publicationstates;

	public Lifecyclestate() {
	}

	public int getLifeCycleStateID() {
		return this.lifeCycleStateID;
	}

	public void setLifeCycleStateID(int lifeCycleStateID) {
		this.lifeCycleStateID = lifeCycleStateID;
	}

	public byte getAccepted() {
		return this.accepted;
	}

	public void setAccepted(byte accepted) {
		this.accepted = accepted;
	}

	public byte getInRevision() {
		return this.inRevision;
	}

	public void setInRevision(byte inRevision) {
		this.inRevision = inRevision;
	}

	public byte getSubmitted() {
		return this.submitted;
	}

	public void setSubmitted(byte submitted) {
		this.submitted = submitted;
	}

	public Inprogressstate getInprogressstate() {
		return this.inprogressstate;
	}

	public void setInprogressstate(Inprogressstate inprogressstate) {
		this.inprogressstate = inprogressstate;
	}

	public Publishedstate getPublishedstate() {
		return this.publishedstate;
	}

	public void setPublishedstate(Publishedstate publishedstate) {
		this.publishedstate = publishedstate;
	}

	public List<Publicationstate> getPublicationstates() {
		return this.publicationstates;
	}

	public void setPublicationstates(List<Publicationstate> publicationstates) {
		this.publicationstates = publicationstates;
	}

	public Publicationstate addPublicationstate(Publicationstate publicationstate) {
		getPublicationstates().add(publicationstate);
		publicationstate.setLifecyclestate(this);

		return publicationstate;
	}

	public Publicationstate removePublicationstate(Publicationstate publicationstate) {
		getPublicationstates().remove(publicationstate);
		publicationstate.setLifecyclestate(null);

		return publicationstate;
	}

}