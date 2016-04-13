
package za.ac.cs.teambravo.publications.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Submitted")
public class Submitted extends LifeCycleState {

    public Submitted() {
        super();
    }

}

