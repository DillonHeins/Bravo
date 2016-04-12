package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the publications database table.
 * 
 */
@Entity
@Table(name="publications")
@NamedQuery(name="Publication.findAll", query="SELECT p FROM Publication p")
public class Publication implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int publicationID;

	private int publicationTargetID;

	private int publicationTypeID;

	//bi-directional many-to-one association to Publicationauthor
	@OneToMany(mappedBy="publication")
	private List<Publicationauthor> publicationauthors;

	//bi-directional many-to-one association to Publicationdetail
	@ManyToOne
	@JoinColumn(name="PublicationDetailsID")
	private Publicationdetail publicationdetail;

	//bi-directional many-to-one association to Publicationstate
	@ManyToOne
	@JoinColumn(name="PublicationStateID")
	private Publicationstate publicationstate;

	public Publication() {
	}

	public int getPublicationID() {
		return this.publicationID;
	}

	public void setPublicationID(int publicationID) {
		this.publicationID = publicationID;
	}

	public int getPublicationTargetID() {
		return this.publicationTargetID;
	}

	public void setPublicationTargetID(int publicationTargetID) {
		this.publicationTargetID = publicationTargetID;
	}

	public int getPublicationTypeID() {
		return this.publicationTypeID;
	}

	public void setPublicationTypeID(int publicationTypeID) {
		this.publicationTypeID = publicationTypeID;
	}

	public List<Publicationauthor> getPublicationauthors() {
		return this.publicationauthors;
	}

	public void setPublicationauthors(List<Publicationauthor> publicationauthors) {
		this.publicationauthors = publicationauthors;
	}

	public Publicationauthor addPublicationauthor(Publicationauthor publicationauthor) {
		getPublicationauthors().add(publicationauthor);
		publicationauthor.setPublication(this);

		return publicationauthor;
	}

	public Publicationauthor removePublicationauthor(Publicationauthor publicationauthor) {
		getPublicationauthors().remove(publicationauthor);
		publicationauthor.setPublication(null);

		return publicationauthor;
	}

	public Publicationdetail getPublicationdetail() {
		return this.publicationdetail;
	}

	public void setPublicationdetail(Publicationdetail publicationdetail) {
		this.publicationdetail = publicationdetail;
	}

	public Publicationstate getPublicationstate() {
		return this.publicationstate;
	}

	public void setPublicationstate(Publicationstate publicationstate) {
		this.publicationstate = publicationstate;
	}

}