package bravo.notifications.ejb;

import java.sql.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.*;

public class Reminder extends TimerTask
{
    public void remind() throws SQLException
    {
      //connection to db
      Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/mockDB [Jakes on JAKES]");     //"jdbc:postgresql://localhost:5432/mockDB","postgres", "postgres");
      Statement stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM Reminders;");
      String[] emails = null;

      while (rs.next())
      {
        String reminderDate = rs.getString("DateOfReminder");
        String dueDate = rs.getString("ResearchDue");

        //days left until paper due < 2?
        if ((Integer.parseInt(dueDate) - Integer.parseInt(reminderDate)) <= 86400000) //2 days in milliseconds
        {
          //get emails
          String reminderFID = rs.getString("ReminderFID");
          ResultSet rs2 = stmt.executeQuery("SELECT Email FROM Users WHERE UserID == " + reminderFID + ";");
          emails[0] = rs2.getString("Email");

          new NotificationsBean().sendReminder(emails);
        }
      }
    }

    @Override
    public void run() {
        Runnable r = new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    remind();
                }
                catch (SQLException ex)
                {
                    Logger.getLogger(Reminder.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };

        new Thread(r).start();
    }
    
    public static void main(String[] args)
    {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        Calendar calendar = Calendar.getInstance();

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int delay = hour < 6 ? 6 - hour : 24 - (hour - 6);

        //System.out.println("Current Hour: " + hour);
        //System.out.println("Comuted Delay for next 5 AM: " + delay);

        scheduler.scheduleAtFixedRate(new Reminder(), delay, 24, TimeUnit.HOURS);
    }
}
