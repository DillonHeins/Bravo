package Main;



//package za.ac.cs.teambravo.publications.publications_exceptions;

public class NotAuthorized extends PublicationException 
{

    public NotAuthorized()
    {
    }

    public NotAuthorized(String message) 
    {
        super(message);
    }

    public NotAuthorized(String message, Throwable cause)
    {
        super(message, cause);
    }

    public NotAuthorized(Throwable cause) 
    {
        super(cause);
    }
    
   
}
