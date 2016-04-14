/**
 * Created by User on 2016/03/18.
 */
public class PublicationsMock implements Publications {
    NotificationsMock notifier = new NotificationsMock();
    PersistanceMock persistanceObject= new PersistanceMock();
    @Override
    public ChangePublicationStateResponse changePublicationState(ChangePublicationStateRequest request) throws NotAuthorizedException, NoSuchPublicationException, AlreadyPublishedException, PublicationWithTitleExistsForAuthorsException {
       PublicationMock currentPublication;

        if (request.getPerson().equals("Tonia"))
            throw new NotAuthorizedException();
        if (getPublication(request.getTitle())==null)
            throw new  NoSuchPublicationException();
        currentPublication= (PublicationMock) getPublication(request.getTitle());
      if( currentPublication.getState().equals("Published"))
        throw new AlreadyPublishedException();
        if (getPublication(request.getNewTitle())!=null)

            throw new PublicationWithTitleExistsForAuthorsException();

        currentPublication.addStateEntry(request.getPublicationState());

        notifier.sendActivityNotification("This is to notify you that publication "+ request.getTitle()+" publication state has been changed to "+request.getPublicationState().getState()+ " with new title "+request.getNewTitle()+ " for the following reason "+ request.getReason());
        persistanceObject.persistObject(currentPublication);
        return new ChangePublicationStateResponseMock("Publication state has been changed");




    }

    @Override
    public Publication getPublication(String title) {

        if(title.equals("Late night coding and its detrimental effects") || title.equals("Wifi in IT building: A cost analysis")|| title.equals("Implentation concerns of leftist D-heaps") )
         return new PublicationMock(title);
        else
            return null;
    }
}
