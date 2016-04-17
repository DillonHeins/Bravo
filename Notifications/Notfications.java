package com.bravonotifications.notifications;

class Notifications{
	/*
		@param emailList[] it will be an array containing all the email addresses the report must be sent to
		@param file this will be the generated report file that needs to be sent as an attachment with the email
	*/
	public void sendReport(String emailList[], String file){
		/*
			This function must take the list of emails and add each one to be sent to, ask buildMessage to generate the appropriate message
			and receive the email's body from buildMessage.

			We are in the process of making a telnet server to interface to the up mail server so just code as far as you can then be able to explain
			the work you have done thus far.
            
                        Submitting an email to be sent must be done one email address at a time so all looping must be done here.
		*/
            String message = "LOL";
            submitMultipartMail(emailList[0], message,file);
	}

	/*
		@param emailList[] it will be an array containing all the email addresses the notification must be sent to
		other parameters still unsure
	*/
	public void sendNotification(String emailList[]){
		/*
			The email list must receive their notifications as per request, 

			Thus each mail must be sent one by one so each user can get his/her personalised notfication.

			This will still buildMessage as that function will get the personalised message from the data base.
		*/
		String message = "Sample message"; //this will be replaced with code to fetch the message stored on the database
		message = message + "Sent via automatic notifications";
		
		submitTextMail(emailList[0], message);
	}
        
        /*
            @param emailList[] the list of people that need to receive their reminders
        */
        public void sendReminder(String emailList[]){
            
        }
        
	/*
		@param emailList[] it will be an array containing all the email addresses the change notice must be sent to
		@param message this will be the generated message from our side to be sent to the user via a simple text only mail
	*/
	public void submitTextMail(String email, String message){
		/*
			This will be used to email plain text emails no images/files etc. 
			will use buildMessage to assist the contruction of the message.
		*/
		String recipientList= email;
		message = "sample message"; //the message to be sent to the recipient
		String subje="subject of message";
		//list of recipients seperated by commas : e.g banele@gmail.com , u12201911@tuks.co.za , mm@webmaster.com
			/*for (int i=1;i<email.length;i++)
			{
				recipientList+=","+emailList[i];
			}*/
			//address,subject,message
			//submitEmail(recipientList,subje,message);
			
	}
        
        /*
		@param emailList[] it will be an array containing all the email addresses the change notice must be sent to
		@param message this will be the generated message from our side to be sent to the user via a simple text only mail
                @param file (type still to be discussed) the file that has to be attached to the email.
	*/
        public void submitMultipartMail(String email, String message, String file){
		/*
			This will be used to email plain text emails no images/files etc. 
			will use buildMessage to assist the contruction of the message.
		*/
		String recipientList = email;
		message= "sample message"; //the message to be sent to the recipient
		String subje= "subject of message";
		//list of recipients seperated by commas : e.g banele@gmail.com , u12201911@tuks.co.za , mm@webmaster.com
			/*for (int i=1;i<emailList.length;i++)
			{
				recipientList+=","+emailList[i];
			}*/
			//address,subject,message
			//submitEmail(recipientList,subje,message);
			
	}

	/*
		@param typeOfRequest specifies the type of request it will be eg a notification or a change notice.
	*/

	/*
		@param email this variable allows the sql request to the data base to allow us to get teh user's name for the mail;
		@param typeOfRequest specifies the type of request it will be eg a notification or a change notice.
	*/
	private String buildMessage(String email, String typeOfRequest){ // Frederick
		/*
			This will take the client's name and add it to the message to give it a personal touch
			The type of request will let the function know which template file to use.
		*/
                String username = "";// sql request using email to identify the user 
		String message  = ""; 
		if(typeOfRequest.equals("Reminder")){
                        String pm = ""; //sql request to get personal message set by user
			message = reminderMessage(username,pm);                        
		}
		else if(typeOfRequest.equals("Notification")){
			message = notificationMessage(username);
		}
		else if(typeOfRequest.equals("Report")){
			message = reportMessage(username);
		}

		return message;
	}
	
	/*Functions to help mock build message's functionality */

	private String reminderMessage(String user, String pmessage){
                String publicationName = "Random Title"; //sql request to database
		String intro = "Good day " + user + "\n";
		String body = "Please note that the following publication has been modified:";
		String salutation = "Regards \n Bravo team";
		String completed = intro + body + publicationName + "\n" + salutation;
		return completed;
	}

	private String notificationMessage(String user){
		String intro = "Good day " + user + "\n";				// sql request to sql database to get notification message
		String body = "This is the user's personal message";
		String salutation = "Regards \n Bravo team";
		String completed = intro + body + "\n" + salutation;
		return completed;
	}

	private String reportMessage(String user){
		String intro = "Good day " + user + "\n";				// sql request to sql database to get the report file
		String body = "Plesae find attached the report file for: ";
		String salutation = "Regards \n Bravo team";
		String completed = intro + body + "\n" + salutation;
		return completed;

		//message = clientName + ", \n" + typeOfRequest;
		
		//return message;
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
*/
