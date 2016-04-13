
package za.ac.cs.teambravo.publications.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="NotActive")
public class NotActiveState extends PublicationTypeState {
   
    @Column
    private String deactivationReason;

    public NotActiveState() {
        super();
    }

    public String getDeactivationReason() {
        return deactivationReason;
    }

    public void setDeactivationReason(String deactivationReason) {
        this.deactivationReason = deactivationReason;
    }
    
}
