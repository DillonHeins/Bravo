package com.bravonotifications.notifications;
public class AzharEmailTest 
{
    public static void submitTextMail(String recipient, String subject, String body)
    {
       new Client(recipient, subject, body);
    }
    
    public static void main(String[] args)
    {
        submitTextMail("azhar.m.ish@gmail.com", "Testing" , "Test Successful");
    }
}
