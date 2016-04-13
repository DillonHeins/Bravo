/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cs.teambravo.publications.services;

import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import za.ac.cs.teambravo.publications.requestandresponses.AddPublicationRequest;
import za.ac.cs.teambravo.publications.requestandresponses.AddPublicationResponse;
import za.ac.cs.teambravo.publications.requestandresponses.AddPublicationTypeRequest;
import za.ac.cs.teambravo.publications.requestandresponses.AddPublicationTypeResponse;
import za.ac.cs.teambravo.publications.requestandresponses.CalcAccreditationPointsForGroupRequest;
import za.ac.cs.teambravo.publications.requestandresponses.CalcAccreditationPointsForGroupResponse;
import za.ac.cs.teambravo.publications.requestandresponses.CalcAccreditationPointsForPersonRequest;
import za.ac.cs.teambravo.publications.requestandresponses.CalcAccreditationPointsForPersonResponse;
import za.ac.cs.teambravo.publications.requestandresponses.ChangePublicationStateRequest;
import za.ac.cs.teambravo.publications.requestandresponses.ChangePublicationStateResponse;
import za.ac.cs.teambravo.publications.requestandresponses.CreatePublicationRequest;
import za.ac.cs.teambravo.publications.requestandresponses.CreatePublicationResponse;
import za.ac.cs.teambravo.publications.requestandresponses.GetPublicationRequest;
import za.ac.cs.teambravo.publications.requestandresponses.GetPublicationResponse;
import za.ac.cs.teambravo.publications.requestandresponses.GetPublicationsForGroupRequest;
import za.ac.cs.teambravo.publications.requestandresponses.GetPublicationsForGroupResponse;
import za.ac.cs.teambravo.publications.requestandresponses.GetPublicationsForPersonRequest;
import za.ac.cs.teambravo.publications.requestandresponses.GetPublicationsForPersonResponse;
import za.ac.cs.teambravo.publications.requestandresponses.ModifyPublicationTypeRequest;
import za.ac.cs.teambravo.publications.requestandresponses.ModifyPublicationTypeResponse;

/**
 *
 * @author Hlengekile
 */
public class PublicationsBeanTest {
    
    public PublicationsBeanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of businessMethod method, of class PublicationsBean.
     */
    @Test
    public void testBusinessMethod() throws Exception {
        System.out.println("businessMethod");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Publications instance = (Publications)container.getContext().lookup("java:global/classes/PublicationsBean");
        instance.businessMethod();
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPublication method, of class PublicationsBean.
     */
    @Test
    public void testAddPublication() throws Exception {
        System.out.println("addPublication");
        AddPublicationRequest addPublicationRequest = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Publications instance = (Publications)container.getContext().lookup("java:global/classes/PublicationsBean");
        AddPublicationResponse expResult = null;
        AddPublicationResponse result = instance.addPublication(addPublicationRequest);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPublication method, of class PublicationsBean.
     */
    @Test
    public void testGetPublication() throws Exception {
        System.out.println("getPublication");
        GetPublicationRequest getPublicationRequest = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Publications instance = (Publications)container.getContext().lookup("java:global/classes/PublicationsBean");
        GetPublicationResponse expResult = null;
        GetPublicationResponse result = instance.getPublication(getPublicationRequest);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createPublication method, of class PublicationsBean.
     */
    @Test
    public void testCreatePublication() throws Exception {
        System.out.println("createPublication");
        CreatePublicationRequest createPublicationRequest = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Publications instance = (Publications)container.getContext().lookup("java:global/classes/PublicationsBean");
        CreatePublicationResponse expResult = null;
        CreatePublicationResponse result = instance.createPublication(createPublicationRequest);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPublicationType method, of class PublicationsBean.
     */
    @Test
    public void testAddPublicationType() throws Exception {
        System.out.println("addPublicationType");
        AddPublicationTypeRequest addPublicationTypeRequest = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Publications instance = (Publications)container.getContext().lookup("java:global/classes/PublicationsBean");
        AddPublicationTypeResponse expResult = null;
        AddPublicationTypeResponse result = instance.addPublicationType(addPublicationTypeRequest);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifyPublicationType method, of class PublicationsBean.
     */
    @Test
    public void testModifyPublicationType() throws Exception {
        System.out.println("modifyPublicationType");
        ModifyPublicationTypeRequest modifyPublicationTypeRequest = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Publications instance = (Publications)container.getContext().lookup("java:global/classes/PublicationsBean");
        ModifyPublicationTypeResponse expResult = null;
        ModifyPublicationTypeResponse result = instance.modifyPublicationType(modifyPublicationTypeRequest);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPublicationsForPerson method, of class PublicationsBean.
     */
    @Test
    public void testGetPublicationsForPerson() throws Exception {
        System.out.println("getPublicationsForPerson");
        GetPublicationsForPersonRequest getPublicationsForPersonRequest = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Publications instance = (Publications)container.getContext().lookup("java:global/classes/PublicationsBean");
        GetPublicationsForPersonResponse expResult = null;
        GetPublicationsForPersonResponse result = instance.getPublicationsForPerson(getPublicationsForPersonRequest);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPublicationsForGroup method, of class PublicationsBean.
     */
    @Test
    public void testGetPublicationsForGroup() throws Exception {
        System.out.println("getPublicationsForGroup");
        GetPublicationsForGroupRequest getPublicationsForGroupRequest = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Publications instance = (Publications)container.getContext().lookup("java:global/classes/PublicationsBean");
        GetPublicationsForGroupResponse expResult = null;
        GetPublicationsForGroupResponse result = instance.getPublicationsForGroup(getPublicationsForGroupRequest);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcAccreditationPointsForPerson method, of class PublicationsBean.
     */
    @Test
    public void testCalcAccreditationPointsForPerson() throws Exception {
        System.out.println("calcAccreditationPointsForPerson");
        CalcAccreditationPointsForPersonRequest calcAccreditationPointsForPersonRequest = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Publications instance = (Publications)container.getContext().lookup("java:global/classes/PublicationsBean");
        CalcAccreditationPointsForPersonResponse expResult = null;
        CalcAccreditationPointsForPersonResponse result = instance.calcAccreditationPointsForPerson(calcAccreditationPointsForPersonRequest);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcAccreditationPointsForGroup method, of class PublicationsBean.
     */
    @Test
    public void testCalcAccreditationPointsForGroup() throws Exception {
        System.out.println("calcAccreditationPointsForGroup");
        CalcAccreditationPointsForGroupRequest calcAccreditationPointsForGroupRequest = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Publications instance = (Publications)container.getContext().lookup("java:global/classes/PublicationsBean");
        CalcAccreditationPointsForGroupResponse expResult = null;
        CalcAccreditationPointsForGroupResponse result = instance.calcAccreditationPointsForGroup(calcAccreditationPointsForGroupRequest);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changePublicationState method, of class PublicationsBean.
     */
    @Test
    public void testChangePublicationState() throws Exception {
        System.out.println("changePublicationState");
        ChangePublicationStateRequest changePublicationStateRequest = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Publications instance = (Publications)container.getContext().lookup("java:global/classes/PublicationsBean");
        ChangePublicationStateResponse expResult = null;
        ChangePublicationStateResponse result = instance.changePublicationState(changePublicationStateRequest);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
