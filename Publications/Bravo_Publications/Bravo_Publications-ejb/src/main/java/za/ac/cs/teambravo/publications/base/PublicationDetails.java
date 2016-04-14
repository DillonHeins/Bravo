package za.ac.cs.teambravo.publications.base;


//package za.ac.cs.teambravo.publications.publication_details;


import java.util.Date;

/**
 *
 * @author Hlengekile
 */
public class PublicationDetails
{
    private String pubTitle;
    private Date envisagedPublicationDate;
    private Person person;

    public PublicationDetails(String pubTitle, Date envisagedPublicationDate, Person person) {
        this.pubTitle = pubTitle;
        this.envisagedPublicationDate = envisagedPublicationDate;
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
    public void setTitle(String inTitle)
    {
        pubTitle = inTitle;
    }
    
    public void setEnvisagedPublicationDate(Date inDate)
    {
        envisagedPublicationDate = inDate;
    }
    
    public String getTitle()
    {
        return pubTitle;
    }
    
    public Date getEnvisagedPublicationDate()
    {
        return envisagedPublicationDate;
    }
    
}
