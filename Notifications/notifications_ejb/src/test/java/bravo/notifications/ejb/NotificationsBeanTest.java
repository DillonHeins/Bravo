package bravo.notifications.ejb;

//import junit.framework.Test;
//import junit.framework.TestCase;
//import junit.framework.TestSuite;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import org.mockito.Spy;
import static org.mockito.Matchers.*;

@RunWith(MockitoJUnitRunner.class)
public class NotificationsBeanTest {

    @Spy
    private NotificationsBean notificationsBean = new NotificationsBean();

    @Test
    public void testSendReminderBase() throws Exception // start of SendReminderTest
    {
        // Setup
        doReturn("Test email message").when(notificationsBean).buildMessage(anyString(), anyString());
        doReturn(true).when(notificationsBean).submitTextMail(anyString(), anyString(), anyString());

        String[] emailList = new String[1];
        emailList[0] = "u10297902@tuks.co.za";

        // Run Test
        boolean result = notificationsBean.sendReminder(emailList);

        // Verify Test
        assertTrue(result);
        verify(notificationsBean).buildMessage("u10297902@tuks.co.za", "Reminder");
        verify(notificationsBean).submitTextMail("u10297902@tuks.co.za", "2 Day Reminder", "Test email message");
    }

    @Test
    public void testSendReminderOneEmailFail() throws Exception {
        // Setup
        doReturn("Test email message").when(notificationsBean).buildMessage(anyString(), anyString());
        doReturn(false).when(notificationsBean).submitTextMail(anyString(), anyString(), anyString());  //comment to send email

        String[] emailList = new String[2];
        emailList[0] = "u10297902@tuks.co.za";

        // Run Test
        boolean result = notificationsBean.sendReminder(emailList);

        // Verify Test
        assertFalse(result);
        verify(notificationsBean).buildMessage("u10297902@tuks.co.za", "Reminder");
        verify(notificationsBean).submitTextMail("u10297902@tuks.co.za", "2 Day Reminder", "Test email message");
    }

    @Test
    public void testSendReminderEmptyArray() throws Exception {
        // Setup
        String[] emailList = new String[0];

        // Run Test
        boolean result = notificationsBean.sendReminder(emailList);

        // Verify Test
        assertFalse(result);
        verify(notificationsBean, never()).buildMessage(anyString(), anyString());
        verify(notificationsBean, never()).submitTextMail(anyString(), anyString(), anyString());
    }

    @Test
    public void testSendReminderNullArray() throws Exception {
        // Setup
        String[] emailList = null;

        // Run Test
        boolean result = notificationsBean.sendReminder(emailList);

        // Verify Test
        assertFalse(result);
        verify(notificationsBean, never()).buildMessage(anyString(), anyString());
        verify(notificationsBean, never()).submitTextMail(anyString(), anyString(), anyString());
    }

    @Test(expected = Exception.class)
    public void testSendReminderExceptionOnBuildMessage() throws Exception {
        // Setup
        when(notificationsBean.buildMessage(anyString(), anyString())).thenThrow(new Exception());
        doReturn(true).when(notificationsBean).submitTextMail(anyString(), anyString(), anyString());

        String[] emailList = new String[1];
        emailList[0] = "u10297902@tuks.co.za";

        // Run Test
        boolean result = notificationsBean.sendReminder(emailList);

        // Verify Test
        assertTrue(result);
        verify(notificationsBean).buildMessage("u10297902@tuks.co.za", "Reminder");
        verify(notificationsBean).submitTextMail("u10297902@tuks.co.za", "2 Day Reminder", "Test email message");
    }

    @Test(expected = Exception.class)
    public void testSendReminderExceptionOnSubmitTextMail() throws Exception {
        // Setup
        doReturn("Test email message").when(notificationsBean).buildMessage(anyString(), anyString());
        when(notificationsBean.submitTextMail(anyString(), anyString(), anyString())).thenThrow(new Exception());

        String[] emailList = new String[1];
        emailList[0] = "u10297902@tuks.co.za";

        // Run Test
        boolean result = notificationsBean.sendReminder(emailList);

        // Verify Test
        assertFalse(result);
        verify(notificationsBean).buildMessage("u10297902@tuks.co.za", "Reminder");
        verify(notificationsBean).submitTextMail("u10297902@tuks.co.za", "2 Day Reminder", "Test email message");
    }                                                                                                                                                                       // end of SendReminderTest

