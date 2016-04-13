package za.ac.cs.teambravo.publications.requestandresponses;

import za.ac.cs.teambravo.Publication;

/**
 *
 * @author Jedd
 */
public class ChangePublicationStateResponse implements PublicationResponse{
    private Publication publication;
    public ChangePublicationStateResponse(Publication publication) {
        this.publication=publication;
       
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }
    
}
