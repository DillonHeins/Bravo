package za.ac.cs.teambravo.publications.publications;

public class AddPublicationMock extends BaseMock implements AddPublication
{
        @Override
	public AddPublicationResponse addPublication(AddPublicatonRequest  request) throws NotAuthorized, InvalidRequest,
		PublicationWithTitleExistsForAuthors
	{
            
            if(request.getStateName().equals("InProgress") || (request.getStateName().equals("Submitted")) || (request.getStateName().equals("InRevision") 
                    && (request.getStateName().equals("Published")) || (request.getStateName().equals("Abandoned")) || (request.getStateName().equals("Rejected")))) 
            {
                throw new PublicationWithTitleExistsForAuthors();
            }
            
            if(request.getStateName().equals("InProgress") && (request.getStateName().equals("Submitted")) && (request.getStateName().equals("InRevision") 
                    && (request.getStateName().equals("Published")) && (request.getStateName().equals("Abandoned")) && (request.getStateName().equals("Rejected"))))
            {
                throw new InvalidRequest();
            }
            
            if (!request.getRequester().getType().equals("Author") || !request.getRequester().getType().equals("ResearchGroupLeader") || !request.getRequester().getType().equals("ResearchManager") )
		{
			throw new NotAuthorized();
		}

		return new AddPublicationResponse();
            	
	}

}