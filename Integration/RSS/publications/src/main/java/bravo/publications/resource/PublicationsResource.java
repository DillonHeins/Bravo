/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bravo.publications.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import bravo.publications.ejb.*;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Dillon
 */
@Path("publicationsResource")
public class PublicationsResource {
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("addPublication")
    public void addPublication(@FormParam("title") String title, @FormParam("staffNumber") String staffNumber) {
        publicationsBean.addPublication(title, staffNumber);
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("getPublications")
    public String getPublications() {
        String titles = "";
        
        for (int i = 0; i < publicationsBean.getTitle("14035538").size(); ++i) {
            titles += publicationsBean.getTitle("14035538").get(i) + "\n";
        }
        
        return titles;
    }
    
    @EJB
    PublicationsBean publicationsBean;
}
