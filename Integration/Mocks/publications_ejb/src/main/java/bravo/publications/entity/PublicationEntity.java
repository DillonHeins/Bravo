package bravo.publications.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 *
 * @author Dillon
 */
@Entity
@NamedQuery(name = "getTitle",
        query = "SELECT p.title FROM PublicationEntity p WHERE p.staffNumber = '14035538'")
public class PublicationEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String title;
    private String staffNumber;

    public PublicationEntity() {
        
    }
    
    public PublicationEntity(String title, String staffNumber) {
        this.title = title;
        this.staffNumber = staffNumber;
    }
    
    public String getTitle() {
        return title;
    }

    public String getStaffNumber() {
        return staffNumber;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setStaffNumber(String staffNumber) {
        this.staffNumber = staffNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PublicationEntity)) {
            return false;
        }
        PublicationEntity other = (PublicationEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bravo.publications.entity.PublicationEntity[ id=" + id + " ]";
    }
    
}
