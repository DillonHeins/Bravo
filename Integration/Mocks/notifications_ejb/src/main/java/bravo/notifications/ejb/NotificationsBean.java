package bravo.notifications.ejb;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Dillon
 */
@Stateless
@LocalBean
public class NotificationsBean {
    public String getNotifications() {
        return "This is the notifications' bean v3";
    }
}
