package bravo.notifications.ejb;
public class Client
{
    private String mailServer;
    private String recipient;
    private String sender;
    private String subject;
    private String body;
    
    private static final String clearScreen = "\033[H\033[2J";
    private static final String green = "\u001B[32m";
    private static final String reset = "\u001B[0m";
    private static final String red = "\u001B[31m";

    public Client(String recipient, String subject, String body)
    {
        this.mailServer = "kendy.up.ac.za";
        this.recipient = recipient;
        this.sender = "donotreply@cs.up.ac.za";
        this.subject = subject;
        this.body = body;
        
        sendEmail();
    }
    
    public void sendEmail()
    {        
        Session smtp = new Session
        (
            mailServer,
            recipient, //to
            sender, //from
            subject,
            body
        );

        try
        {
            System.out.println("Sending e-mail...");
            smtp.sendMessage();
            System.out.println(clearScreen + green + "E-mail sent..." + reset);
        }
        catch (Exception e)
        {
            smtp.close();
            System.out.println(clearScreen + red + "Error sending e-mail!" + reset);
            e.printStackTrace();
        }
    }
}