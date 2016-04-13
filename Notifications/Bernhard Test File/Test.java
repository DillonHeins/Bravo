import NotificationsBean.java;

public class Test
{
	public static void main(String[] args)
	{
		TestLogin();
		
		TestSendNotification();
		
		TestSendReminder();
	}
	
	public void TestLogin()
	{
		Login();            // Doesn't take parameters, so I don't know how to test it.
		
	}
	
	public void TestSendNotification()
	{
		String emailList[]= new String[];
        
		//Test empty emailList
                    if (sendNotification(emailList) == false)
                    {
                        System.out.println("sendNotification:   Blank EmailList test failed");
                    }
		
                    
		//Test one email
		emailList[0] = "test email one";        // Modify to use actual email
        
                     if (sendNotification(emailList) == false)
                    {
                        System.out.println("sendNotification:   Single email in EmailList test failed");
                    }

		//Test multiple emails
                     emailList[1] = "test email two";         // Modify to use actual email
                     emailList[2] = "test email three";         // Modify to use actual email
                     
                     if (sendNotification(emailList) == false)
                    {
                        System.out.println("sendNotification:   Multiple emails in EmailList test failed");
                    }
            
		
	}
	
	public void TestSendReminder()
	{
		String emailList[]= new String[];
        
		//Test empty emailList
                    if (sendReminder(emailList) == false)
                    {
                        System.out.println("sendReminder:   Blank EmailList test failed");
                    }
		
                    
		//Test one email
		emailList[0] = "test email one";        // Modify to use actual email
        
                     if (sendReminder(emailList) == false)
                    {
                        System.out.println("sendReminder:   Single email in EmailList test failed");
                    }

		//Test multiple emails
                     emailList[1] = "test email two";         // Modify to use actual email
                     emailList[2] = "test email three";         // Modify to use actual email
                     
                     if (sendReminder(emailList) == false)
                    {
                        System.out.println("sendReminder:   Multiple emails in EmailList test failed");
                    }
	}
}