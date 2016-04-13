package za.ac.cs.teambravo.publications.publications;

public class InProgress implements LifeCycleState {

    Integer percentageCompleted; 
    
    @Override
    public LifeCycleState getState() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void setState(LifeCycleState newState) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getStateString() {
        return "InProgress";
    }

    public Integer getPercentageCompleted()
    {
        return percentageCompleted;
    }
    
}
