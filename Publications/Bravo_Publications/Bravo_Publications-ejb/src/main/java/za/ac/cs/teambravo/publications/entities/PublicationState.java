
package za.ac.cs.teambravo.publications.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class PublicationState implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer publicationID;
    
    @OneToOne
    private PublicationDetails details;
    
    @OneToOne
    private LifeCycleState state;
  
    @OneToOne
    private PublicationTarget target;
    
    @ManyToOne
    private PublicationType type; 

    public PublicationState() {
        super();
    }

    public PublicationState(Integer publicationID, PublicationDetails details, LifeCycleState state, PublicationTarget target, PublicationType type) {
        super();
        this.publicationID = publicationID;
        this.details = details;
        this.state = state;
        this.target = target;
        this.type = type;
    }

    public PublicationState(Date date, String reason, PublicationDetails publicationDetailsObject, LifeCycleState lifeCycleStateObject, PublicationType publicationTypeObject, PublicationTarget publicationTargetObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    public Integer getPublicationID() {
        return publicationID;
    }

    public void setPublicationID(Integer publicationID) {
        this.publicationID = publicationID;
    }

    public PublicationDetails getDetails() {
        return details;
    }

    public void setDetails(PublicationDetails details) {
        this.details = details;
    }

    public LifeCycleState getState() {
        return state;
    }

    public void setState(LifeCycleState state) {
        this.state = state;
    }

    public PublicationTarget getTarget() {
        return target;
    }

    public void setTarget(PublicationTarget target) {
        this.target = target;
    }

    public PublicationType getType() {
        return type;
    }

    public void setType(PublicationType type) {
        this.type = type;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (publicationID != null ? publicationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PublicationState)) {
            return false;
        }
        PublicationState other = (PublicationState) object;
        if ((this.publicationID == null && other.publicationID != null) || (this.publicationID != null && !this.publicationID.equals(other.publicationID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.cs.teambravo.publications.entities.Publications[ id=" + publicationID + " ]";
    }

    public LifeCycleState getLifeCycleStateObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
