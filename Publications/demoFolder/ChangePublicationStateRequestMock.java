/**
 * Created by User on 2016/03/18.
 */
public class ChangePublicationStateRequestMock implements ChangePublicationStateRequest {

    PersonMock owner = null;

    PublicationMock publication = null;
    Publications caller =null;
    String newName="";
    PublicationStateMock state=null;

    @Override
    public PublicationState getPublicationState() {
        return state;
    }

    @Override
    public String getPerson() {
        return PersonMock.getName();
    }

    @Override
    public String getTitle() {
        return PublicationMock.getTitle();
    }

    @Override
    public String getReason() {
        return state.getReason();
    }

    @Override
    public String getNewTitle() {
        return newName;
    }

    public ChangePublicationStateRequestMock(Publications _caller,PersonMock personMock,PublicationStateMock publicationStateMock,PublicationMock publicationMock,String newName) {
        super();
        caller=_caller;
        owner=personMock;
        state= publicationStateMock;
        publication=publicationMock;
        this.newName=newName;

    }
}
