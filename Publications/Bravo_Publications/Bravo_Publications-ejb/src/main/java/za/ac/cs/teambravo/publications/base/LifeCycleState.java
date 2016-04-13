package za.ac.cs.teambravo.publications.base;



//package za.ac.cs.teambravo.publications.publications;

public interface LifeCycleState {
    
    public LifeCycleState getState();
    public void setState(LifeCycleState newState);
    public String getStateString();
    
}
