package za.ac.cs.teambravo.publications.publications_exceptions;

public class PublicationWithTitleExistsForAuthors extends PublicationException
{

    public PublicationWithTitleExistsForAuthors()
    {
    }

    public PublicationWithTitleExistsForAuthors(String message) 
    {
        super(message);
    }

    public PublicationWithTitleExistsForAuthors(String message, Throwable cause) 
    {
        super(message, cause);
    }

    public PublicationWithTitleExistsForAuthors(Throwable cause) 
    {
        super(cause);
    }
  
}
