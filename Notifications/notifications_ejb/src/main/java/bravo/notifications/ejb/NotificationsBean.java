package bravo.notifications.ejb;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bravo Notifications Team
 */

public class NotificationsBean {
    
     Logger logger = Logger.getLogger(NotificationsBean.class.getName());
    
    private String reportPathString = "C:/temp/reports/";	//the path where reports are stored

    /*
        @param emailList[] it will be an array containing all the email addresses the report must be sent to
        @param file this will be the generated report file that needs to be sent as an attachment with the email
     */
    public void sendReport(String emailList[], String file) {
        /*
            This function must take the list of emails and add each one to be sent to, ask buildMessage to generate the appropriate message
            and receive the email's body from buildMessage.

            We are in the process of making a telnet server to interface to the up mail server so just code as far as you can then be able to explain
            the work you have done thus far.

            Submitting an email to be sent must be done one email address at a time so all looping must be done here.
         */
        String message = "";
        //submitMultipartMail(emailList[0], message,file);

        File f = new File(reportPathString + file);
        if (f.exists() && !f.isDirectory()) { 	//test if file exists
            for (int i = 0; i < emailList.length; i++) {
                if (emailList[i] != null && !emailList[i].isEmpty()) {
                    message = buildMessage(emailList[i], "Report");
                    submitMultipartMail(emailList[i], "Report ready to download", message, file);
                }
            }
        }
    }

