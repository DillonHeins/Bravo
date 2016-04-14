package Main;

public class InRevision implements LifeCycleState{

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
        return "InRevision";
    }
    
}
