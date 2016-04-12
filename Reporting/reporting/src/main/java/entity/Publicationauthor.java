package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the publicationauthors database table.
 * 
 */
@Entity
@Table(name="publicationauthors")
@NamedQuery(name="Publicationauthor.findAll", query="SELECT p FROM Publicationauthor p")
public class Publicationauthor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int publicationAuthorsID;

	private int personID;

	//bi-directional many-to-one association to Publication
	@ManyToOne
	@JoinColumn(name="PublicationID")
	private Publication publication;

	//bi-directional many-to-one association to Publicationdetail
	@OneToMany(mappedBy="publicationauthor")
	private List<Publicationdetail> publicationdetails;

	public Publicationauthor() {
	}

	public int getPublicationAuthorsID() {
		return this.publicationAuthorsID;
	}

	public void setPublicationAuthorsID(int publicationAuthorsID) {
		this.publicationAuthorsID = publicationAuthorsID;
	}

	public int getPersonID() {
		return this.personID;
	}

	public void setPersonID(int personID) {
		this.personID = personID;
	}

	public Publication getPublication() {
		return this.publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}

	public List<Publicationdetail> getPublicationdetails() {
		return this.publicationdetails;
	}

	public void setPublicationdetails(List<Publicationdetail> publicationdetails) {
		this.publicationdetails = publicationdetails;
	}

	public Publicationdetail addPublicationdetail(Publicationdetail publicationdetail) {
		getPublicationdetails().add(publicationdetail);
		publicationdetail.setPublicationauthor(this);

		return publicationdetail;
	}

	public Publicationdetail removePublicationdetail(Publicationdetail publicationdetail) {
		getPublicationdetails().remove(publicationdetail);
		publicationdetail.setPublicationauthor(null);

		return publicationdetail;
	}

}