/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bravo.people.implementations;

import bravo.people.interfaces.PersonModelInterface;

/**
 *
 * @author Dillon
 */
public class PersonModel implements PersonModelInterface {
    private String firstName;
    private String surname;
    private String staffNumber;
    private String email;
    private String group;
    private String organisation;

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String getStaffNumber() {
        return staffNumber;
    }

    @Override
    public void setStaffNumber(String staffNumber) {
        this.staffNumber = staffNumber;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getGroup() {
        return this.group;
    }

    @Override
    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String getOrganisation() {
        return this.organisation;
    }

    @Override
    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }
}
