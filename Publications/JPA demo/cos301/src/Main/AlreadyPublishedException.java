package Main;




//package za.ac.cs.teambravo.publications.publications_exceptions;

/**
 *
 * @author Hlengekile
 */
public class AlreadyPublishedException extends PublicationException
{

    public AlreadyPublishedException() 
    {
    }

    public AlreadyPublishedException(String message) 
    {
        super(message);
    }

    public AlreadyPublishedException(String message, Throwable cause) 
    {
        super(message, cause);
    }

    public AlreadyPublishedException(Throwable cause)
    {
        super(cause);
    }
    
}
