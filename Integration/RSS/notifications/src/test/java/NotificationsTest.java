/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dirk
 */
package bravo.notifications.test;

import bravo.people.entity.PersonEntity;
import bravo.notifications.ejb.NotificationsBean;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class NotificationsTest {
    private static NotificationsBean mockedNotification;
    private static PersonEntity mockPerson;
    
    @BeforeClass
    public static void setUp(){
        mockedNotification = Mockito.mock(NotificationsBean.class);
        
        when(mockedNotification.getNotifications()).thenReturn("This is a notification being sent out to John Doe (11215982) at email adress: john.doe@gmail.com");
    }
    
    @Test
    public void getNotificationTest() throws Exception {
        assertEquals("This is a "
                + "notification being sent out to John Doe "
                + "(11215982) at email adress: john.doe@gmail.com", 
                mockedNotification.getNotifications());
    }
}