    public boolean[] Login() { //JSONObject removed and becomes mocked instead for now
        //email address & password of JSON object
        JSONObject s = new JSONObject();
        String Jmail = s.getString("email");
        String Jpass = s.getString("password");

        //initializing array of structure [fail,user , group head,admin]
        boolean arr[] = new boolean[4];
        arr[0] = true;
        arr[1] = false;
        arr[2] = false;
        arr[3] = false;

        try {
            //postgreSQL database connection ,assuming that the database name is accounts & there is a table called users
            Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/mockDB [Jakes on JAKES]");     //"jdbc:postgresql://localhost:5432/mockDB","postgres", "postgres");                     // Hint: Cannot mock connection while it is like this, in order to mock a sucessful connection
            Statement stmt = c.createStatement();                                                                                                                                                                                                                                                   // create getConnection function outside of  Login() function
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users;");
            while (rs.next()) {
                //String person=rs.getString("person");
                String email = rs.getString("Email");
                String pass = rs.getString("Password");

                //checking for matching login details
                if (email.compareTo(Jmail) == 0 && pass.compareTo(Jpass) == 0) {
                    arr[0] = false;
                    break;// the commented out code is at the end of the file
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return arr;
    }

    /*
        @param emailList[] it will be an array containing all the email addresses the notification must be sent to
        other parameters still unsure
     */
    public void sendNotification(String emailList[]) {
        /*
            The email list must receive their notifications as per request, 
            Thus each mail must be sent one by one so each user can get his/her personalised notfication.
            This will still buildMessage as that function will get the personalised message from the data base.
         */
        for (int i = 0; i < emailList.length; i++) {
            String message = buildMessage(emailList[i], "Notification");
            submitTextMail(emailList[i], "Automatic Notification", message);
        }
    }

    /*
        @param emailList[] the list of people that need to receive their reminders
     */
    public boolean sendReminder(String emailList[])
    {
        // Need to call this function in the login function after checking if reminder needs to be sent
        boolean failedEmail = false;
                
        if (emailList != null && emailList.length > 0)
        {
            for (String emailList1 : emailList)
            {
                try
                {
                    String message = buildMessage(emailList1, "Reminder");
                    if (!submitTextMail(emailList1, "2 Day Reminder", message)) {
                        failedEmail = true;
                    }
                }
                catch (Exception ex)
                {
                    failedEmail = true;
                }
            }
            
            if (failedEmail)
            {
               logger.log(Level.INFO, "One or more emails failed to send");
               return false;
            }
            else 
            {
                logger.log(Level.INFO, "Success");
                return true;
            }
        }
        
        logger.log(Level.INFO, "No email to send");
        return false;
    }

    /*
        @param emailList[] it will be an array containing all the email addresses the change notice must be sent to
        @param message this will be the generated message from our side to be sent to the user via a simple text only mail
     */
    public boolean submitTextMail(String recipient, String subject, String body) {
        /*
            This will be used to email plain text emails no images/files etc. 
            will use buildMessage to assist the contruction of the message.
         */

        new Client(recipient, subject, body);
        
        return true;
    }

    /*
        @param emailList[] it will be an array containing all the email addresses the change notice must be sent to
        @param message this will be the generated message from our side to be sent to the user via a simple text only mail
        @param file (type still to be discussed) the file that has to be attached to the email.
     */
    public boolean submitMultipartMail(String recipient, String subject, String body, String file) {
        /*This will be used to send emails with files . */
        
        new Client(recipient, subject, body, file);
        
        return true;
    }

    /*
        @param email this variable allows the sql request to the data base to allow us to get teh user's name for the mail;
        @param typeOfRequest specifies the type of request it will be eg a notification or a change notice.
     */
    protected String buildMessage(String email, String typeOfRequest) { // Frederick                                                                                // HINT: Had to change to protected in order to mock for unit test
        /*
                This will take the client's name and add it to the message to give it a personal touch
                The type of request will let the function know which template file to use.
         */
        String username = "";
        String message = "";

        try {
            Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/mockDB [Jakes on JAKES]");     //"jdbc:postgresql://localhost:5432/mockDB","postgres", "postgres");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT FirstName, LastName FROM Users WHERE Email = '" + email + "';");
            username = rs.toString();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());                                                                                              
           // System.exit(0);                                                                                                                                                                                 // HINT: NO! Closes server when error occurs, rather just handle the exception
        }

        if (typeOfRequest.equals("Reminder")) {
            String pm = ""; //sql request to get personal message set by user
            message = reminderMessage(username, pm);
        } else if (typeOfRequest.equals("Notification")) {
            message = notificationMessage(username);
        } else if (typeOfRequest.equals("Report")) {
            message = reportMessage(username);
        }

        return message;
    }

    public boolean failedEmail(String email, String header, String message) {
        /*
        An exponential backoff algorithm called when a sendMessage fails
        will attempt to send the email 10 times waiting longer each time before giving up
         */

        int sleep = 2000;
        int counter = 0;
        while (true) {
            if (submitTextMail(email, header, message)) {
                return true;
            } else {
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException ex) {
                    Logger.getLogger(NotificationsBean.class.getName()).log(Level.SEVERE, null, ex);
                }
                sleep *= 2;
                counter++;

                if (counter == 10) {
                    return false;
                }
            }
        }
    }
    
    public boolean logEntry(String entry)
    {
        File log = new File("log.txt");
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        try {
            if (log.exists() == false) {
                System.out.println("We had to make a new file.");
                log.createNewFile();
            }
            PrintWriter out = new PrintWriter(new FileWriter(log, true));
            out.append(timeStamp + ": " + entry + '\n');
            out.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    /*Functions to help mock build message's functionality */
    private String reminderMessage(String user, String pmessage) {
        String publicationName = "Random Title"; //sql request to database
        String intro = "Good day " + user + "\n";
        String body = "Please note that the following publication has been modified:";
        String salutation = "Regards \n Bravo team";
        String completed = intro + body + publicationName + "\n" + salutation;
        return completed;
    }

    private String notificationMessage(String user) {
        String intro = "Good day " + user + "\n";				// sql request to sql database to get notification message
        String body = "This is the user's personal message";
        String salutation = "Regards \n Bravo team";
        String completed = intro + body + "\n" + salutation;
        return completed;
    }

    private String reportMessage(String user) {
        String intro = "Good day " + user + "\n";				// sql request to sql database to get the report file
        String body = "Plesae find attached the report file for: ";
        String salutation = "Regards \n Bravo team";
        String completed = intro + body + "\n" + salutation;
        return completed;
    }

}

/*
Not needed functions:

public void sendChange(String emailList[], String publicationName){
		/*
			All authors must be notified if someone made changes to their publication of any kind. (Note the publication name must be specified as an author can belong to multiple groups) 
			Still to be figured out if it will tell the authors exactly what was changed. (to be discussed)
                        Submitting an email to be sent must be done one email address at a time so all looping must be done here.
 *//*
		String message = "";
		
		for (int i = 0; i < emailList.length; i ++){
			if (emailList[i] != null && !emailList[i].isEmpty()){
				message = buildMessage(emailList[i], "Change", publicationName);
				submitTextMail(emailList[i], message);
			}
		}
	}
************************************
Banele's commented out code from login
/*  if (person.compareTo("Admin")==0)
                    {
                        arr[1]=true;
                        arr[2]=true;
                        arr[3]=true;
                    }
                else if (person.compareTo("Group Head")==0)
                    {
                        arr[1]=true;
                        arr[2]=true;
                        arr[3]=false;
                    }
                else
                {
                        arr[1]=true;
                        arr[2]=false;
                        arr[3]=false;
                }
     //       System.out.println("User logged in ");
 ***************************************************
 */
