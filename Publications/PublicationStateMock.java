import java.util.Date;

/**
 * Created by User on 2016/03/18.
 */
public class PublicationStateMock implements PublicationState {
    String reason;
    Date date;
    Date envisionedPublicationDate;
    String type;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;

    }

    @Override
    public String getState() {
        return type;
    }

    public PublicationStateMock(String reason, Date date, Date envisionedPublicationDate,String type) {
        this.reason = reason;
        this.date = date;
        this.envisionedPublicationDate = envisionedPublicationDate;
        this.type=type;

    }
}
