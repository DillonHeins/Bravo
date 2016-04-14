/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bravo.people.resource;

import javax.ws.rs.Path;
import bravo.people.ejb.*;
import bravo.people.entity.PersonEntity;
import bravo.people.implementations.Email;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import bravo.people.implementations.PersonModel;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.json.JsonObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

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
        peopleBean.addPerson(personModel.getFirstName(), personModel.getSurname(),
                personModel.getStaffNumber(), personModel.getEmail(), personModel.getGroup(),
                personModel.getOrganisation());
        return Response.ok("{}", MediaType.APPLICATION_JSON).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("getPerson")
    public Response getPerson(Email email) {
        PersonEntity personEntity = peopleBean.getPerson(email.getEmail());
        JSONObject person = new JSONObject();
        
        person.put("firstName", personEntity.getPerson().getFirstName());
        person.put("surname", personEntity.getPerson().getSurname());
        person.put("email", personEntity.getPerson().getEmail());
        person.put("group", personEntity.getGroup().getName());
        person.put("organisation", personEntity.getOrganisation().getName());

        return Response.ok(person.toString(), MediaType.APPLICATION_JSON).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getPeople")
    public Response getPeople() throws IOException {
        JSONObject jsonObject = new JSONObject();
        Collection<JSONObject> items = new ArrayList<JSONObject>();
        Map<String, String> temp = peopleBean.getPeopleList();
        
        Iterator it = temp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            JSONObject person = new JSONObject();
            person.put("email", pair.getKey());
            person.put("firstName", pair.getValue());
            
            items.add(person);
            it.remove();
        }
        
//        JSONArray arr = new JSONArray();
//        arr.add(items);
        
        jsonObject.put("people", items);
        
        return Response.ok(jsonObject.toString(), MediaType.APPLICATION_JSON).build();
    }
    
    @EJB
    private PeopleBean peopleBean;
}
