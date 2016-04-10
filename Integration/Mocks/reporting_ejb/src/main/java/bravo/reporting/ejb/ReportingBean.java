package bravo.reporting.ejb;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Dillon
 */
@Stateless
@LocalBean
public class ReportingBean {
    public ReportingBean() {
        
    }
    
    public String getReport() {
        return "Report info";
    }
}
