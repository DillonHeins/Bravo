/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bravo.people.test;

import bravo.people.entity.PersonEntity;
import bravo.people.implementations.Group;
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
    private static PersonEntity mockPerson;
    
    @BeforeClass
    public static void setUp() {
        mockPerson = mock(PersonEntity.class);
        
        Person person = new Person("Dillon", "Heins", "14035538", "dheins@gmail.com");
        Group group = new Group("CIRG");
        
        when(mockPerson.getPerson()).thenReturn(person);
        when(mockPerson.getGroup()).thenReturn(group);
    }
    
    @Test
    public void testGetPerson() {
        assertEquals("Dillon", mockPerson.getPerson().getFirstName());
        assertEquals("Heins", mockPerson.getPerson().getSurname());
        assertEquals("14035538", mockPerson.getPerson().getStaffNumber());
        assertEquals("dheins@gmail.com", mockPerson.getPerson().getEmail());
        assertEquals("CIRG", mockPerson.getGroup().getName());
    }
}
