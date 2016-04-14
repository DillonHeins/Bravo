package Main;




//package za.ac.cs.teambravo.publications.publications_exceptions;

/**
 *
 * @author Hlengekile
 */
public class EffectiveDateNotAfterEffectiveDateOfLastStateEntry extends PublicationException 
{

    public EffectiveDateNotAfterEffectiveDateOfLastStateEntry()
    {
    }

    public EffectiveDateNotAfterEffectiveDateOfLastStateEntry(String message) 
    {
        super(message);
    }

    public EffectiveDateNotAfterEffectiveDateOfLastStateEntry(String message, Throwable cause) 
    {
        super(message, cause);
    }

    public EffectiveDateNotAfterEffectiveDateOfLastStateEntry(Throwable cause) 
    {
        super(cause);
    }
    
}
