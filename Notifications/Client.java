public class Client
{
    public static void main(String[] args)
    {
        Session smtp = new Session
        (
            //"smtp.afrihost.co.za",    //afrihost mail server: 169.1.1.72
            "kendy.up.ac.za",           //cs mail server
            "azhar.m.ish@gmail.com",    //Recipient - To
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
}
