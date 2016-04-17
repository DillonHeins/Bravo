package bravopeople;

import junit.framework.TestCase;

public class PersonTest extends TestCase
{
    public PersonTest(String testName){ super(testName); }

    /**
     *
     * TODO: Add proper tests once code is in place.
     * Tests
     *  - Contructor params are same as gets
     */
    public void testPerson()
    {
        Person test = new Person("name", "surname", "id", "email");
        assertEquals("name", test.getName());
        assertEquals("surname", test.getSurname());
        assertEquals("id", test.getID());
        assertEquals("email", test.getEmail());
    }
}
