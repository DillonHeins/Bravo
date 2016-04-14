package bravo.notifications.ejb;
public class AzharEmailTest 
{
    public static void submitTextMail(String recipient, String subject, String body)
    {
       new Client(recipient, subject, body);
    }
    
    public static void submitMultipartMail(String recipient, String subject, String body, String file)
    {
       new Client(recipient, subject, body, file);
    }
    
    public static void main(String[] args)
    {
        //submitTextMail("azhar.m.ish@gmail.com", "Testing" , "Test Successful");
        
        //submitMultipartMail("azhar.m.ish@gmail.com", "Testing" , "Test Successful, with link to report below:", "www.bravonotifications.com/report.pdf");
        
        DB db = new DB();
        
        System.out.println(db.getUserID("u12207871@tuks.co.za"));
        
        System.out.println(db.getFullName("u12207871@tuks.co.za"));
        
        System.out.println(db.logIn("awebrehh@gmail.com", "brooo"));
    }
}