    @Test
    public void testSendNotificationBase() throws Exception                                                                                     // start of SendNotificationTest
    {
        // Setup
        doReturn("Test email message").when(notificationsBean).buildMessage(anyString(), anyString());
        doReturn(true).when(notificationsBean).submitTextMail(anyString(), anyString(), anyString());

        String[] emailList = new String[1];
        emailList[0] = "u10297902@tuks.co.za";

        // Run Test
        boolean result = notificationsBean.sendNotification(emailList);

        // Verify Test
        assertTrue(result);
        verify(notificationsBean).buildMessage("u10297902@tuks.co.za", "Notification");
        verify(notificationsBean).submitTextMail("u10297902@tuks.co.za", "Automatic Notification", "Test email message");
    }

//    @Test
//    public void testSendNotificationOneEmailFail() throws Exception {
//        // Setup
//        doReturn("Test email message").when(notificationsBean).buildMessage(anyString(), anyString());
//        doReturn(false).when(notificationsBean).submitTextMail(anyString(), anyString(), anyString());
//
//        String[] emailList = new String[2];
//        emailList[0] = "u10297902@tuks.co.za";
//
//        // Run Test
//        boolean result = notificationsBean.sendNotification(emailList);
//
//        // Verify Test
//        assertFalse(result);
//        verify(notificationsBean).buildMessage("u10297902@tuks.co.za", "Notification");
//        verify(notificationsBean).submitTextMail("u10297902@tuks.co.za", "Automatic Notification", "Test email message");
//    }

    @Test
    public void testSendNotificationEmptyArray() throws Exception {
        // Setup
        String[] emailList = new String[0];

        // Run Test
        boolean result = notificationsBean.sendNotification(emailList);

        // Verify Test
        assertFalse(result);
        verify(notificationsBean, never()).buildMessage(anyString(), anyString());
        verify(notificationsBean, never()).submitTextMail(anyString(), anyString(), anyString());
    }

    @Test
    public void testSendNotificationNullArray() throws Exception {
        // Setup
        String[] emailList = null;

        // Run Test
        boolean result = notificationsBean.sendNotification(emailList);

        // Verify Test
        assertFalse(result);
        verify(notificationsBean, never()).buildMessage(anyString(), anyString());
        verify(notificationsBean, never()).submitTextMail(anyString(), anyString(), anyString());
    }

    @Test(expected = Exception.class)
    public void testSendNotificationExceptionOnBuildMessage() throws Exception {
        // Setup
        when(notificationsBean.buildMessage(anyString(), anyString())).thenThrow(new Exception());
        doReturn(true).when(notificationsBean).submitTextMail(anyString(), anyString(), anyString());

        String[] emailList = new String[1];
        emailList[0] = "u10297902@tuks.co.za";

        // Run Test
        boolean result = notificationsBean.sendNotification(emailList);

        // Verify Test
        assertTrue(result);
        verify(notificationsBean).buildMessage("u10297902@tuks.co.za", "Reminder");
        verify(notificationsBean).submitTextMail("u10297902@tuks.co.za", "Automatic Notification", "Test email message");
    }

    @Test(expected = Exception.class)
    public void testSendNotificationExceptionOnSubmitTextMail() throws Exception {
        // Setup
        doReturn("Test email message").when(notificationsBean).buildMessage(anyString(), anyString());
        when(notificationsBean.submitTextMail(anyString(), anyString(), anyString())).thenThrow(new Exception());

        String[] emailList = new String[1];
        emailList[0] = "u10297902@tuks.co.za";

        // Run Test
        boolean result = notificationsBean.sendNotification(emailList);

        // Verify Test
        assertFalse(result);
        verify(notificationsBean).buildMessage("u10297902@tuks.co.za", "Reminder");
        verify(notificationsBean).submitTextMail("u10297902@tuks.co.za", "Automatic Notification", "Test email message");
    }                                                                                                                                                                       // end of SendNotificationTest
}
///**
// * Unit test for simple NotificationsBean.
// */
//public class NotificationsBeanTest 
//    extends TestCase
//{
//    /**
//     * Create the test case
//     *
//     * @param testName name of the test case
//     */
//    public NotificationsBeanTest( String testName )
//    {
//        super( testName );
//    }
//
//    /**
//     * @return the suite of tests being tested
//     */
//    public static Test suite()
//    {
//        return new TestSuite( NotificationsBeanTest.class );
//    }
//
//    /**
//     * Rigourous Test :-)
//     */
//    public void testNotificationsBean()
//    {
//        assertTrue( true );
//    }
//}
