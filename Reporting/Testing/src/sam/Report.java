package sam;

import java.util.Date;

public class Report
{

/*
* Usage: View report of a certain users publications within specified time period
* Input: name and surname of user as well as date
* Output: svg showing report of the user
*/
public void viewPersonReport(String name, String Surname, Date date)
{
	 System.out.println("Name:" + name +"Surname:"+Surname +"Date:"+ date ); 
}

/*
* Usage: View report of  a certain groups  publications within specified time period
* Input: name of group,  either research group name or department/organisation name
* Output: svg showing report of group specified
*/
public void viewGroupReport(String groupName, Date date)
{
	 System.out.println("Group Name:" + groupName  +"Date:"+ date );  
}

/*
* usage: View report of publications in specified state
* Input: The state required
* Output: svg showing report of publications in specified state
*/
public void viewReportByLifecycleState(String state, Date date)
{
	 System.out.println("State:" + state +"Date:"+ date ); 
}

/*
* usage: View report of certain users publications in specified state
* Input:  Name and surname of user as well as state required
* Output: svg showing report of certain users publications in specified state
*/
public void viewByFilterPub(String name, String surname, String state)
{
	 System.out.println("Name:" + name +"Surname:"+surname +"State:"+ state ); 
}

/*
* usage: View report of  a certain groups publications in specified state
* Input: Name of group as well as state required
* Output: svg showing report of  a certain group's publications in specified state
*/
public void viewByFilter(String groupName, String state)
{
	 System.out.println("Group name:" + groupName +"State:"+state ); 
}

/*
* usage: View report of  a certain user in a certain group
* Input: Name  and surname of user as well as name of group 
* Output: svg showing report of  publication of a certain user in a certain group
*/
public  void viewByFilter(String name, String surname, String groupName)
{
	 System.out.println("Name:" + name +"Surname:"+surname +"Group name:"+ groupName ); 
}
/*
* usage: View report of publications in specified state of a certain  user in a certain group
* Input: Name and surname of user, name of group, state required
* Output: svg showing report of publications in specified state of a certain user in a certain group
*/
public void viewByFilter(String name, String surname, String groupName, String state)
{
	 System.out.println("Name:" + name +"Surname:"+surname +"Group Name:"+ groupName  +"State"+ state); 
}



}