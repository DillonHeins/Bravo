package com.bravonotifications.notifications;

public class Client
{
    private String[] recipient;

    public Client(String[] recipient)
    {        
        this.recipient = new String[recipient.length];
        
        for (int k = 0; k < recipient.length; k++)
        {
            this.recipient[k] = recipient[k];
        }
        
        sendEmail(this.recipient);
    }
    
    private void sendEmail(String[] recipient)
    {
        Session smtp = new Session
        (
            //"smtp.afrihost.co.za",    //afrihost mail server: 169.1.1.72
            "kendy.up.ac.za",           //cs mail server
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
}
