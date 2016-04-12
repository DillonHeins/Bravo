/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bravo.reporting.resource;

import bravo.reporting.ejb.*;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Dillon
 */
@Path("reporting")
public class ReportingResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("getReport")
    public String getReport() {
        return reportingBean.getReport();
    }
    
    @EJB
    ReportingBean reportingBean;
}
