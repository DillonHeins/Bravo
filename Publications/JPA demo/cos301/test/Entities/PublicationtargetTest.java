/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author moses
 */
public class PublicationtargetTest {
    
    public PublicationtargetTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() 
    {
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Publicationtarget.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("cos301PU"); 
        EntityManager manager=factory.createEntityManager();
        TypedQuery<Publicationtarget> query= manager.createNamedQuery("Publicationtarget.findByName",Publicationtarget.class);
        query.setParameter("name", "Google");        
        List results=query.getResultList();
        Publicationtarget f1=(Publicationtarget) results.get(0); 
        
        //Publicationtarget instance = new Publicationtarget();
        Integer expResult = 4;
        Integer result = f1.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Publicationtarget.
     */
    /*@Test
    public void testSetId() {
        System.out.println("setId");
        Integer id = null;
        Publicationtarget instance = new Publicationtarget();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of getName method, of class Publicationtarget.
     */
    /*@Test
    public void testGetName() {
        System.out.println("getName");
        Publicationtarget instance = new Publicationtarget();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of setName method, of class Publicationtarget.
     */
    /*@Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Publicationtarget instance = new Publicationtarget();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of getWebsite method, of class Publicationtarget.
     */
    /*@Test
    public void testGetWebsite() {
        System.out.println("getWebsite");
        Publicationtarget instance = new Publicationtarget();
        String expResult = "";
        String result = instance.getWebsite();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of setWebsite method, of class Publicationtarget.
     */
    /*@Test
    public void testSetWebsite() {
        System.out.println("setWebsite");
        String website = "";
        Publicationtarget instance = new Publicationtarget();
        instance.setWebsite(website);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of hashCode method, of class Publicationtarget.
     */
    /*@Test
    public void testHashCode() {
        System.out.println("hashCode");
        Publicationtarget instance = new Publicationtarget();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of equals method, of class Publicationtarget.
     */
    /*@Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Publicationtarget instance = new Publicationtarget();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of toString method, of class Publicationtarget.
     */
    //@Test
    /*public void testToString() {
        System.out.println("toString");
        Publicationtarget instance = new Publicationtarget();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
