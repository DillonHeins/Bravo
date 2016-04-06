public class Client
{
    private String recipient;

    public Client(String recipient)
    {
        this.recipient = "azhar.m.ish@gmail.com";
        sendEmail(this.recipient);
    }
    
    public void sendEmail(String recipient)
    {        
        Session smtp = new Session
        (
            "smtp.afrihost.co.za",      //afrihost mail server: 169.1.1.72
            //"kendy.up.ac.za",         //cs mail server
            recipient,                  //Recipient - To
            "u12239799@tuks.co.za",     //Sender - From
            "Testing",                  //Subject
            "Test Successful"           //Body
        );

        try
        {
            System.out.println("Sending e-mail...");
            smtp.sendMessage();
            System.out.println("E-mail sent...");
        }
        catch (Exception e)
        {
            smtp.close();
            System.out.println("Error sending e-mail!");
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args)
    {
        new Client(null);
    }
}