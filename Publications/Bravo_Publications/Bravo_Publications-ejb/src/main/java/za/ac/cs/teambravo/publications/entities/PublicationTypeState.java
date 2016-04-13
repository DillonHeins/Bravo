
package za.ac.cs.teambravo.publications.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;


@Entity
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn(name="StateOfType")
public class PublicationTypeState implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer activationID;
    
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateEffective;


    public PublicationTypeState() {
        super();
    }
    
    public PublicationTypeState(Integer activationID, Date dateEffective) {
        super();
        this.activationID = activationID;
        this.dateEffective = dateEffective;
    }

    public Integer getId() {
        return activationID;
    }

    public void setId(Integer id) {
        this.activationID = id;
    }
    
    public Date getDateEffective() {
        return dateEffective;
    }

    public void setDateEffective(Date dateEffective) {
        this.dateEffective = dateEffective;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (activationID != null ? activationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PublicationTypeState)) {
            return false;
        }
        PublicationTypeState other = (PublicationTypeState) object;
        if ((this.activationID == null && other.activationID != null) || (this.activationID != null && !this.activationID.equals(other.activationID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.cs.teambravo.publications.entities.TypeActivationState[ id=" + activationID + " ]";
    }
    
}
