
package za.ac.cs.teambravo.publications.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="InRevision")
public class InRevision extends LifeCycleState {

    public InRevision() {
        super();
    }
    
}

