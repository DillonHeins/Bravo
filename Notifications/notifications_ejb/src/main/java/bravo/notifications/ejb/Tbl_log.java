package bravo.notifications.ejb;

import javax.persistence.Table;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name = "Tbl_log")
public class Tbl_log {

    private int pk_tbl_log_id;
    private int fk_tbl_log_user_id;
    private String tbl_log_error_location;
    private String tbl_log_description;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tbl_log_errordatetime")
    private java.sql.Timestamp tbl_log_errordatetime;
    
    public int getID(){
        return pk_tbl_log_id;
    }
    
    public int getFKUserID(){
        return fk_tbl_log_user_id;
    }
    
    public void setFKUserID(int fk){
        fk_tbl_log_user_id = fk;
    }
    
    public String getErrorLocation(){
        return tbl_log_error_location;
    }
    
    public void setErrorLocation(String errloc){
        tbl_log_error_location = errloc;
    }

    public String getDescription(){
        return tbl_log_description;
    }
    
    public void setDescription(String desc){
        tbl_log_description = desc;
    }
    
    public java.sql.Timestamp getErrorDateTime(){
        return tbl_log_errordatetime;
    }
    
    public void setErrorDateTime(java.sql.Timestamp errdate){
        tbl_log_errordatetime = errdate;
    }
}