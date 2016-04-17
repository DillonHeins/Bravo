package bravo.notifications.resources;

import bravo.notifications.ejb.NotificationsBean;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Dillon
 */
@Path("notificationsResource")
public class NotificationsResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("getNotifications")
    public String getNotifications() {
        return notificationsBean.getNotifications();
    }
    
    @EJB
    NotificationsBean notificationsBean;
}
