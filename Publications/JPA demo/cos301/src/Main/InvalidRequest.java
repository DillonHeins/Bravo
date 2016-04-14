package Main;



//package za.ac.cs.teambravo.publications.publications_exceptions;

public class InvalidRequest extends PublicationException 
{

    public InvalidRequest() 
    {
    }

    public InvalidRequest(String message) 
    {
        super(message);
    }

    public InvalidRequest(String message, Throwable cause) 
    {
        super(message, cause);
    }

    public InvalidRequest(Throwable cause)
    {
        super(cause);
    }
    
     
    
}
