/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bravo.people.interfaces;

/**
 *
 * @author Dillon
 */
public interface PersonModelInterface {
    public String getFirstName();

    public void setFirstName(String firstName);

    public String getSurname();

    public void setSurname(String surname);

    public String getStaffNumber();

    public void setStaffNumber(String staffNumber);
    
    public String getEmail();

    public void setEmail(String email);
    
    public String getGroup();

    public void setGroup(String group);
    
    public String getOrganisation();

    public void setOrganisation(String organisation);
}
