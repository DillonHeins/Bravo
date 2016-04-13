package za.ac.cs.teambravo.publications.publications;

import java.util.Date;

public class PublicationState 
{
    
    String reason;
    Date changeDate;
    LifeCycleState state; 
    
    PublicationState(String reason, Date changeDate, LifeCycleState newState){}
    public void setDate(Date newDate){}
    public void setReason(String newReason){}
    public Date getDate(){ return changeDate;}
    public String getReason(){return reason;}
    public LifeCycleState getState(){return state;}
    public void setState(LifeCycleState newState){}
    
}
