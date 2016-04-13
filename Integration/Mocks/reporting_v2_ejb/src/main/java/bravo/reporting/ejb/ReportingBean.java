/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bravo.reporting.ejb;

import javax.ejb.Stateless;

/**
 *
 * @author Warmaster
 */
@Stateless
public class ReportingBean {
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public String generateReport(String ReportType) {
        Report rep=new Report(ReportType);
        
        return rep.generateReport();
    }
}
