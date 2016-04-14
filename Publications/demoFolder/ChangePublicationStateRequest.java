/**
 * Created by User on 2016/03/18.
 */
public interface ChangePublicationStateRequest {
    public String getTitle();
    public String getPerson();
    public PublicationState getPublicationState();

    String getNewTitle();

    String getReason();
}
