
package za.ac.cs.teambravo.publications.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity
public class PublicationDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer detailsID;
   
    private String title;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date envisagedPublicationDate;
    
    @OneToMany(targetEntity = Person.class)
    private ArrayList authors; //These IDS are keys to the persons table

    public PublicationDetails() {
        super();
    }

    public PublicationDetails(Integer detailsID, String title, ArrayList authors, Date envisagedPublicationDate) {
        this.detailsID = detailsID;
        this.title = title;
        this.authors = authors;
        this.envisagedPublicationDate = envisagedPublicationDate;
    }

    public Integer getDetailsID() {
        return detailsID;
    }

    public void setDetailsID(Integer detailsID) {
        this.detailsID = detailsID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getEnvisagedPublicationDate() {
        return envisagedPublicationDate;
    }

    public void setEnvisagedPublicationDate(Date envisagedPublicationDate) {
        this.envisagedPublicationDate = envisagedPublicationDate;
    }
    
    public ArrayList getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList authors) {
        this.authors = authors;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detailsID != null ? detailsID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PublicationDetails)) {
            return false;
        }
        PublicationDetails other = (PublicationDetails) object;
        if ((this.detailsID == null && other.detailsID != null) || (this.detailsID != null && !this.detailsID.equals(other.detailsID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.cs.teambravo.publications.entities.PublicationDetails[ id=" + detailsID + " ]";
    }
    
}
