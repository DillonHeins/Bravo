package bravo.notifications.ejb;

import javax.persistence.Table;

@Table(name = "Tbl_users")
public class Tbl_users {

    private int pk_tbl_users_id;
    private String tbl_users_first_name;
    private String tbl_users_last_name;
    private String tbl_users_email;
    private String tbl_users_password;
    
    public int getID(){
        return pk_tbl_users_id;
    }
    
    public String getFirstName(){
        return tbl_users_first_name;
    }
    
    public void setFirstName(String tbl_users_first_namee){
        tbl_users_first_name = tbl_users_first_namee;
    }
    
    public String getLastName(){
        return tbl_users_last_name;
    }
    
    public void setLastName(String tbl_users_last_namee){
        tbl_users_last_name = tbl_users_last_namee;
    }
    
    public String getEmail(){
        return tbl_users_email;
    }
    
    public void setEmail(String tbl_users_emaile){
        tbl_users_email = tbl_users_emaile;
    }
    
    public String getPassword(){
        return tbl_users_password;
    }
    
    public void setPassword(String tbl_users_passworde){
        tbl_users_password = tbl_users_passworde;
    }

}