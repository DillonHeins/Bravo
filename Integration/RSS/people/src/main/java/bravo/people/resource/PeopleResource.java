/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bravo.people.resource;

import javax.ws.rs.Path;
import bravo.people.ejb.*;
import bravo.people.model.*;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dillon
 */
@Path("peopleResource")
public class PeopleResource {
    /*@POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("addPerson")
    public void addPerson(@FormParam("firstName") String firstName, @FormParam("surname") String surname, @FormParam("staffNumber") String staffNumber) {
        peopleBean.addPerson(firstName, surname, staffNumber);
    }*/
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("addPerson")
    public Response addPerson(PersonModel personModel) {
        peopleBean.addPerson(personModel.getFirstName(), personModel.getSurname(), personModel.getStaffNumber());
        return Response.ok("{}", MediaType.APPLICATION_JSON).build();
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("getPerson")
    public String getPerson() {
        String persons = "";
        
        for (int i = 0; i < peopleBean.getPerson().size(); ++i) {
            persons += peopleBean.getPerson().get(i) + "\n";
        }
        
        return persons;
    }
    
    @EJB
    private PeopleBean peopleBean;
}
