package Main;

/**
 *
 * @author Hlengekile
 */
public class AuthorizationException extends PublicationException
{

    public AuthorizationException() 
    {
    }

    public AuthorizationException(String message)
    {
        super(message);
    }

    public AuthorizationException(String message, Throwable cause) 
    {
        super(message, cause);
    }

    public AuthorizationException(Throwable cause)
    {
        super(cause);
    }
             
}
