/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bravo.reporting.ejb;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import junit.framework.TestCase;

/**
 *
 * @author Warmaster
 */
public class ReportingBeanTest extends TestCase{

    @org.junit.Test
    /**
     * This is a test for the bar graph report type
     */
    public void testBar() {
        // TODO review the generated test code and remove the default call to fail.
      
        Report test=new Report("bar");
        assertEquals("This is a bar graph report.", test.generateReport());
        
    }
    /**
     * This is a test for the line graph report type
     */
    @org.junit.Test
    public void testLine() {
        // TODO review the generated test code and remove the default call to fail.
      
        Report test=new Report("line");
        assertEquals("This is a line graph report.", test.generateReport());
        
    }
    /**
     * This is a test for the  pie chart report type
     */
    @org.junit.Test
    public void testPie() {
        // TODO review the generated test code and remove the default call to fail.
      
        Report test=new Report("pie");
        assertEquals("This is a pie chart report.", test.generateReport());
        
    }
    /**
     * This is a test for the summary report type
     */
    @org.junit.Test
    public void testSum() {
        
        Report test=new Report("sum");
        assertEquals("This is a summary report of the database.", test.generateReport());
    }
}
