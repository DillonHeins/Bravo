/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bravo.reporting.ejb;

import bravo.reporting.ejb.Report;
import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import junit.framework.TestCase;
import org.junit.Assert;

/**
 *
 * @author Warmaster
 */
public class ReportingBeanTest extends TestCase {

    public ReportingBeanTest() {
    }

    @Test
    public void testGenerateReport() {
        
        Report report = new Report("bar");
        assertEquals("This is a bar graph report", report.returnReport());
        report.setType("line");
        assertEquals("This is a line graph report", report.returnReport());
        report.setType("pie");
        assertEquals("This is a pie chart report", report.returnReport());
        report.setType("sum");
        assertEquals("This is a summary report", report.returnReport());

    }

    /**
     * Test of getBar of ReportingBean module
     */
    @Test
    public void testGetBar() throws Exception {
        System.out.println("====================");
        System.out.println("GetBar");
        try
        {
        Report report = new Report("bar");
        assertEquals("This is a bar graph report", report.returnReport());
        System.out.println("====================");
        }
        catch(UnknownError e)
        {
        fail("No bar graph report was generated");
        }
    }

    /**
     * Test of getLine of ReportingBean module
     */
    @Test
    public void testGetLine() throws Exception {
        System.out.println("====================");
        System.out.println("GetLine");
        try
        {
        Report report = new Report("line");
        assertEquals("This is a line graph report", report.returnReport());
        System.out.println("====================");
        }
        catch(UnknownError e)
        {
        fail("No line graph report was generated");
        }
    }

    /**
     * Test of getPie of ReportingBean module
     */
    @Test
    public void testGetPie() throws Exception {
        System.out.println("====================");
        System.out.println("GetPie");
        Report report = new Report("pie");
        try {
            assertEquals("This is a pie chart report", report.returnReport());
        } catch (UnknownError e) {
            fail("No pie chart report was generated");
        }
        System.out.println("====================");
    }

    /**
     * Test of getSum of ReportingBean module
     */
    @Test
    public void testGetSum() throws Exception {
        System.out.println("====================");
        System.out.println("GetSum");
        try {
            Report report = new Report("sum");
            assertEquals("This is a summary report", report.returnReport());
            System.out.println("====================");
        } catch (UnknownError e) {
            fail("No summary report was generated");
        }
    }
}
