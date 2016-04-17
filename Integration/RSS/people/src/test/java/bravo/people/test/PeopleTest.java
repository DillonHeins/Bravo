/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bravo.people.test;

import bravo.people.ejb.PeopleBean;
import bravo.people.entity.PersonEntity;
import bravo.people.implementations.Group;
import bravo.people.implementations.Organisation;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import bravo.people.implementations.Person;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.simple.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;
/**
 *
 * @author Dillon
 */
public class PeopleTest {
    private static PersonEntity mockPersonEntity;
    private static PeopleBean mockPeopleBean;
    
    @BeforeClass
    public static void setUp() {
        mockPersonEntity = mock(PersonEntity.class);
        mockPeopleBean = mock(PeopleBean.class);
        
        when(mockPeopleBean.addPerson("Piet", "Pieters", "14014457", "piet@gmail.com", "CIRG", "UP"))
                .thenReturn(true);
        
        when(mockPeopleBean.updatePerson("Pieter", "Pieters", "14778144", "piet@gmail.com", "ESPRESO", "UP"))
                .thenReturn(true);
        
        when(mockPeopleBean.getID("piet@gmail.com"))
                .thenReturn(105L);
        
        Map<String, String> map = new HashMap<>();
        map.put("piet@gmail.com", "Piet");
        map.put("bob@gmail.com", "Bobby");
        
        when(mockPeopleBean.getPeopleList()).thenReturn(map);
        
        Person person = new Person("Piet", "Pieters", "14014457", "piet@gmail.com");
        Group group = new Group("CIRG");
        Organisation organisation = new Organisation("UP");
        
        when(mockPersonEntity.getPerson()).thenReturn(person);
        when(mockPersonEntity.getGroup()).thenReturn(group);
        when(mockPersonEntity.getOrganisation()).thenReturn(organisation);
    }
    
    @Test
    public void testAddPerson() {
        assertEquals(true, mockPeopleBean.addPerson("Piet", "Pieters", "14014457", "piet@gmail.com", "CIRG", "UP"));
        
        assertEquals("Piet", mockPersonEntity.getPerson().getFirstName());
        assertEquals("Pieters", mockPersonEntity.getPerson().getSurname());
        assertEquals("14014457", mockPersonEntity.getPerson().getStaffNumber());
        assertEquals("piet@gmail.com", mockPersonEntity.getPerson().getEmail());
        assertEquals("CIRG", mockPersonEntity.getGroup().getName());
        assertEquals("UP", mockPersonEntity.getOrganisation().getName());
    }
    
    @Test
    public void testUpdatePerson() {
        assertEquals(true, mockPeopleBean.updatePerson("Pieter", "Pieters", "14778144", "piet@gmail.com", "ESPRESO", "UP"));
        
        assertEquals("Piet", mockPersonEntity.getPerson().getFirstName());
        assertEquals("Pieters", mockPersonEntity.getPerson().getSurname());
        assertEquals("14014457", mockPersonEntity.getPerson().getStaffNumber());
        assertEquals("piet@gmail.com", mockPersonEntity.getPerson().getEmail());
        assertEquals("CIRG", mockPersonEntity.getGroup().getName());
        assertEquals("UP", mockPersonEntity.getOrganisation().getName());
    }
    
    @Test
    public void testGetID() {
        Long l = 105L;
        assertEquals(l, mockPeopleBean.getID("piet@gmail.com"));
    }
    
    @Test
    public void testGetPerson() {
        assertEquals("Piet", mockPersonEntity.getPerson().getFirstName());
        assertEquals("Pieters", mockPersonEntity.getPerson().getSurname());
        assertEquals("14014457", mockPersonEntity.getPerson().getStaffNumber());
        assertEquals("piet@gmail.com", mockPersonEntity.getPerson().getEmail());
        assertEquals("CIRG", mockPersonEntity.getGroup().getName());
        assertEquals("UP", mockPersonEntity.getOrganisation().getName());
    }
    
    @Test
    public void testGetPeopleList() {
        Map map = mockPeopleBean.getPeopleList();
        
        Map<String, String> temp = new HashMap<>();
        temp.put("piet@gmail.com", "Piet");
        temp.put("bob@gmail.com", "Bobby");
        
        assertEquals(temp ,map);
    }
}
