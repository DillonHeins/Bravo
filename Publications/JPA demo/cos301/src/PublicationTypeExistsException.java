
package za.ac.cs.teambravo.publications.publications_exceptions;

/**
 *
 * @author Hlengekile
 */
public class PublicationTypeExistsException extends PublicationException
{

    public PublicationTypeExistsException()
    {
    }

    public PublicationTypeExistsException(String message) 
    {
        super(message);
    }

    public PublicationTypeExistsException(String message, Throwable cause) 
    {
        super(message, cause);
    }

    public PublicationTypeExistsException(Throwable cause)
    {
        super(cause);
    }
    
}
