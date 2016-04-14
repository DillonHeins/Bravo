package za.ac.cs.teambravo.publications.publications;


import java.util.Date;

public class Published implements LifeCycleState{

    Date publicationDate;
    
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
        return "Published";
    }
    
}
