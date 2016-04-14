package bravo.notifications.ejb;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import bravo.notifications.interfaces.NotificationsInterface;
import bravo.people.implementations.Person;

/**
 *
 * @author Dillon
 */
@Stateless
@LocalBean
public class NotificationsBean {
    
    public String getNotifications() {
        return "This is a notification being sent out to John Doe (11215982) at email adress: john.doe@gmail.com";
    }
}
