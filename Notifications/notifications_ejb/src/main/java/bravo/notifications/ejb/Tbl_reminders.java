package bravo.notifications.ejb;

import javax.persistence.Table;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name = "Tbl_reminders")
public class Tbl_reminders {

    private int pk_tbl_reminders_id;
    private int fk_tbl_reminders_user_id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tbl_reminders_reminderdatetime")
    private java.sql.Timestamp tbl_reminders_reminderdatetime;
    private String tbl_reminders_message;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tbl_reminders_duedate")
    private java.sql.Timestamp tbl_reminders_duedate;
    
    public int getID(){
        return pk_tbl_reminders_id;
    }
    
    public int getFKUserID(){
        return fk_tbl_reminders_user_id;
    }
    
    public void setFKUserID(int fk){
        fk_tbl_reminders_user_id = fk;
    }
    
    @Column(name="tbl_reminders_reminderdatetime", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    public java.sql.Timestamp getReminderDateTime(){
        return tbl_reminders_reminderdatetime;
    }
    
    public void setReminderDateTime(java.sql.Timestamp reminderdate){
        tbl_reminders_reminderdatetime = reminderdate;
    }

    public String getMessage(){
        return tbl_reminders_message;
    }
    
    public void setMessage(String mesg){
        tbl_reminders_message = mesg;
    }
    
    public java.sql.Timestamp getDueDate(){
        return tbl_reminders_duedate;
    }
    
    public void setDueDate(java.sql.Timestamp duedate){
        tbl_reminders_duedate = duedate;
    }
}