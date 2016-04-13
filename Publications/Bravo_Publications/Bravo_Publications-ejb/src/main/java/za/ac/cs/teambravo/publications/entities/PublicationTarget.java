
package za.ac.cs.teambravo.publications.entities;

import java.io.Serializable;
import java.net.URL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class PublicationTarget implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer targetID;
    
    @Column
    private String name;
    
    @Column
    private URL website;

    public PublicationTarget() {
        super();
    }
   
    public PublicationTarget(Integer targetID, String name, URL website) {
        super();
        this.targetID = targetID;
        this.name = name;
        this.website = website;
    }
    
    

    public Integer getTargetID() {
        return targetID;
    }

    public void setTargetID(Integer targetID) {
        this.targetID = targetID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public URL getWebsite() {
        return website;
    }

    public void setWebsite(URL website) {
        this.website = website;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (targetID != null ? targetID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PublicationTarget)) {
            return false;
        }
        PublicationTarget other = (PublicationTarget) object;
        if ((this.targetID == null && other.targetID != null) || (this.targetID != null && !this.targetID.equals(other.targetID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.cs.teambravo.publications.entities.PublicationTargets[ id=" + targetID + " ]";
    }
    
}
