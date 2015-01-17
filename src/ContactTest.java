import static org.junit.Assert.*;

import org.junit.Test;

public class ContactTest {

  @Test
  public void testContact() {
    Address address = new Address("1 East 1 St.", "",
        "New York", "NY", "10001");
    PhoneNumber phoneNumber = new PhoneNumber(555, 44, 1234);
    Contact contact = new Contact("Darren Levy", "darren@nyu.edu",
       phoneNumber, "test", address);
    assertTrue(contact.equals(contact));
    assertEquals("Darren Levy", contact.getName());
    assertEquals("darren@nyu.edu", contact.getEmail());
    assertEquals("(555) 044-1234", contact.getPhoneNumber().toString());
    assertEquals("darren@nyu.edu", contact.getEmail());
    assertEquals("test", contact.getNote());
    assertEquals(address, contact.getAddress());
    try {
      contact.setEmail("tywin");
      fail("Should have thrown an IllegalArgumentException");
    } catch (Exception e) {
      assertEquals("darren@nyu.edu", contact.getEmail());
    }
  }
}
