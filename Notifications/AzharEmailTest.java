public class AzharEmailTest 
{
    public static void submitTextMail(){
        /*
            This will be used to email plain text emails no images/files etc. 
            will use buildMessage to assist the contruction of the message.
        */
        
        new Client("azhar.m.ish@gmail.com");
    }
    
    public static void main(String[] args)
    {
        submitTextMail();
    }
}
