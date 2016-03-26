import java.util.LinkedList;

/**
 * Created by User on 2016/03/18.
 */
public class PublicationMock implements Publication{
    static String title="";
    LinkedList<PublicationStateMock> lifeCycle = new LinkedList<PublicationStateMock>();

    public PublicationMock(String title) {
        this.title = title;
    }

    public void addStateEntry(PublicationState state)
    {
        lifeCycle.add((PublicationStateMock) state);

    }
    public String getState()
    {
        if (title.equals("Late night coding and its detrimental effects"))
            return "Published";
        return "Pending";
    }

    public static String getTitle() {
        return title;
    }
}
