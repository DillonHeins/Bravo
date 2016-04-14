
package za.ac.cs.teambravo.publications.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="InProgress")
public class InProgress extends LifeCycleState {
    
    private Integer percentageComplete;

    public InProgress() {
        super();
    }

    public Integer getPercentageComplete() {
        return percentageComplete;
    }

    public void setPercentageComplete(Integer percentageComplete) {
        this.percentageComplete = percentageComplete;
    }
   
    
}
