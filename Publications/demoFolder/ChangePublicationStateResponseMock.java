/**

 * Created by u13133064 Jedd Shneier.
 * Interface for  ChangePublicationStateRequests
 */


public class ChangePublicationStateResponseMock implements ChangePublicationStateResponse {

    String message;
    public ChangePublicationStateResponseMock(String s) {
        message=s;
        System.out.println(" ChangePublicationStateResponse has been sent back to caller");

    }
    public void getMessage()
    {
        System.out.println(message);
    }
}
