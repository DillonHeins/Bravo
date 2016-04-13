/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bravo.people.test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import bravo.people.implementations.Person;
import org.junit.BeforeClass;
import org.junit.Test;
/**
 *
 * @author Dillon
 */
public class PeopleTest {
    private static Person mockPerson;
    
    @BeforeClass
    public static void setUp() {
        mockPerson = mock(Person.class);
        
        when(mockPerson.getFirstName()).thenReturn("Dillon");
        when(mockPerson.getSurname()).thenReturn("Heins");
        when(mockPerson.getStaffNumber()).thenReturn("14035538");
        when(mockPerson.getEmail()).thenReturn("dheins@gmail.com");
    }
    
    @Test
    public void testGetPerson() {
        assertEquals("Dillon", mockPerson.getFirstName());
        assertEquals("Heins", mockPerson.getSurname());
        assertEquals("14035538", mockPerson.getStaffNumber());
        assertEquals("dheins@gmail.com", mockPerson.getEmail());
    }
}
