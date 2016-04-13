package za.ac.cs.teambravo.publications.publications;

public interface AddPublication
{
    AddPublicationResponse addPublication(AddPublicatonRequest  request) throws NotAuthorized, InvalidRequest,
		PublicationWithTitleExistsForAuthors;
    
    public class AddPublicationResponse 
    {
        Publication addedPublication;
    
        public Publication getPublication(){ return addedPublication;} 
    }
        
    public class AddPublicatonRequest 
    {
        PublicationState initialState; 
        Person requester;
    
        public PublicationState getInitialState(){return initialState;}
        public String getStateName()
        {
            LifeCycleState state = initialState.getState();
            
            return state.getStateString();
        }
        public Person getRequester()
        {
            return requester;
        }
    }
}