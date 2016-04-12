package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the publicationdetails database table.
 * 
 */
@Entity
@Table(name="publicationdetails")
@NamedQuery(name="Publicationdetail.findAll", query="SELECT p FROM Publicationdetail p")
public class Publicationdetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int publicationDetailsID;

	@Temporal(TemporalType.DATE)
	private Date envisagedPublicationDate;

	private String title;

	//bi-directional many-to-one association to Publicationauthor
	@ManyToOne
	@JoinColumn(name="PublicationAuthorsID")
	private Publicationauthor publicationauthor;

	//bi-directional many-to-one association to Publication
	@OneToMany(mappedBy="publicationdetail")
	private List<Publication> publications;

	public Publicationdetail() {
	}

	public int getPublicationDetailsID() {
		return this.publicationDetailsID;
	}

	public void setPublicationDetailsID(int publicationDetailsID) {
		this.publicationDetailsID = publicationDetailsID;
	}

	public Date getEnvisagedPublicationDate() {
		return this.envisagedPublicationDate;
	}

	public void setEnvisagedPublicationDate(Date envisagedPublicationDate) {
		this.envisagedPublicationDate = envisagedPublicationDate;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Publicationauthor getPublicationauthor() {
		return this.publicationauthor;
	}

	public void setPublicationauthor(Publicationauthor publicationauthor) {
		this.publicationauthor = publicationauthor;
	}

	public List<Publication> getPublications() {
		return this.publications;
	}

	public void setPublications(List<Publication> publications) {
		this.publications = publications;
	}

	public Publication addPublication(Publication publication) {
		getPublications().add(publication);
		publication.setPublicationdetail(this);

		return publication;
	}

	public Publication removePublication(Publication publication) {
		getPublications().remove(publication);
		publication.setPublicationdetail(null);

		return publication;
	}

}