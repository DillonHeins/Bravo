/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bravo.notifications.ejb;

/**
 * for Mocking reasons
 * 
 * @author Fred
 */
class JSONObject {
    private String mail;
    private String passw;
    
    JSONObject(){
        mail = "u11061112@tuks.co.za";
        passw = "notmypassword";
    }
    
    public String getString(String param){
        if(param.equals("email"))
            return mail;
        else
            return passw;
    }
}
